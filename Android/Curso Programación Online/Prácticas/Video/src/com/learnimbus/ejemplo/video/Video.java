package com.learnimbus.ejemplo.video;

import android.app.Activity;
import android.os.Bundle;
import android.widget.VideoView;

public class Video extends Activity {
   @Override
   public void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);

      // cargamos la vista desde el recurso
      setContentView(R.layout.main);
      VideoView video = (VideoView) findViewById(R.id.video);

      // cargamos y comenzamos a reproducer la pelicula
      video.setVideoPath("/sdcard/video/video.3gp");
      
      video.start();
   }
}

