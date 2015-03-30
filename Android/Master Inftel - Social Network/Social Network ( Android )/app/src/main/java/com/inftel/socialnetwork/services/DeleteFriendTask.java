package com.inftel.socialnetwork.services;

import android.app.Activity;
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
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

/**
 * Created by inftel09 on 25/3/15.
 */
public class DeleteFriendTask extends AsyncTask<Void,Void,Boolean> {

    private String amigoId;
    private Activity activity;
    private Usuario usuario;

    public DeleteFriendTask(String amigoId,Activity activity,Usuario usuario){
        this.amigoId=amigoId;
        this.activity=activity;
        this.usuario = usuario;
    }

    @Override
    protected Boolean doInBackground(Void... params) {

        boolean estado = false;

        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete delete= new HttpDelete(Conexion.SOCIAL_SERVER+Conexion.FRIENDS_RESOURCE+"deleteid/"+amigoId);
        delete.setHeader("content-type", "application/json");

        try
        {
            HttpResponse response = httpClient.execute(delete);
            estado = response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

        return estado;
    }

    @Override
    protected void onPostExecute(Boolean resultado) {
        super.onPostExecute(resultado);
        if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.ProfileActivity")){
            if(resultado){
                Intent intentLocal = new Intent(activity.getApplicationContext(), ProfileActivity.class);
                Gson gson = new Gson();
                String profile = gson.toJson(usuario,Usuario.class);
                intentLocal.putExtra("profile",profile);
                intentLocal.putExtra("amigoId","");
                activity.startActivity(intentLocal);
            }
            else{
                Toast.makeText(activity, activity.getString(R.string.error_eliminar_amigo), Toast.LENGTH_LONG).show();
            }
        }


    }
}
