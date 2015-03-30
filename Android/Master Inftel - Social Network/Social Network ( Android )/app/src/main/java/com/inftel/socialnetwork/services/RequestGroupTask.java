package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.DropboxConnnection;
import com.inftel.socialnetwork.activity.GroupActivity;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.entity.Groups;
import com.inftel.socialnetwork.utility.Conexion;
import com.inftel.socialnetwork.utility.SimpleArrayAdapter;
import com.inftel.socialnetwork.utility.SimpleArrayGroupAdapter;

import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
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
import java.util.ArrayList;
import java.util.List;

/**
 * Created by inftel11 on 19/3/15.
 */
public class RequestGroupTask extends AsyncTask<Void,Void,List<Groups>> implements AdapterView.OnItemSelectedListener{
    public static int BY_NAME = 1;
    public static int BY_EMAIL = 2;
    private Activity activity;
    private boolean estado;
    private String param;
    private int tipo;
    private ProgressDialog progressDialog;
    private List<Friends> amigos;
    private List<Friends> amigosSeleccionados;
    Spinner spinnerState;
    private DropboxConnnection dropboxConnnection;

    private File fileImage;
    private String imageName;

    public RequestGroupTask(String param, Activity activity,int tipo, ProgressDialog progressDialog,List<Friends> amigos,List<Friends> amigosSeleccionados, File fileImage, String imageName){
        this.param=param;
        this.activity=activity;
        this.tipo=tipo;
        this.progressDialog = progressDialog;
        this.amigos = amigos;
        this.amigosSeleccionados = amigosSeleccionados;
        this.fileImage = fileImage;
        this.imageName = imageName;
    }


    @Override
    protected List<Groups> doInBackground(Void... params) {

        List<Groups> groups=null;

        try{

            HttpClient client = new DefaultHttpClient();
            URI website;

            if (tipo != BY_EMAIL && tipo!=BY_NAME){
                System.out.println("Valor incorrecto de tipo, valores posibles: BY_EMAIL, BY_NAME");
            }
            else {
                if (tipo == BY_NAME){
                    website = new URI(Conexion.SOCIAL_SERVER+Conexion.GROUPS_RESOURCE+"findbyname/"+param);
                }
                else {
                    param = param.replaceAll("\\.","___");
                    website = new URI(Conexion.SOCIAL_SERVER+Conexion.GROUPS_RESOURCE+"findgroups/"+param);
                }
                HttpGet request = new HttpGet();
                request.setURI(website);
                request.setHeader("Accept", "application/json");
                request.setHeader("Content-Type", "application/json");
                HttpResponse response = client.execute(request);
                estado = response.getStatusLine().getStatusCode() == HttpStatus.SC_OK;
                if(estado){
                    Type listType = new TypeToken<ArrayList<Groups>>() {
                    }.getType();
                    Gson gson= new Gson();
                    groups = gson.fromJson(EntityUtils.toString(response.getEntity(), "UTF-8"),listType);
                }
            }


        }catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }

