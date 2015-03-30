package com.inftel.museoinftel.service;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.inftel.museoinftel.entity.Minijuego;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class RequestQuizTask extends AsyncTask<String, Integer, List<Minijuego>> {

    protected List<Minijuego> doInBackground(String... urls) {

        List<Minijuego> listMinijuego = new ArrayList<Minijuego>();
        try{
            HttpClient client = new DefaultHttpClient();
            URI website = new URI(urls[0]);
            HttpGet request = new HttpGet();
            request.setURI(website);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-Type", "application/json");
            Type listType = new TypeToken<ArrayList<Minijuego>>() {
            }.getType();
            HttpResponse response = client.execute(request);
            Gson gson = new GsonBuilder().create();
            listMinijuego = gson.fromJson(EntityUtils.toString(response.getEntity(),"UTF-8"),listType);
            response.getStatusLine().getStatusCode();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
        return listMinijuego;
    }
}
