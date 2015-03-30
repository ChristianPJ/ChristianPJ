package com.inftel.socialnetwork.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ActivityNotFoundException;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Usuario;
import com.inftel.socialnetwork.services.NewUserAsyncTask;
import com.inftel.socialnetwork.utility.RoundedImageView;


public class LoginActivity extends ActionBarActivity {

    static final String ACTION_SCAN = "com.google.zxing.client.android.SCAN";
    private Button btnQR, btnGoogle;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        getSupportActionBar().hide();

        // logo image
        final ImageView imageview = (ImageView) findViewById(R.id.imageView);
        int imageResource = getResources().getIdentifier("@drawable/logo", null, getPackageName());

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), imageResource);
        RoundedImageView roundedImageView = new RoundedImageView(getApplicationContext());
        Bitmap croppedBitmap = roundedImageView.getCroppedBitmap(bitmap,450);
        imageview.setImageBitmap(croppedBitmap);

        // QR button
        btnQR=(Button)findViewById(R.id.btnloginqr);

        btnQR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(ACTION_SCAN);
                    intent.putExtra("SCAN_MODE", "QR_CODE_MODE");
                    startActivityForResult(intent, 0);
                } catch (ActivityNotFoundException anfe) {
                    showDialog(LoginActivity.this, "No Scanner Found", "Download a scanner code activity?", "Yes", "No").show();
                }
            }
        });

        // Google button
        btnGoogle=(Button)findViewById(R.id.btnlogingoogle);

        btnGoogle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentLocal = new Intent(getApplicationContext(), GooglePlayServicesActivity.class);
                startActivity(intentLocal);
            }
        });




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_login, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private static AlertDialog showDialog(final Activity act, CharSequence title, CharSequence message, CharSequence buttonYes, CharSequence buttonNo) {
        AlertDialog.Builder downloadDialog = new AlertDialog.Builder(act);
        downloadDialog.setTitle(title);
        downloadDialog.setMessage(message);
        downloadDialog.setPositiveButton(buttonYes, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
                Uri uri = Uri.parse("market://search?q=pname:" + "com.google.zxing.client.android");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                try {
                    act.startActivity(intent);
                } catch (ActivityNotFoundException anfe) {

                }
            }
        });
        downloadDialog.setNegativeButton(buttonNo, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });
        return downloadDialog.show();
    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {

                String contents = intent.getStringExtra("SCAN_RESULT");

                Intent intentLocal = new Intent(getApplicationContext(), MainActivity.class);
                intentLocal.putExtra("qr", contents);
                startActivity(intentLocal);
            }
        }
    }

}