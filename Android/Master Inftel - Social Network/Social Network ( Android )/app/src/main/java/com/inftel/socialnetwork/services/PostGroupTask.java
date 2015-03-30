package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.GroupActivity;
import com.inftel.socialnetwork.activity.NewGroupMembersActivity;
import com.inftel.socialnetwork.entity.Groups;
import com.inftel.socialnetwork.utility.Conexion;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.acl.Group;

/**
 * Created by inftel11 on 19/3/15.
 */
public class PostGroupTask extends AsyncTask<Void,Void,Boolean> {
    private Groups groups;
    private Activity activity;
    private ProgressDialog progressDialog;

    public PostGroupTask(Groups groups, Activity activity, ProgressDialog progressDialog){
        this.groups=groups;
        this.activity=activity;
        this.progressDialog = progressDialog;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        boolean estado = false;
        try{
            String uri = Conexion.SOCIAL_SERVER + Conexion.GROUPS_RESOURCE;
            Gson gson = new Gson();
            String json = gson.toJson(groups, Groups.class);
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity(json.toString(), "UTF-8");
            entity.setContentType("application/json;charset=UTF-8");
            entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = new DefaultHttpClient().execute(httpPost);
            estado = response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return estado;
    }

    @Override
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        if(result){
            if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.NewGroupActivity")) {
                if (progressDialog!=null && progressDialog.isShowing()){
                    progressDialog.dismiss();
                }

                Intent intentLocal = new Intent(activity.getApplicationContext(), NewGroupMembersActivity.class);
                intentLocal.putExtra("nombregrupo",groups.getName());
                intentLocal.putExtra("fotogrupo",groups.getImageUrl());
                activity.startActivity(intentLocal);
            }
        }
        else {
            Toast.makeText(activity, activity.getString(R.string.error_grupo), Toast.LENGTH_LONG).show();
        }
    }
}
