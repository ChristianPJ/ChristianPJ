package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.MainActivity;
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
public class DeleteGroupTask extends AsyncTask<Void,Void,Boolean> {

    private String groupName;
    private String email;
    private Activity activity;

    public DeleteGroupTask(String groupName,String email,Activity activity){
        this.groupName = groupName;
        this.email = email;
        this.activity = activity;
    }

    @Override
    protected Boolean doInBackground(Void... params) {
        boolean estado = false;

        email = email.replaceAll("\\.","___");
        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete delete= new HttpDelete(Conexion.SOCIAL_SERVER+Conexion.GROUPS_RESOURCE+"deletebyemailandname/"+email+"/"+groupName);
        delete.setHeader("content-type", "application/json");
        //   String id = txtId.getText().toString();

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
    protected void onPostExecute(Boolean result) {
        super.onPostExecute(result);
        if (result){
            Intent intentLocal = new Intent(activity.getApplicationContext(), MainActivity.class);
            activity.startActivity(intentLocal);
        }
        else{
            Toast.makeText(activity, activity.getString(R.string.error_eliminar_grupo), Toast.LENGTH_LONG).show();
        }
    }
}
