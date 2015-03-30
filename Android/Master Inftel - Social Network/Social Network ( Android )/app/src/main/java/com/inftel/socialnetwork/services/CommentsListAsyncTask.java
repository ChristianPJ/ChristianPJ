package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.DropboxConnnection;
import com.inftel.socialnetwork.activity.FullScreenActivity;
import com.inftel.socialnetwork.activity.GooglePlayServicesActivity;
import com.inftel.socialnetwork.activity.MainActivity;
import com.inftel.socialnetwork.utility.ExpandAnimation;
import com.inftel.socialnetwork.entity.Comentario;
import com.inftel.socialnetwork.utility.Conexion;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.ByteArrayOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


public class CommentsListAsyncTask extends AsyncTask<Void, Void, List<Comentario>> {
    public static int BY_EMAIL_PRIVATE = 2;
    public static int BY_EMAIL =1;
    public static int BY_GROUP =3;
    private Activity activity;
    private String email;
    private int tipo;
    private ImageView imageuser;
    private DropboxConnnection dropboxConnnection;
    private String nombreUsuario=null;
    private String emailUser=null;
    private String apellidoUser;
    private String fotoUser=null;


    public CommentsListAsyncTask(Activity activity, String email,int tipo, DropboxConnnection dropboxConnnection){
        this.activity = activity;
        this.email = email;
        this.tipo=tipo;
        this.dropboxConnnection = dropboxConnnection;
    }

