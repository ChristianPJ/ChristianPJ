package com.inftel.socialnetwork.services;


import android.app.ProgressDialog;

import android.content.Context;
import android.content.DialogInterface;

import android.os.AsyncTask;


import android.os.Build;
import android.util.Log;
import android.widget.Toast;

import com.dropbox.client2.DropboxAPI;
import com.dropbox.client2.ProgressListener;
import com.dropbox.client2.RESTUtility;
import com.dropbox.client2.exception.DropboxException;
import com.dropbox.client2.exception.DropboxFileSizeException;
import com.dropbox.client2.exception.DropboxIOException;
import com.dropbox.client2.exception.DropboxParseException;
import com.dropbox.client2.exception.DropboxPartialFileException;
import com.dropbox.client2.exception.DropboxServerException;
import com.dropbox.client2.exception.DropboxUnlinkedException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class DropboxService extends AsyncTask<Void, String, Boolean> {

    private DropboxAPI<?> dropbox;
    private String path = "/Imagenes/";
    private Context context;

    private DropboxAPI.UploadRequest mRequest;
    private File fileImage;

    private long mFileLen;
    private final ProgressDialog mDialog;
    private String mErrorMsg;

    private String completePath;
    private String name;


    public DropboxService(Context context, DropboxAPI<?> dropbox, File fileImage, String name) {



        this.dropbox = dropbox;
        this.context = context.getApplicationContext();
        this.fileImage = fileImage;
        this.name=name;
        mFileLen = fileImage.length();

        mDialog = new ProgressDialog(context);
        mDialog.setMax(100);
        mDialog.setMessage("Subiendo imagen a Dropbox");
        mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        mDialog.setProgress(0);
        mDialog.show();

    }


    @Override
    protected Boolean doInBackground(Void... params) {




            try {


                FileInputStream fis = new FileInputStream(fileImage);

                completePath = path + name;
                //name= fileImage.getName();


                mRequest = dropbox.putFileOverwriteRequest(completePath, fis, fileImage.length(),

                        new ProgressListener() {
                            @Override
                            public long progressInterval() {
                                // Update the progress bar every half-second or so
                                return 500;
                            }

                            @Override
                            public void onProgress(long bytes, long total) {
                                onProgressUpdate(bytes);
                            }
                        });

                if (mRequest != null) {
                    mRequest.upload();
                    return true;
                }

            } catch (DropboxUnlinkedException e) {
                // This session wasn't authenticated properly or user unlinked
                mErrorMsg = "This app wasn't authenticated properly.";
            } catch (DropboxFileSizeException e) {
                // File size too big to upload via the API
                mErrorMsg = "This file is too big to upload";
            } catch (DropboxPartialFileException e) {
                // We canceled the operation
                mErrorMsg = "Upload canceled";
            } catch (DropboxServerException e) {
                // Server-side exception.  These are examples of what could happen,
                // but we don't do anything special with them here.
                if (e.error == DropboxServerException._401_UNAUTHORIZED) {
                    // Unauthorized, so we should unlink them.  You may want to
                    // automatically log the user out in this case.
                } else if (e.error == DropboxServerException._403_FORBIDDEN) {
                    // Not allowed to access this
                } else if (e.error == DropboxServerException._404_NOT_FOUND) {
                    // path not found (or if it was the thumbnail, can't be
                    // thumbnailed)
                } else if (e.error == DropboxServerException._507_INSUFFICIENT_STORAGE) {
                    // user is over quota
                } else {
                    // Something else
                }
                // This gets the Dropbox error, translated into the user's language
                mErrorMsg = e.body.userError;
                if (mErrorMsg == null) {
                    mErrorMsg = e.body.error;
                }
            } catch (DropboxIOException e) {
                // Happens all the time, probably want to retry automatically.
                mErrorMsg = "Network error.  Try again.";
            } catch (DropboxParseException e) {
                // Probably due to Dropbox server restarting, should retry
                mErrorMsg = "Dropbox error.  Try again.";
            } catch (DropboxException e) {
                // Unknown error
                mErrorMsg = "Unknown error.  Try again.";
            } catch (FileNotFoundException e) {
            }
             return false;
    }


    protected void onProgressUpdate(Long... progress) {
        int percent = (int)(100.0*(double)progress[0]/mFileLen + 0.5);
        mDialog.setProgress(percent);
    }

    @Override
    protected void onPostExecute(Boolean result) {
        mDialog.dismiss();
        if (result) {
            showToast("Imagen correctamente subida");
        } else {
            showToast(mErrorMsg);
        }

    }

    private void showToast(String msg) {
        Toast error = Toast.makeText(context, msg, Toast.LENGTH_LONG);
        error.show();
    }



}
