package com.inftel.socialnetwork.services;


import android.app.Activity;
import android.app.Application;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.ProgressListener;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxFileSizeException;
import com.dropbox.client2.exception.DropboxIOException;
import com.dropbox.client2.exception.DropboxParseException;
import com.dropbox.client2.exception.DropboxPartialFileException;
import com.dropbox.client2.exception.DropboxServerException;
import com.dropbox.client2.exception.DropboxUnlinkedException;
import com.inftel.socialnetwork.utility.RoundedImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;


public class DropboxServiceGetPhoto extends AsyncTask<Void, String, File> {

    private DropboxAPI<?> dropbox;
    private String path = "/Imagenes/";
    private Context context;

    private String completePath;
    private String fileName;
    private Activity activity;
    private ImageView imageView;



    public DropboxServiceGetPhoto(Activity activity, DropboxAPI<?> dropbox, String fileName, ImageView imageView) {

        this.activity = activity;
        this.dropbox = dropbox;
        this.context = activity.getApplicationContext();
        this.fileName = fileName;
        this.imageView = imageView;

        completePath=path+fileName;


    }


    @Override
    protected File doInBackground(Void... params){

        File file = new File(context.getFilesDir().getPath()+"/"+this.fileName);

        FileOutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


        try {
            dropbox.getFile(completePath, null, outputStream, null);
        } catch (DropboxException e) {
            e.printStackTrace();
        }


        return file;
    }


    protected void onPostExecute(File result) {

        if (result!=null){
            String filePath = result.getPath();

            Bitmap bitmap = ajustarFoto(filePath);

            if((activity.getClass().getName().equals("com.inftel.socialnetwork.activity.GroupsListActivity"))||(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.GroupActivity"))) {
                RoundedImageView roundedImageView = new RoundedImageView(activity);
                if(bitmap!=null){
                    Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(bitmap, 450);
                    bitmap = croppedBitmap;
                }
            }
            imageView.setImageBitmap(bitmap);
        }

    }


    public Bitmap ajustarFoto(String mCurrentPhotoPath){

        // Get the dimensions of the View
        int targetW = 200;
        int targetH = 200;

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmOptions = new BitmapFactory.Options();
        bmOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);
        int photoW = bmOptions.outWidth;
        int photoH = bmOptions.outHeight;

        // Determine how much to scale down the image
        int scaleFactor = Math.min((photoW / targetW), (photoH / targetH));

        // Decode the image file into a Bitmap sized to fill the View
        bmOptions.inJustDecodeBounds = false;
        bmOptions.inSampleSize = scaleFactor;
        //bmOptions.inScaled = true;

        Bitmap bitmap = BitmapFactory.decodeFile(mCurrentPhotoPath, bmOptions);

        return bitmap;
    }





}
