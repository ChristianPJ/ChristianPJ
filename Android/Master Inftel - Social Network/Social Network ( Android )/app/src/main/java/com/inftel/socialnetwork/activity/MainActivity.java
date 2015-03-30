package com.inftel.socialnetwork.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.services.CommentsListAsyncTask;
import com.inftel.socialnetwork.services.DownloadImageTask;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;

public class MainActivity extends ActionBarActivity {

    private String email,codigoQR;
    private String nombreUsuario=null;
    private ImageView imagenUser;
    private String fotoUser=null;
    private TextView nombre;
    private DropboxConnnection dropboxConnnection;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);


        // Conectar con  Dropbox

        dropboxConnnection = new DropboxConnnection(this);
        dropboxConnnection.connect();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            codigoQR = extras.getString("qr");
            new RequestUserTask(this,codigoQR,1, false).execute();
        }

        SharedPreferences prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
        if(prefs.contains(GooglePlayServicesActivity.USER_KEY)){
            email = prefs.getString(GooglePlayServicesActivity.USER_KEY,"");
            new RequestUserTask(this,email,2, false).execute();
        }

        if(prefs.contains("nombreUsuario")){
            nombreUsuario = prefs.getString("nombreUsuario","");
        }


        if(prefs.contains("fotoUsuario")){
            fotoUser = prefs.getString("fotoUsuario","");
        }

        nombre=(TextView)findViewById(R.id.nombre);
        nombre.setText(nombreUsuario);

        imagenUser=(ImageView)findViewById(R.id.imagen);
        new DownloadImageTask(this,imagenUser).execute(fotoUser);


        new CommentsListAsyncTask(this,email,1,dropboxConnnection).execute();

        NavigationAdapter.drawNavigationDrawer(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

        switch (item.getItemId()) {
            case R.id.action_search:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }

    }


    @Override
    public void onResume(){
        super.onResume();
        dropboxConnnection.resume();
    }

}