package com.inftel.socialnetwork.activity;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AppKeyPair;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by inftel12 on 20/3/15.
 */
public class DropboxConnnection {

    final static private String APP_KEY = "wrlnff8alvxrujm";
    final static private String APP_SECRET = "1crqc7ned15l3iu";
    final static private String DROPBOX = "DropboxApp";
    final static private String ACCESS_TOKEN = "AccessTokenDropbox";
    private Context context;
    private DropboxAPI<AndroidAuthSession> mDBApi;

    public DropboxConnnection(Context context){
        this.context = context;
    }

    public DropboxAPI<AndroidAuthSession> getmDBApi(){
        return mDBApi;
    }

    public void connect(){
        AppKeyPair appKeys;
        AndroidAuthSession session;

        SharedPreferences prefs = context.getSharedPreferences(DROPBOX, 0);
        String accessToken = prefs.getString(ACCESS_TOKEN,null);

        if (accessToken!= null){
            Log.i("TAG", "NO ES NULO");
            appKeys = new AppKeyPair("","");
            session = new AndroidAuthSession(appKeys);
            session.setOAuth2AccessToken(accessToken);
            mDBApi = new DropboxAPI<>(session);
        }else{
            Log.i("TAG", "NO ES NULO");
            appKeys = new AppKeyPair(APP_KEY, APP_SECRET);
            session = new AndroidAuthSession(appKeys);
            mDBApi = new DropboxAPI<>(session);
            mDBApi.getSession().startOAuth2Authentication(context);
        }
    }

    public void resume(){
        AndroidAuthSession session = mDBApi.getSession();
        if (session.authenticationSuccessful()) {
            try {

                // Required to complete auth, sets the access token on the session
                session.finishAuthentication();
                String accessToken = session.getOAuth2AccessToken();
                SharedPreferences prefs = context.getSharedPreferences(DROPBOX,0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(ACCESS_TOKEN, accessToken);
                editor.commit();

            } catch (IllegalStateException e) {
                Toast.makeText(context, "Error during Dropbox authentication", Toast.LENGTH_SHORT).show();
                Log.i("DbAuthLog", "Error authenticating", e);
            }
        }
    }



}
