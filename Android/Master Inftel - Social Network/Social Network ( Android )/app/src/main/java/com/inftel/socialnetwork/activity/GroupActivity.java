package com.inftel.socialnetwork.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.services.CommentsListAsyncTask;
import com.inftel.socialnetwork.services.DeleteGroupTask;
import com.inftel.socialnetwork.services.DropboxServiceGetPhoto;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;
import com.inftel.socialnetwork.utility.RoundedImageView;

public class GroupActivity extends ActionBarActivity {

    String group;
    String imageGroup;
    Bitmap bitmap;
    private DropboxConnnection dropboxConnnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            group = extras.getString("group");
            imageGroup=extras.getString("imageGroup");
        }
        // Conectar con  Dropbox

        dropboxConnnection = new DropboxConnnection(this);
        dropboxConnnection.connect();


        final TextView groupText = (TextView) findViewById(R.id.nombre);
        groupText.setText(group);

        ImageView imagecomment = (ImageView) findViewById(R.id.imagen);
        String nameImage = imageGroup;

       Bitmap bitmap = ((BitmapDrawable)imagecomment.getDrawable()).getBitmap();

        RoundedImageView roundedImageView = new RoundedImageView(this);
        if(bitmap!=null){
            Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(bitmap, 450);
            bitmap = croppedBitmap;
        }

        imagecomment.setImageBitmap(bitmap);

        if ((nameImage!=null)&&(!nameImage.equals(""))){
            DropboxServiceGetPhoto dropboxServiceGetPhoto = new DropboxServiceGetPhoto(this, dropboxConnnection.getmDBApi(), nameImage,imagecomment);
            dropboxServiceGetPhoto.execute();
        }




        new CommentsListAsyncTask(this,group,3,dropboxConnnection).execute();
        NavigationAdapter.drawNavigationDrawer(this);


    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_group, menu);
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

            case R.id.action_leave_group:
                SharedPreferences prefs = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
                String email ="";
                if(prefs.contains("emailUsuario")){
                    email = prefs.getString("emailUsuario","");
                }
                new DeleteGroupTask(group,email,this).execute();
                return true;

            case R.id.action_add_friend:
                Intent intentLocal = new Intent(this, NewGroupMembersActivity.class);
                intentLocal.putExtra("nombregrupo",group);
                intentLocal.putExtra("fotogrupo",imageGroup);
                startActivity(intentLocal);
                return true;

            case R.id.action_search:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }




    }
}
