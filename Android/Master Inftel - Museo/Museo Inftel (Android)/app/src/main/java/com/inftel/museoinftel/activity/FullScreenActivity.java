package com.inftel.museoinftel.activity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import com.inftel.museoinftel.R;

import java.io.File;


public class FullScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_full_screen);

        Bundle extras = getIntent().getExtras();
        String fileName = extras.getString("picname");

        File filePath = getFileStreamPath(fileName);
        final Bitmap bitmap = BitmapFactory.decodeFile(filePath.toString());

        final ImageView imageView = (ImageView) findViewById(R.id.imageView2);
        imageView.setImageBitmap(bitmap);
    }
}
