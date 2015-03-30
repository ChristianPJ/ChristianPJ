package com.inftel.museoinftel.activity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.gson.Gson;
import com.inftel.museoinftel.R;
import com.inftel.museoinftel.entity.Obra;
import com.inftel.museoinftel.service.RequestSoundDropboxTask;
import com.inftel.museoinftel.utility.DropboxConnection;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;


public class CanvasActivity extends Activity implements RequestSoundDropboxTask.OnAsyncRequestComplete{

    private MediaPlayer mediaPlayer;
    private Handler durationHandler = new Handler();
    private SeekBar seekbar;
    private Obra obra;
    private Boolean started = false;
    DropboxConnection dc;
    View panelViewGroup, playViewGroup;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_canvas);

        String jsonMyObject = null;
        String fileName = null;
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            jsonMyObject = extras.getString("canvas");
            fileName = extras.getString("picname");
        }

        obra = new Gson().fromJson(jsonMyObject, Obra.class);
        final TextView titleText = (TextView) findViewById(R.id.titleText);
        titleText.setText(obra.getTitulo());

        final int imageResource = getResources().getIdentifier("@drawable/" + obra.getFoto(), null, getPackageName());


       // File filePath = getFileStreamPath(fileName);
        final Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResource);

        final ImageView imageView = (ImageView)findViewById(R.id.imageView);
        imageView.setImageBitmap(bitmap);

        imageView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 10, baos);
                byte[] b = baos.toByteArray();
                String fileName = "fullscreen";
                try {
                    FileOutputStream fileOutStream = openFileOutput(fileName, MODE_PRIVATE);
                    fileOutStream.write(b);
                    fileOutStream.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                Intent intent = new Intent(getApplication(), FullScreenActivity.class);
                intent.putExtra("picname", fileName);
                startActivity(intent);
            }
        });

        final TextView categoryText = (TextView) findViewById(R.id.categoryText);
        categoryText.setText(obra.getAutor());

        final TextView infoText = (TextView) findViewById(R.id.infoText);
        infoText.setText(obra.getDescripcion());

        dc = new DropboxConnection(this);
        dc.connect();

        panelViewGroup = findViewById(R.id.loadingPanel);
        playViewGroup = findViewById(R.id.media_play);
        downloading(false);
    }

    @Override
    public void onResume(){
        super.onResume();
        dc.resume();
    }

    public void downloading(boolean dl) {
        if(dl){
            panelViewGroup.setVisibility(View.VISIBLE);
            playViewGroup.setVisibility(View.GONE);
        } else {
            panelViewGroup.setVisibility(View.GONE);
            playViewGroup.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void asyncResponse(File result) {
        mediaPlayer = MediaPlayer.create(this, Uri.fromFile(result));
        seekbar = (SeekBar) findViewById(R.id.seekBar);
        seekbar.setMax(mediaPlayer.getDuration());
        mediaPlayer.start();
        seekbar.setProgress(mediaPlayer.getCurrentPosition());
        durationHandler.postDelayed(updateSeekBarTime, 100);
        downloading(false);
    }

    public void initializeViews(){
        RequestSoundDropboxTask list = new RequestSoundDropboxTask(this, dc.getDropboxApi());
        list.execute(obra.getAudio());
    }

    public void play(View view) {
        if(!started){
            downloading(true);
            started=true;
            initializeViews();
        } else {
            mediaPlayer.start();
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            durationHandler.postDelayed(updateSeekBarTime, 100);
        }
    }

    private Runnable updateSeekBarTime = new Runnable() {

        public void run() {
            seekbar.setProgress(mediaPlayer.getCurrentPosition());
            durationHandler.postDelayed(this, 100);
        }
    };

    public void pause(View view) {
        mediaPlayer.pause();
    }

    @Override
    public void onStop(){
        super.onStop();
        if(mediaPlayer!=null) {
            mediaPlayer.stop();
        }
    }
}
