package com.inftel.museoinftel.utility;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.android.AndroidAuthSession;
import com.dropbox.client2.session.AccessTokenPair;
import com.dropbox.client2.session.AppKeyPair;
import com.dropbox.client2.session.TokenPair;


public class DropboxConnection {
    private final static String DROPBOX_NAME = "dropbox_prefs";
    private final static String ACCESS_KEY = "vyxnrkahd5zvknk";
    private final static String ACCESS_SECRET = "o4dbsmbnxl4cet7";
    private Context context;
    private DropboxAPI<AndroidAuthSession> dropbox;

    public DropboxConnection(Context context) {
        this.context = context;
    }

    public DropboxAPI<AndroidAuthSession> getDropboxApi(){
        return dropbox;
    }

    public void connect(){
        AndroidAuthSession session;
        AppKeyPair pair = new AppKeyPair(ACCESS_KEY, ACCESS_SECRET);

        SharedPreferences prefs = context.getSharedPreferences(DROPBOX_NAME, 0);
        String key = prefs.getString(ACCESS_KEY, null);
        String secret = prefs.getString(ACCESS_SECRET, null);

        if (key != null && secret != null) {
            AccessTokenPair token = new AccessTokenPair(key, secret);
            session = new AndroidAuthSession(pair, token);
            dropbox = new DropboxAPI<>(session);
        } else {
            session = new AndroidAuthSession(pair);
            dropbox = new DropboxAPI<>(session);
            dropbox.getSession().startAuthentication(context);
        }
    }

    public void resume(){
       AndroidAuthSession session = dropbox.getSession();
        if (session.authenticationSuccessful()) {
            try {
                session.finishAuthentication();
                TokenPair tokens = session.getAccessTokenPair();
                SharedPreferences prefs = context.getSharedPreferences(DROPBOX_NAME, 0);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString(ACCESS_KEY, tokens.key);
                editor.putString(ACCESS_SECRET, tokens.secret);
                editor.commit();

            } catch (IllegalStateException e) {
                Toast.makeText(context, "Error during Dropbox authentication", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
