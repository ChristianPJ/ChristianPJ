package com.inftel.socialnetwork.services;

import android.os.AsyncTask;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;

public class DeleteComentarioTask extends AsyncTask<String,Integer,String>{

    @Override
    protected String doInBackground(String... urls) {

        HttpClient httpClient = new DefaultHttpClient();
        HttpDelete delete= new HttpDelete(urls[0]);
        delete.setHeader("content-type", "application/json");
        try
        {
            httpClient.execute(delete);

        }
        catch(IOException ex)
        {
            ex.printStackTrace();
        }

        return null;
    }
}
