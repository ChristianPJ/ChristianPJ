package com.inftel.socialnetwork.services;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.FullScreenActivity;
import com.inftel.socialnetwork.activity.GooglePlayServicesActivity;
import com.inftel.socialnetwork.utility.RoundedImageView;
import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Image;
import com.lowagie.text.pdf.PdfWriter;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Christian on 21/3/15.
 */
public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    Activity activity;
    private String nombreUsuario=null;
    ImageView imageView;
    RoundedImageView roundedImageView;

    static final String PDF_NAME = "QR.pdf";

    public DownloadImageTask(Activity activity, ImageView imageView) {
        this.activity = activity;
        this.imageView = imageView;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(final Bitmap result) {
        roundedImageView = new RoundedImageView(activity);
        Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(result, 450);

        imageView.setImageBitmap(croppedBitmap);
        imageView .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ByteArrayOutputStream baos = new ByteArrayOutputStream();
                result.compress(Bitmap.CompressFormat.JPEG, 100, baos);
                byte[] b = baos.toByteArray();
                String fileName = "fullscreen";
                try {
                    FileOutputStream fileOutStream = activity.openFileOutput(fileName, activity.MODE_PRIVATE);
                    fileOutStream.write(b);
                    fileOutStream.close();
                } catch (IOException ioe) {
                    ioe.printStackTrace();
                }
                Intent intent = new Intent(activity.getApplication(), FullScreenActivity.class);
                intent.putExtra("photo", fileName);
                activity.startActivity(intent);
            }
        });

        if(activity.getClass().getName().equals("com.inftel.socialnetwork.activity.QRActivity")) {

            Button btnSendQR = (Button) activity.findViewById(R.id.btnSendQR);
            btnSendQR.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    createPDF(result);

                }
            });
        }
    }

    private void createPDF(Bitmap bitmap) {
        Document doc = new Document();

        try {
            String path = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/PDF";
            File dir = new File(path);
            if (!dir.exists())
                dir.mkdirs();
            File file = new File(dir, PDF_NAME);
            FileOutputStream fOut = new FileOutputStream(file);

            PdfWriter.getInstance(doc, fOut);
            //open the document
            doc.open();

            ByteArrayOutputStream stream = new ByteArrayOutputStream();
            Bitmap imgPdf = Bitmap.createScaledBitmap(bitmap, 750, 750, false);
            imgPdf.compress(Bitmap.CompressFormat.JPEG, 100, stream);

            Image myImg = Image.getInstance(stream.toByteArray());
            myImg.setAlignment(Image.ALIGN_TOP);
            myImg.scaleAbsolute(450, 500);

            //add image to document
            doc.add(myImg);


        } catch (DocumentException de) {
            Log.e("PDFCreator", "DocumentException:" + de);
        } catch (IOException e) {
            Log.e("PDFCreator", "ioException:" + e);
        } finally {
            doc.close();
        }
        String path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/PDF";

        File file = new File(path, PDF_NAME);

        Intent email = new Intent(android.content.Intent.ACTION_SEND);
        email.setType("vnd.android.cursor.dir/email");
        email.putExtra(Intent.EXTRA_SUBJECT, "subject");
        email.putExtra(Intent.EXTRA_TEXT, "message");
        email.putExtra(Intent.EXTRA_STREAM, Uri.parse("file://" + file));

        SharedPreferences prefs = activity.getSharedPreferences("MYPREFERENCES", Context.MODE_PRIVATE);

        if(prefs.contains("nombreUsuario")){
            nombreUsuario = prefs.getString("nombreUsuario","");
        }


        email.putExtra(Intent.EXTRA_EMAIL, new String []{nombreUsuario});

        activity.startActivity(Intent.createChooser(email, "Elige un cliente Email :"));

    }
}
