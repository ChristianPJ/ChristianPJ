package com.inftel.socialnetwork.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Usuario;
import com.inftel.socialnetwork.services.RequestGroupTask;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class GroupsListActivity extends ActionBarActivity {
    private String emailUsuario=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_groups_list);

        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        NavigationAdapter.drawNavigationDrawer(this);
        SharedPreferences prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);


        if(prefs.contains("emailUsuario")){
            emailUsuario = prefs.getString("emailUsuario","");
        }
        new RequestGroupTask(emailUsuario, this, RequestGroupTask.BY_EMAIL, progress,null,null,null,null).execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.menu_groups_list, menu);
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

            case R.id.action_new_group:
                Intent intentLocal = new Intent(getApplicationContext(), NewGroupActivity.class);
                startActivity(intentLocal);
                return true;

            case R.id.action_search:
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