        return groups;
    }

    @Override
    protected void onPostExecute(List<Groups> groupses) {
        super.onPostExecute(groupses);



        if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.NewGroupActivity")){
            if(groupses==null || groupses.size()==0){
                SharedPreferences prefs = activity.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

                Groups groups = new Groups();

                String nombreApellidos=null;
                if(prefs.contains("nombreUsuario")){
                   nombreApellidos=prefs.getString("nombreUsuario","");
                }
                if(prefs.contains("apellidoUsuario")){
                    nombreApellidos = nombreApellidos +" "+prefs.getString("apellidoUsuario","");
                }
                groups.setUsername(nombreApellidos);
                groups.setCreador(true);
                groups.setName(param);
                if(prefs.contains("emailUsuario")){
                    groups.setEmail(prefs.getString("emailUsuario",""));
                }
                if(prefs.contains("fotoUsuario")){
                    groups.setFotoUrl(prefs.getString("fotoUsuario",""));
                }
                groups.setImageUrl(imageName);
                new PostGroupTask(groups,activity,progressDialog).execute();

                // guardar en dropbox
                if (fileImage!=null) {
                    DropboxConnnection dropboxConnnection = new DropboxConnnection(activity);
                    dropboxConnnection.connect();
                    DropboxService dropboxService = new DropboxService(activity, dropboxConnnection.getmDBApi(), fileImage,imageName);
                    dropboxService.execute();
                }else{
                    showToast("No hay Imagen");
                }



            }
            else{
                if (progressDialog.isShowing()){
                    progressDialog.dismiss();
                }
                Toast.makeText(activity, activity.getString(R.string.error_grupo_existe), Toast.LENGTH_LONG).show();
            }

        } else if (activity.getClass().getName().equals("com.inftel.socialnetwork.activity.GroupsListActivity")){
            if(groupses!=null && groupses.size()!=0){
                final List<Groups> newGroupsList = groupses;

                ListView groupsListView = (ListView) activity.findViewById(R.id.groupsList);

                dropboxConnnection = new DropboxConnnection(activity);
                dropboxConnnection.connect();

                SimpleArrayGroupAdapter adapter = new SimpleArrayGroupAdapter(activity,groupses,dropboxConnnection);
                groupsListView.setAdapter(adapter);

                groupsListView.setOnItemClickListener(
                        new AdapterView.OnItemClickListener() {
                            public void onItemClick(AdapterView<?> arg0, View v, int position, long id) {

                                Intent intentLocal = new Intent(activity, GroupActivity.class);
                                intentLocal.putExtra("group", newGroupsList.get(position).getName());
                                intentLocal.putExtra("imageGroup",newGroupsList.get(position).getImageUrl());
                                activity.startActivity(intentLocal);

                            }
                        });
            }
            else{
                Toast.makeText(activity, "No tienes ningun grupo", Toast.LENGTH_LONG).show();
            }
            if (progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        }
        else if (activity.getClass().getName().equals("com.inftel.socialnetwork.activity.NewGroupMembersActivity")){
            if(groupses!=null && groupses.size()!=0){

                List <Friends> posiblesMiembros = buscarAmigosNoMiembros(amigos,groupses);

                ListView groupsListView = (ListView) activity.findViewById(R.id.membersList);

                SimpleArrayAdapter adapter = new SimpleArrayAdapter(activity,posiblesMiembros,amigosSeleccionados,activity);
                groupsListView.setAdapter(adapter);

            }
            else{
                Toast.makeText(activity, "No tienes ningun amigo disponible", Toast.LENGTH_LONG).show();
            }
            if (progressDialog!=null && progressDialog.isShowing()){
                progressDialog.dismiss();
            }
        } else if (activity.getClass().getName().equals("com.inftel.socialnetwork.activity.CommentActivity")){
            String[] INDIAN_STATE=new String[groupses.size()+1];
            if (progressDialog.isShowing()){
                progressDialog.dismiss();
            }
           int i=1;
            INDIAN_STATE[0]="";
            for(Groups grupo:groupses){
                INDIAN_STATE[i]=grupo.getName();
                i++;
            }

            spinnerState = (Spinner) activity.findViewById(R.id.spinnerstate);
            ArrayAdapter<String> adapter_state = new ArrayAdapter<String>(activity,
                    android.R.layout.simple_spinner_item, INDIAN_STATE);
            adapter_state
                    .setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerState.setAdapter(adapter_state);
            spinnerState.setOnItemSelectedListener(this);
        }
    }
    public void onItemSelected(AdapterView<?> parent, View view, int position,
                               long id) {

        spinnerState.setSelection(position);
        String myState = (String) spinnerState.getSelectedItem();



    }

    public void onNothingSelected(AdapterView<?> parent) {

    }


    public List<Friends> buscarAmigosNoMiembros(List<Friends> amigos, List<Groups> miembros){
        List<Friends> amigosNoMiembros = new ArrayList<>();
        boolean encontrado =false;
        for(Friends amigo: amigos){
            String emailAmigo = amigo.getFriendEmail();
            int i =0;
            while(!encontrado && (i<miembros.size())){
                if (emailAmigo.equals(miembros.get(i).getEmail())){
                    encontrado=true;
                }else{
                    i++;
                }
            }
            if(!encontrado){
                amigosNoMiembros.add(amigo);
            }
            encontrado=false;

        }

        return amigosNoMiembros;
    }

    private void showToast(String msg) {
        Toast error = Toast.makeText(activity, msg, Toast.LENGTH_LONG);
        error.show();
    }
}
