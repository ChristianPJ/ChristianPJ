package com.inftel.museoinftel.service;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.ImageView;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.exception.DropboxException;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class RequestImageDropboxTask extends AsyncTask<String, Void, File> {
    private DropboxAPI<?> dropbox;
    private String path;
    private ImageView imageview;
    private Context context;

    public RequestImageDropboxTask(Context context, DropboxAPI<?> dropbox, ImageView imageview) {
        this.dropbox = dropbox;
        this.imageview = imageview;
        this.context = context;
        path = "/images/";
    }

    @Override
    protected File doInBackground(String... params) {
        File file=null;
        try {
            DropboxAPI.Entry directory = dropbox.metadata(path, 100, null, true, null);
            for (DropboxAPI.Entry entry : directory.contents) {
                if(entry.fileName().equals(params[0])) {
                    file = new File(context.getFilesDir().getPath() + "/" + entry.fileName());
                    FileOutputStream outputStream = new FileOutputStream(file);
                    dropbox.getFile(entry.path, null, outputStream, null);
                }
            }
        } catch (DropboxException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return file;
    }

    @Override
    protected void onPostExecute(File result) {
        Picasso.with(context).load(result).into(imageview);
    }


}