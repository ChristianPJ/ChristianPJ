package com.example.inftel18.tutorialchristian;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;


public class MyService extends Service implements MediaPlayer.OnCompletionListener{

    private static final String TAG = "MyService";
    MediaPlayer player;

    TextView text;

    @Override
    public IBinder onBind(Intent intent){
        return null;
    }

    @Override
    public void onCreate() {

        Toast.makeText(this,"My Service Created", Toast.LENGTH_LONG).show();
        Log.d(TAG, "onCreate");

        player = MediaPlayer.create(this,R.raw.fuzz);
        player.setLooping(false);

    }

    @Override
    public void onDestroy(){
        Toast.makeText(this, "My Service Stopped", Toast.LENGTH_LONG).show();
        Log.d(TAG,"onDestroy");
        player.stop();
    }

    @Override
    public void onStart(Intent intent, int startid){
        Toast.makeText(this, "My Service Started", Toast.LENGTH_LONG).show();
        Log.d(TAG,"onStart");
        player.start();
        player.setOnCompletionListener(this);
    }

    @Override
    public void onCompletion(MediaPlayer mp) {
        this.stopSelf();
    }
}
