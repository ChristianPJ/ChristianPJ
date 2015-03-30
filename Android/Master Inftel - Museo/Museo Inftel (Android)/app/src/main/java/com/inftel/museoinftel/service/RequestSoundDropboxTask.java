package com.inftel.museoinftel.service;

import android.app.Activity;
import android.os.AsyncTask;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.exception.DropboxException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class RequestSoundDropboxTask extends AsyncTask<String, Void, File> {
    private DropboxAPI<?> dropbox;
    private String path;
    private Activity activity;
    OnAsyncRequestComplete caller;

    public RequestSoundDropboxTask(Activity activity, DropboxAPI<?> dropbox) {
        this.dropbox = dropbox;
        this.activity = activity;
        path = "/audio/";
        this.caller = (OnAsyncRequestComplete) activity;
    }

    public interface OnAsyncRequestComplete {
        public void asyncResponse(File response);
    }

    @Override
    protected File doInBackground(String... params) {
        File file=null;
        try {
            DropboxAPI.Entry directory = dropbox.metadata(path, 100, null, true, null);
            for (DropboxAPI.Entry entry : directory.contents) {
                if(entry.fileName().equals(params[0])) {
                    file = new File(activity.getFilesDir().getPath() + "/" + entry.fileName());
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
        caller.asyncResponse(result);
    }


}