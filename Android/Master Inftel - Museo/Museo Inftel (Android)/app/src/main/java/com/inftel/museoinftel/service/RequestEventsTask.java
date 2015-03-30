package com.inftel.museoinftel.service;

import android.app.Activity;
import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.inftel.museoinftel.R;
import com.inftel.museoinftel.entity.Evento;
import com.squareup.picasso.Picasso;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Type;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RequestEventsTask extends AsyncTask<String, Integer, List<Evento>>{

    private static final String TAG = "error";
    private View view;
    private Activity activity;
    private DropboxAPI<AndroidAuthSession> dropbox;

    public RequestEventsTask(View view, Activity activity, DropboxAPI<AndroidAuthSession> dropbox){
        this.view=view;
        this.activity=activity;
        this.dropbox=dropbox;
    }

    protected List<Evento> doInBackground(String... urls) {

        List <Evento> listaEventos=null;
        try{
            HttpClient client = new DefaultHttpClient();
            URI website = new URI(urls[0]);
            HttpGet request = new HttpGet();
            request.setURI(website);
            request.setHeader("Accept", "application/json");
            request.setHeader("Content-Type", "application/json");
            Type listType = new TypeToken<ArrayList<Evento>>() {
            }.getType();
            HttpResponse response = client.execute(request);
            Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();
            listaEventos = gson.fromJson(EntityUtils.toString(response.getEntity(),"UTF-8"),listType);
            response.getStatusLine().getStatusCode();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            Log.e(TAG,"onEventsTask",e);
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }


        return listaEventos;
    }

    @Override
    protected void onPostExecute(List<Evento> eventos) {
        super.onPostExecute(eventos);

        ListView eventListView = (ListView) view.findViewById(R.id.eventList);

        SimpleArrayAdapter adapter = new SimpleArrayAdapter(activity,eventos);
        eventListView.setAdapter(adapter);
    }

    public class SimpleArrayAdapter extends ArrayAdapter<Evento> {
        private final Context context;
        private final List <Evento> values;
        LayoutInflater inflater;

        public SimpleArrayAdapter(Context context, List<Evento> values) {
            super(context, R.layout.evento_item, values);
            this.context = context;
            this.values = values;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View itemView = inflater.inflate(R.layout.evento_item, parent, false);
            TextView textTitulo = (TextView) itemView.findViewById(R.id.titulo_evento);
            TextView textDescription = (TextView) itemView.findViewById(R.id.descripcion_evento);
            ImageView imageView = (ImageView) itemView.findViewById(R.id.eventoImg);

            File file = new File(context.getFilesDir().getPath().toString() + "/" +values.get(position).getFoto());
            if (!file.exists()){
                RequestImageDropboxTask list = new RequestImageDropboxTask(activity, dropbox, imageView);
                list.execute(values.get(position).getFoto());
            }
            else{
                Picasso.with(context).load(file).into(imageView);
            }

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
            TextView textFechaIni = (TextView) itemView.findViewById(R.id.fecha_inicio);
            TextView textFechaFin = (TextView) itemView.findViewById(R.id.fecha_fin);
            Date fechaInicio =values.get(position).getFechaInicio();
            Date fechaFin = values.get(position).getFechaFin();
            textFechaIni.setText( dateFormat.format(fechaInicio));
            textFechaFin.setText(dateFormat.format(fechaFin));
            textTitulo.setText(values.get(position).getTitulo());
            textDescription.setText(values.get(position).getDescripcion());
            return itemView;
        }
    }
}
