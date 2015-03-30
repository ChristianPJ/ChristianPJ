package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.ProfileActivity;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.utility.Conexion;
import com.inftel.socialnetwork.utility.SimpleArrayAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class FriendsListAsyncTask extends AsyncTask<Void, Void, List<Friends>> {

    private Activity activity;
    private String email;
    private ProgressDialog progressDialog;
    private String nombregrupo;
    private List <Friends> amigosSeleccionados;

    public FriendsListAsyncTask(Activity activity, String email, ProgressDialog progressDialog,String nombregrupo, List<Friends> amigosSeleccionados){
        this.activity = activity;
        this.email = email;
        this.progressDialog = progressDialog;
        this.nombregrupo = nombregrupo;
        this.amigosSeleccionados = amigosSeleccionados;
    }

    @Override
    protected List<Friends> doInBackground(Void... params){

        List <Friends> friendsList=null;
        try{

            email = email.replaceAll("\\.","___");

            String uri = Conexion.SOCIAL_SERVER + Conexion.FRIENDS_RESOURCE + "findfriendsbyemail/" + email;
            HttpClient httpclient = new DefaultHttpClient();
            HttpGet httpGet = new HttpGet(uri);
            httpGet.setHeader("Accept", "application/json");
            httpGet.setHeader("Content-Type", "application/json");
            Type listType = new TypeToken<ArrayList<Friends>>() {
            }.getType();
            HttpResponse response = httpclient.execute(httpGet);
            Gson gson = new Gson();
            friendsList = gson.fromJson(EntityUtils.toString(response.getEntity(),"UTF-8"),listType);
            response.getStatusLine().getStatusCode();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return friendsList;
    }

    @Override
    protected void onPostExecute(List<Friends> friendsList) {
        super.onPostExecute(friendsList);


        final List<Friends> newFriendsList = friendsList;

        if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.FriendsListActivity")){
            if(newFriendsList!=null && newFriendsList.size()!=0 ){

                ListView friendsListView = (ListView) activity.findViewById(R.id.friendsList);

                SimpleArrayAdapter adapter = new SimpleArrayAdapter(activity,friendsList,amigosSeleccionados, activity);
                friendsListView.setAdapter(adapter);

                friendsListView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                                new RequestUserTask(activity,newFriendsList.get(position).getFriendEmail(),2, true).execute();

                            }
                        });

            }
            else{

                Toast.makeText(activity, "No tienes amigos", Toast.LENGTH_LONG).show();
            }
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }

        } else if (activity.getClass().getName().equals("com.inftel.socialnetwork.activity.NewGroupMembersActivity")){
            if(newFriendsList!=null && newFriendsList.size()!=0){
                new RequestGroupTask(nombregrupo,activity,RequestGroupTask.BY_NAME,progressDialog,newFriendsList,amigosSeleccionados,null,null).execute();
            }
            else{
                Toast.makeText(activity, "No tienes amigos para invitar", Toast.LENGTH_LONG).show();
            }
            if (progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }


    }


}
