package com.inftel.socialnetwork.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.entity.Groups;
import com.inftel.socialnetwork.services.FriendsListAsyncTask;
import com.inftel.socialnetwork.services.PostGroupTask;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewGroupMembersActivity extends ActionBarActivity {

    private String nombregrupo, fotogrupo;

    public List<Friends> amigosSeleccionados;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_group_members);
        amigosSeleccionados = new ArrayList<>();
        Bundle extras = getIntent().getExtras();
        nombregrupo = extras.getString("nombregrupo");
        fotogrupo = extras.getString("fotogrupo");
        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        NavigationAdapter.drawNavigationDrawer(this);

        prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        new FriendsListAsyncTask(this,prefs.getString("emailUsuario",""),progress,nombregrupo,amigosSeleccionados).execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


         getMenuInflater().inflate(R.menu.menu_new_group_members, menu);
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



            case R.id.action_save:
                for(Friends amigoSeleccionado:amigosSeleccionados){
                    Groups group = new Groups();
                    group.setCreador(false);
                    group.setEmail(amigoSeleccionado.getFriendEmail());
                    group.setFotoUrl(amigoSeleccionado.getFriendPhoto());
                    group.setImageUrl(fotogrupo);
                    group.setName(nombregrupo);
                    group.setUsername(amigoSeleccionado.getFriendName());
                    new PostGroupTask(group,this,null).execute();

                }
                Intent intentLocal = new Intent(getApplicationContext(), GroupActivity.class);
                intentLocal.putExtra("group",nombregrupo);
                intentLocal.putExtra("imageGroup",fotogrupo);
                startActivity(intentLocal);
                return true;

            case R.id.action_search:
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
