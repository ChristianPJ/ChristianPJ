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
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Comentario;
import com.inftel.socialnetwork.services.DropboxService;
import com.inftel.socialnetwork.services.PostComentarioTask;
import com.inftel.socialnetwork.services.RequestGroupTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;
import com.inftel.socialnetwork.utility.RoundedImageView;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

public class CommentActivity extends ActionBarActivity  {

    final CharSequence[] items = { "Hacer foto", "Elegir desde galería"};
    static final int REQUEST_CAMERA = 1;
    static final int SELECT_FILE = 2;
    private final int REQUEST_TECLADO = 3;
    private String emailUsuario;

    Spinner spinnerState;
    TextView tvState;


    private File fileImage = null;
    private String nameImage="";
    private String cadena;
    ImageView imageview;
    RoundedImageView roundedImageView;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);

        NavigationAdapter.drawNavigationDrawer(this);

        imageview = (ImageView) findViewById(R.id.imageView3);
        int imageResource = getResources().getIdentifier("@drawable/blank_avatar", null, getPackageName());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResource);
        roundedImageView = new RoundedImageView(getApplicationContext());
        Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(bitmap, 450);
        imageview.setImageBitmap(croppedBitmap);

        prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        if(prefs.contains("emailUsuario")){
            emailUsuario = prefs.getString("emailUsuario","");
        }
        new RequestGroupTask(emailUsuario, this, RequestGroupTask.BY_EMAIL, progress,null,null,null,null).execute();

        imageview.setOnClickListener(new View.OnClickListener() {


            @Override
            public void onClick(View v) {

                obtenerFoto();


            }
        });

        SharedPreferences prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
        cadena = prefs.getString("string","");

        EditText commentText = (EditText) findViewById(R.id.comment);
        commentText.setText(cadena.toString());


        Button btnKeyboard = (Button) findViewById(R.id.teclado);

        btnKeyboard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intentLocal = new Intent(getApplicationContext(), TecladoActivity.class);
                startActivityForResult(intentLocal,REQUEST_TECLADO);
            }
        });


        Button btnComment = (Button) findViewById(R.id.publicar);

        btnComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                insertComment();
            }
        });


    }

    public  void insertComment() {
        EditText commentTitle = (EditText) findViewById(R.id.title);
        String title = commentTitle.getText().toString();

        EditText commentText = (EditText) findViewById(R.id.comment);
        String text = commentText.getText().toString();

        EditText commentVideo = (EditText) findViewById(R.id.video);
        String video = commentVideo.getText().toString();

        CheckBox privado=(CheckBox) findViewById(R.id.privado);
        Boolean pulsado =privado.isChecked();
        spinnerState = (Spinner) findViewById(R.id.spinnerstate);
        String nombregrupo = (String) spinnerState.getSelectedItem();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        String creationDate = sdf.format(new Date(new java.util.Date().getTime()));

        Comentario comment = new Comentario();
        comment.setTitulo(title);
        // comment.setImagen(image);
        // guardar en dropbox
        if (fileImage!=null) {
            DropboxConnnection dropboxConnnection = new DropboxConnnection(this);
            dropboxConnnection.connect();
            DropboxService dropboxService = new DropboxService(this, dropboxConnnection.getmDBApi(), fileImage,nameImage);
            dropboxService.execute();
        }else{
            showToast("No hay Imagen");
        }

        // guardar nombre de la foto en la base de datos
        Log.i("Nombre",this.nameImage);
        comment.setImagen(this.nameImage);
        comment.setFecha(creationDate);
        comment.setPerfil(prefs.getString("emailUsuario",""));
        comment.setEmailUsuario(prefs.getString("emailUsuario",""));
        comment.setNombre(prefs.getString("nombreUsuario",""));
        comment.setApellido(prefs.getString("apellidoUsuario",""));
        comment.setImagenUsuario(prefs.getString("fotoUsuario",""));
        comment.setNombreGrupo(nombregrupo);

        comment.setPrivado(pulsado);
        if (text.equals("")){
            comment.setTexto(null);
        }else{
            comment.setTexto(text);
        }
        if (video.equals("")){
            comment.setVideo(null);
        }else{
            comment.setVideo(video);
        }



        new PostComentarioTask(comment, this).execute();

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_comment, menu);
        return true;

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {


        switch (item.getItemId()) {
            case R.id.action_cancel:

                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }

    public void obtenerFoto(){

        AlertDialog.Builder builder = new AlertDialog.Builder(CommentActivity.this);
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

                String tempPath = getPath(selectedImageUri, CommentActivity.this);



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

            }else if (requestCode == REQUEST_TECLADO){
                EditText txt = (EditText) findViewById(R.id.comment);
                txt.setText(data.getStringExtra("string"));
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


    private void showToast(String msg) {
        Toast error = Toast.makeText(this, msg, Toast.LENGTH_LONG);
        error.show();
    }



}
