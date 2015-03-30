package com.inftel.socialnetwork.activity;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuItem;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.services.FriendsListAsyncTask;
import com.inftel.socialnetwork.services.RequestUserTask;
import com.inftel.socialnetwork.utility.NavigationAdapter;

public class FriendsListActivity extends ActionBarActivity {

    String emailUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_friends_list);

        NavigationAdapter.drawNavigationDrawer(this);

        ProgressDialog progress = new ProgressDialog(this);
        progress.setTitle("Loading");
        progress.setMessage("Wait while loading...");
        progress.show();

        SharedPreferences prefs = this.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
        emailUsuario = prefs.getString("emailUsuario","");

        new FriendsListAsyncTask(this,emailUsuario,progress,null,null).execute();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_friends_list, menu);
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
}
