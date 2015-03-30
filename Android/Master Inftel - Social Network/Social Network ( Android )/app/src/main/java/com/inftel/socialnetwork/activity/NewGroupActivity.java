package com.inftel.socialnetwork.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.media.ExifInterface;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.services.RequestGroupTask;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;
import com.inftel.socialnetwork.utility.RoundedImageView;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;


public class NewGroupActivity extends ActionBarActivity {

    Button btnNewGroup;
    ImageView imageview;
    RoundedImageView roundedImageView;
    final CharSequence[] items = { "Hacer foto", "Elegir desde galería"};

    static final int REQUEST_CAMERA = 1;
    static final int SELECT_FILE = 2;

    private File fileImage = null;
    private String nameImage="";
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group);

        NavigationAdapter.drawNavigationDrawer(this);

        prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        imageview = (ImageView) findViewById(R.id.imageView);
        int imageResource = getResources().getIdentifier("@drawable/blank_avatar", null, getPackageName());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResource);
        roundedImageView = new RoundedImageView(getApplicationContext());
        Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(bitmap, 450);
        imageview.setImageBitmap(croppedBitmap);

        imageview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                obtenerFoto();
            }
        });



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new_group, menu);
        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView = (SearchView) searchItem.getActionView();
        searchView.setQueryHint(getString(R.string.search_user_hint));
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {

            @Override
            public boolean onQueryTextSubmit(String s) {
                searchUserByEmail(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }

        });

        return super.onCreateOptionsMenu(menu);
    }

    private void searchUserByEmail(String email){

        new RequestUserTask(this,email,2, true).execute();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        switch (item.getItemId()) {
            case R.id.action_search:
                return true;




            default:
                return super.onOptionsItemSelected(item);
        }
    }





    public void crearGrupo(View view){
        EditText nombretxt = (EditText) findViewById(R.id.editText2);
        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();
        new RequestGroupTask(nombretxt.getText().toString(),this,RequestGroupTask.BY_NAME,progress,null,null,fileImage,nameImage).execute();


    }

    public void obtenerFoto(){

        AlertDialog.Builder builder = new AlertDialog.Builder(NewGroupActivity.this);
        builder.setTitle("Elegir foto");
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                if (items[item].equals("Hacer foto")) {
                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                    File f = new File(android.os.Environment
                            .getExternalStorageDirectory(), "temp.jpg");
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
                    startActivityForResult(intent, REQUEST_CAMERA);
                } else if (items[item].equals("Elegir desde galería")) {
                    Intent intent = new Intent(
                            Intent.ACTION_PICK,
                            android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                    intent.setType("image/*");
                    startActivityForResult(
                            Intent.createChooser(intent, "Elige foto"),
                            SELECT_FILE);
                }
            }
        });
        builder.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                File f = new File(Environment.getExternalStorageDirectory()
                        .toString());
                for (File temp : f.listFiles()) {
                    if (temp.getName().equals("temp.jpg")) {
                        f = temp;
                        break;
                    }
                }
                try {
                    Bitmap bm;
                    BitmapFactory.Options btmapOptions = new BitmapFactory.Options();

                    bm = BitmapFactory.decodeFile(f.getAbsolutePath(),
                            btmapOptions);



                    String path = Environment.getExternalStorageDirectory()
                            + File.separator
                            + "Social+";
                    File fileDir = new File(path);
                    if (!fileDir.exists()){
                        fileDir.mkdir();
                    }


                    OutputStream fOut = null;

                    String email = prefs.getString("emailUsuario","");
                    String emailSub = email.substring(0, email.indexOf('@'));


                    fileImage = new File(this.getFilesDir().getPath()+File.separator, emailSub+String.valueOf(System
                            .currentTimeMillis()) + ".jpg");

                    fileImage.createNewFile();

                    nameImage = fileImage.getName();

                    try {
                        setPic(f.getAbsolutePath());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    f.delete();

                    Log.i("TAG", fileImage.getName());
                    /*try {
                        fOut = new FileOutputStream(fileImage);
                        bm.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
                        fOut.flush();
                        fOut.close();
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }*/
                } catch (Exception e) {
                    e.printStackTrace();
                }




            } else if (requestCode == SELECT_FILE) {
                Uri selectedImageUri = data.getData();

                String tempPath = getPath(selectedImageUri, NewGroupActivity.this);



                String email = prefs.getString("emailUsuario","");
                //String email = "parejajensen@gmail.com";
                String emailSub = email.substring(0, email.indexOf('@'));

                nameImage = emailSub+String.valueOf(System.currentTimeMillis() + ".jpg");

                fileImage = new File(tempPath);

                Log.i("TAG", fileImage.getName());
                try {
                    setPic(fileImage.getPath());
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }

    public String getPath(Uri uri, Activity activity) {
        String[] projection = { MediaStore.MediaColumns.DATA };
        Cursor cursor = activity
                .managedQuery(uri, projection, null, null, null);
        int column_index = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA);
        cursor.moveToFirst();
        return cursor.getString(column_index);
    }




    private void setPic(String mCurrentPhotoPath) throws IOException {
        // Get the dimensions of the View
        int targetW = imageview.getWidth();
        int targetH = imageview.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min((photoW / targetW), (photoH / targetH));

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        //bmOptions.inScaled = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        ExifInterface ei = new ExifInterface(mCurrentPhotoPath);
        int orientation = ei.getAttributeInt(ExifInterface.TAG_ORIENTATION, ExifInterface.ORIENTATION_NORMAL);

        Matrix matrix;
        Bitmap rotatedBitmap = null;

        Log.i("CAMARA", String.valueOf(orientation));

        switch(orientation) {
            case ExifInterface.ORIENTATION_ROTATE_90:
                Log.i("CAMARA","ENTRA 90");

                matrix = new Matrix();
                matrix.postRotate(90);
                rotatedBitmap = Bitmap.createBitmap(bitmap , 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                break;
            case ExifInterface.ORIENTATION_ROTATE_180:
                Log.i("CAMARA","ENTRA 180");
                matrix = new Matrix();
                matrix.postRotate(180);
                rotatedBitmap = Bitmap.createBitmap(bitmap , 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                break;
        }

        if (rotatedBitmap==null){
            rotatedBitmap=bitmap;
        }

        Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(rotatedBitmap,450);
        imageview.setImageBitmap(croppedBitmap);



        FileOutputStream fOut = new FileOutputStream(fileImage);

        rotatedBitmap.compress(Bitmap.CompressFormat.JPEG, 100, fOut);
        fOut.flush();
        fOut.close();
    }



}