    @Override
    protected List<Comentario> doInBackground(Void... params) {
        HttpClient client = new DefaultHttpClient();
        String uri=null;
        List<Comentario> comentsList = null;

        try {

            if (tipo != BY_EMAIL && tipo != BY_EMAIL_PRIVATE && tipo != BY_GROUP) {
                System.out.println("Valor incorrecto de tipo, valores posibles: BY_EMAIL, BY_EMAIL_PRIVATE,BY_GROUP");
            } else {
                if (tipo == BY_EMAIL) {
                    email = email.replaceAll("\\.", "___");
                    uri = Conexion.SOCIAL_SERVER + Conexion.COMMENT_RESOURCE + "findall/" + email;
                } else if (tipo == BY_EMAIL_PRIVATE) {
                    email = email.replaceAll("\\.", "___");
                    uri = Conexion.SOCIAL_SERVER + Conexion.COMMENT_RESOURCE + "findemailtipo/" + email + "/false";
                } else {
                    uri = Conexion.SOCIAL_SERVER + Conexion.COMMENT_RESOURCE + "findgroup/" + email;
                }
            }

         //  HttpGet httpGet = new HttpGet(uri);
            HttpGet request=new HttpGet(uri);
          //  request.setURI(uri);

            request.setHeader("Accept", "application/json");
            request.setHeader("Content-Type", "application/json");
            Type listType = new TypeToken<ArrayList<Comentario>>() {
            }.getType();
            HttpResponse response = client.execute(request);
            Gson gson = new Gson();
            comentsList = gson.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"), listType);
            response.getStatusLine().getStatusCode();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return comentsList;
    }

        @Override
    protected void onPostExecute(List<Comentario> comentsList) {
        super.onPostExecute(comentsList);
            final String uri;

            uri=Conexion.SOCIAL_SERVER + Conexion.COMMENT_RESOURCE + "deleteid/";


        final ListView  comentListView = (ListView) activity.findViewById(R.id.comentList);

        ArrayAdapter<Comentario> adapter = new CustomListAdapter(activity,comentsList);
        comentListView.setAdapter(adapter);

            final Boolean del=true;


            if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.MainActivity")) {
                comentListView.setOnItemLongClickListener(

                        new AdapterView.OnItemLongClickListener() {
                            private Comentario removeMe;

                            public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {


                                removeMe = (Comentario) comentListView.getAdapter().getItem(position);


                                new AlertDialog.Builder(activity)
                                        .setTitle("Atencion!")
                                        .setMessage("estas seguro de querer borrar el comentario?")
                                        .setIcon(android.R.drawable.ic_dialog_alert)
                                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                            public void onClick(DialogInterface dialog, int whichButton) {
                                                new DeleteComentarioTask().execute(uri + removeMe.getId());
                                                reloadActivity();
                                            }
                                        })
                                        .setNegativeButton(android.R.string.no, null).show();


                                return del;
                            }


                        });
            }else if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.ProfileActivity")){
                comentListView.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    private Comentario copia;

                    public boolean onItemLongClick(AdapterView<?> parent, View v, int position, long id) {


                        copia = (Comentario) comentListView.getAdapter().getItem(position);


                        new AlertDialog.Builder(activity)
                                .setTitle("Atencion!")
                                .setMessage("Estas seguro de querer copiar el comentario?")
                                .setIcon(android.R.drawable.ic_dialog_alert)
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {

                                    public void onClick(DialogInterface dialog, int whichButton) {

                                        SharedPreferences prefs = activity.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);


                                        if(prefs.contains("nombreUsuario")){
                                            nombreUsuario = prefs.getString("nombreUsuario","");
                                        }
                                        if(prefs.contains("fotoUsuario")){
                                            fotoUser = prefs.getString("fotoUsuario","");
                                        }

                                        if(prefs.contains("emailUsuario")){
                                            emailUser = prefs.getString("emailUsuario","");
                                        }
                                        if(prefs.contains("apellidoUsuario")){
                                            apellidoUser = prefs.getString("apellidoUsuario","");
                                        }


                                        Comentario envio=new Comentario();
                                        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);

                                        String creationDate = sdf.format(new Date(new java.util.Date().getTime()));
                                        envio.setPerfil(emailUser);
                                        envio.setNombre(nombreUsuario);
                                        envio.setImagenUsuario(fotoUser);
                                     //   envio.setNombreGrupo("");
                                        envio.setApellido(apellidoUser);
                                        envio.setEmailUsuario(copia.getEmailUsuario());
                                        envio.setFecha(creationDate);
                                        envio.setTitulo(copia.getTitulo());
                                        envio.setTexto(copia.getTexto());
                                        envio.setImagen(copia.getImagen());
                                        envio.setVideo(copia.getVideo());

                                        new PostComentarioTask(envio, activity).execute();


                                    }
                                })
                                .setNegativeButton(android.R.string.no, null).show();


                        return del;
                    }


                });

            }

        // Creating an item click listener, to open/close our toolbar for each item
        comentListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, int position, long id) {
                View toolbar = view.findViewById(R.id.toolbar);
                ExpandAnimation expandAni = new ExpandAnimation(toolbar, 500);
                toolbar.startAnimation(expandAni);
            }
        });

    }

    public void reloadActivity(){
        Intent intent = new Intent(activity, MainActivity.class);
        activity.startActivity(intent);

    }

    class CustomListAdapter extends ArrayAdapter<Comentario> {
        private ImageView imaguser;
        private ImageView imagecomment;
        private final Context context;
        private final List <Comentario> values;

        LayoutInflater inflater;
        public CustomListAdapter(Context context, List<Comentario> values) {
            super(context, R.layout.list_item, values);
            this.context = context;
            this.values = values;
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            Button video;
            if (convertView == null) {
                convertView = inflater.inflate(R.layout.list_item, null, false);

            }

            ((TextView)convertView.findViewById(R.id.title)).setText(getItem(position).getTitulo());
            ((TextView)convertView.findViewById(R.id.text)).setText(getItem(position).getTexto());
            ((TextView)convertView.findViewById(R.id.fecha)).setText(getItem(position).getFecha());

            if(getItem(position).getNombreGrupo()!=null) {
                ((TextView) convertView.findViewById(R.id.grupo)).setText(getItem(position).getNombreGrupo());
            }

            imaguser=(ImageView)convertView.findViewById(R.id.icono);
            new DownloadImageTask(activity,imaguser).execute(getItem(position).getImagenUsuario());


            imagecomment = (ImageView)convertView.findViewById(R.id.imagenc);
            String nameImage = getItem(position).getImagen();
            if ((nameImage!=null)&&(!nameImage.equals(""))){
                //dropboxConnnection = new DropboxConnnection(activity);
                //dropboxConnnection.connect();
                DropboxServiceGetPhoto dropboxServiceGetPhoto = new DropboxServiceGetPhoto(activity, dropboxConnnection.getmDBApi(), nameImage,imagecomment);
                dropboxServiceGetPhoto.execute();
                imagecomment.setVisibility(View.VISIBLE);



            }
            if(getItem(position).getVideo()!=null){

             video=(Button)convertView.findViewById(R.id.bvideo);
                video.setVisibility(View.VISIBLE);
                video.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        activity.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(getItem(position).getVideo())));


                    }
                });

            }
            View toolbar = convertView.findViewById(R.id.toolbar);
            ((LinearLayout.LayoutParams) toolbar.getLayoutParams()).bottomMargin = -50;
            toolbar.setVisibility(View.GONE);

            return convertView;
        }
    }



}
