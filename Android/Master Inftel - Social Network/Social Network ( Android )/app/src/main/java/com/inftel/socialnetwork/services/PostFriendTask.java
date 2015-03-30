package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.ProfileActivity;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.entity.Usuario;
import com.inftel.socialnetwork.utility.Conexion;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicHeader;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * Created by inftel09 on 25/3/15.
 */
public class PostFriendTask extends AsyncTask<Void,Void,String> {

    private Friends amigo;
    private Activity activity;
    private ProgressDialog progressDialog;
    private Usuario usuario;

    public PostFriendTask(Friends amigo,Activity activity,ProgressDialog progressDialog,Usuario usuario) {
        this.amigo = amigo;
        this.activity = activity;
        this.progressDialog = progressDialog;
        this.usuario =usuario;
    }

    @Override
    protected String doInBackground(Void... params) {
        String resultado="";
        try{
            String uri = Conexion.SOCIAL_SERVER + Conexion.FRIENDS_RESOURCE;
            Gson gson = new Gson();
            Boolean estado=false;

            String json = gson.toJson(amigo, Friends.class);
            HttpPost httpPost = new HttpPost(uri);
            StringEntity entity = new StringEntity(json.toString(), "UTF-8");
            entity.setContentType("application/json;charset=UTF-8");
            entity.setContentEncoding(new BasicHeader(HTTP.CONTENT_TYPE,"application/json;charset=UTF-8"));
            httpPost.setEntity(entity);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            HttpResponse response = new DefaultHttpClient().execute(httpPost);
            estado = response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
            if(estado){
               resultado=EntityUtils.toString(response.getEntity(),"UTF-8");
            }

        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    protected void onPostExecute(String result) {
        super.onPostExecute(result);
        if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.ProfileActivity")){
            if(!result.equals("")){
                Intent intentLocal = new Intent(activity.getApplicationContext(), ProfileActivity.class);
                Gson gson = new Gson();
                String profile = gson.toJson(usuario,Usuario.class);
                intentLocal.putExtra("profile",profile);
                intentLocal.putExtra("amigoId",result);
                activity.startActivity(intentLocal);
            }
            else {
                Toast.makeText(activity, activity.getString(R.string.error_anadir_amigo_), Toast.LENGTH_LONG).show();
            }
            if (progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
    }
}
