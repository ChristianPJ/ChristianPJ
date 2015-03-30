package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.widget.Toast;

import com.google.gson.Gson;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.ProfileActivity;
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


public class RequestUserTask extends AsyncTask<String,Integer,Usuario>{

    private Activity activity;
    String email;
    private int tipo;
    public static int BY_QR = 1;
    public static int BY_EMAIL = 2;

    private String param;
    private boolean busqueda;

    Usuario usuario;

    public RequestUserTask(Activity activity, String email, int tipo, boolean busqueda){
        this.activity=activity;
        this.email=email;
        this.tipo=tipo;
        this.busqueda=busqueda;
    }

    @Override
    protected Usuario doInBackground(String... param) {

        usuario = null;

        try{

            HttpClient client = new DefaultHttpClient();
            URI website;

            email = email.replaceAll("\\.", "___");

            if (tipo != BY_EMAIL && tipo!=BY_QR){
                System.out.println("Valor incorrecto de tipo, valores posibles: BY_EMAIL, BY_QR");
            }
            else {
                if (tipo == BY_QR) {
                    website = new URI(Conexion.SOCIAL_SERVER + Conexion.USER_RESOURCE + "findbygoogle/" + email);
                } else {
                    website = new URI(Conexion.SOCIAL_SERVER + Conexion.USER_RESOURCE + "findbyemail/" + email);
                }
                HttpGet request = new HttpGet();
                request.setURI(website);
                request.setHeader("Accept", "application/json");
                request.setHeader("Content-Type", "application/json");
                HttpResponse response = client.execute(request);
                Gson gson = new Gson();
                usuario = gson.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"), Usuario.class);
                response.getStatusLine().getStatusCode();
            }
        }catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return usuario;

    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

          }

    @Override
    protected void onPostExecute(Usuario usuario) {
        //Recoger el componente de la vista donde queremos pintar el contenido y hacerle un set
        super.onPostExecute(usuario);

        if(busqueda == false) {

            if(usuario == null){
                newUser();
            }
        } else {
            if(usuario != null){
                new RequestFriendAsyncTask(usuario,activity).execute();
            }
            else{
                Toast.makeText(activity, activity.getString(R.string.error_usuario_no_existe), Toast.LENGTH_LONG).show();
            }
        }
    }

    public Usuario newUser(){

        SharedPreferences prefs = activity.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        usuario = new Usuario();
        usuario.setNombre(prefs.getString("nombreUsuario",""));
        usuario.setApellido(prefs.getString("apellidoUsuario",""));
        usuario.setFoto(prefs.getString("fotoUsuario",""));
        usuario.setEmail(prefs.getString("emailUsuario",""));
        usuario.setGenero(prefs.getString("generoUsuario",""));
        usuario.setLocale(prefs.getString("localeUsuario",""));
        usuario.setLinkGoogle(prefs.getString("idUsuario",""));

        new NewUserAsyncTask(usuario, activity).execute();

        return usuario;
    }

}
