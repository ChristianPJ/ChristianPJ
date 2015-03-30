package com.inftel.socialnetwork.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.entity.Usuario;
import com.inftel.socialnetwork.services.CommentsListAsyncTask;
import com.inftel.socialnetwork.services.DeleteFriendTask;
import com.inftel.socialnetwork.services.DownloadImageTask;
import com.inftel.socialnetwork.services.PostFriendTask;
import com.inftel.socialnetwork.services.RequestFriendAsyncTask;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;

public class ProfileActivity extends ActionBarActivity {
    private TextView nombre;
    Usuario usuario;
    String profile;
    String amigoId;

    private String nombreUsuario=null;
    private ImageView imagenUser;
    private String fotoUser=null;
    private DropboxConnnection dropboxConnnection;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        NavigationAdapter.drawNavigationDrawer(this);

        // Conectar con  Dropbox

        dropboxConnnection = new DropboxConnnection(this);
        dropboxConnnection.connect();

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            profile = extras.getString("profile");
            amigoId = extras.getString("amigoId");
        }

        Gson gson = new Gson();
        usuario = gson.fromJson(profile,Usuario.class);

        nombreUsuario=usuario.getNombre();
        fotoUser=usuario.getFoto();

        nombre=(TextView)findViewById(R.id.nombre);
        nombre.setText(nombreUsuario);

        imagenUser=(ImageView)findViewById(R.id.imagen);
        new DownloadImageTask(this,imagenUser).execute(fotoUser);


        new CommentsListAsyncTask(this,usuario.getEmail(),2,dropboxConnnection).execute();





    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);

        MenuItem anadirAmigo = menu.findItem(R.id.action_add_amigo);
        MenuItem quitarAmigo = menu.findItem(R.id.action_quit_amigo);
        if(amigoId.equals("")){
            anadirAmigo.setVisible(true);
            quitarAmigo.setVisible(false);
        }
        else{
            anadirAmigo.setVisible(false);
            quitarAmigo.setVisible(true);
        }
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

            case R.id.action_quit_amigo:
                new DeleteFriendTask(amigoId,this,usuario).execute();
                return true;

            case R.id.action_add_amigo:
                String myEmail=null;
                SharedPreferences prefs = getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
                if(prefs.contains("emailUsuario")){
                    myEmail=(prefs.getString("emailUsuario",""));
                }
                ProgressDialog progressDialog = new ProgressDialog(this);
                progressDialog.setTitle("Loading");
                progressDialog.setMessage("Wait while loading...");
                progressDialog.show();
                Friends friend = new Friends();
                friend.setFriendEmail(usuario.getEmail());
                friend.setFriendName(usuario.getNombre());
                friend.setFriendPhoto(usuario.getFoto());
                friend.setUserEmail(myEmail);
                new PostFriendTask(friend,this,progressDialog,usuario).execute();
                return true;

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
