package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Comentario;
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

/**
 * Created by inftel06 on 19/3/15.
 */
public class PostComentarioTask extends AsyncTask<Void,Void,Boolean>{

    private Comentario comentario;
    private  Activity activity;
    public PostComentarioTask(Comentario comentario,Activity activity){
        this.comentario=comentario;
        this.activity=activity;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        boolean estado = false;
        try {
            String uri = Conexion.SOCIAL_SERVER + Conexion.COMMENT_RESOURCE;
            Gson gson = new Gson();
            String json = gson.toJson(comentario, Comentario.class);
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
            Toast.makeText(activity, activity.getString(R.string.verificar_comentario_insertado), Toast.LENGTH_LONG).show();
        }
        else{
            Toast.makeText(activity, activity.getString(R.string.error_comentario), Toast.LENGTH_LONG).show();
        }
    }
}
