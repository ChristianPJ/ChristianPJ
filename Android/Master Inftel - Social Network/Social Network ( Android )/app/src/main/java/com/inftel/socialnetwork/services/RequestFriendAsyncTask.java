package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.Menu;
import android.view.MenuItem;

import com.google.gson.Gson;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.ProfileActivity;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.entity.Usuario;
import com.inftel.socialnetwork.utility.Conexion;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

/**
 * Created by inftel09 on 25/3/15.
 */
public class RequestFriendAsyncTask extends AsyncTask<Void,Void,Friends> {
    private Usuario usuario;
    private Activity activity;

    public RequestFriendAsyncTask(Usuario usuario, Activity activity){
        this.usuario=usuario;
        this.activity=activity;
    }
    @Override
    protected Friends doInBackground(Void... params) {

        Friends friend=null;
        try{

            String email = usuario.getEmail();
            email = email.replaceAll("\\.","___");
            String myEmail=null;

            SharedPreferences prefs = activity.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);
            if(prefs.contains("emailUsuario")){
                myEmail = (prefs.getString("emailUsuario",""));
                myEmail = myEmail.replaceAll("\\.","___");
            }
            HttpClient client = new DefaultHttpClient();
            URI website = new URI(Conexion.SOCIAL_SERVER+Conexion.FRIENDS_RESOURCE+"findfriendsbyemails/"+myEmail+"/"+email);
            HttpGet request = new HttpGet();
            request.setURI(website);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-Type", "application/json");
            HttpResponse response = client.execute(request);
            Gson gson= new Gson();
            friend = gson.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"),Friends.class);
            response.getStatusLine().getStatusCode();
        }catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return friend;
    }

    @Override
    protected void onPostExecute(Friends friend) {
        super.onPostExecute(friend);
        Gson gson= new Gson();
        Intent intentLocal = new Intent(activity.getApplicationContext(), ProfileActivity.class);
        String profile = gson.toJson(usuario,Usuario.class);
        intentLocal.putExtra("profile",profile);
        if (friend!=null){
            intentLocal.putExtra("amigoId",friend.getId());
        }
        else {
            intentLocal.putExtra("amigoId","");
        }
        activity.startActivity(intentLocal);
    }
}
