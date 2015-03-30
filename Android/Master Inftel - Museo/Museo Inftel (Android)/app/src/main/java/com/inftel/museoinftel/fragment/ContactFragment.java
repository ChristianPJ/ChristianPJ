package com.inftel.museoinftel.fragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.inftel.museoinftel.R;
import com.inftel.museoinftel.activity.MapsActivity;

public class ContactFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_contact, container, false);


        TextView tx = (TextView) v.findViewById(R.id.email);
        tx.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendEmail();
            }
        });

        ImageView t = (ImageView) v.findViewById(R.id.imageView3);
        t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendFacebook();
            }
        });

        ImageView img = (ImageView) v.findViewById(R.id.imageView2);
        img.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                sendTwiter();
            }
        });

        final TextView text1 = (TextView) v.findViewById(R.id.local);
        text1.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        return v;
    }

    public void sendEmail() {

        String email="pruebamuseo@gmail.com";
        String type="message/rfc822";
        String send="Send mail...";
        String msj="There are no email clients installed.";

        Intent i = new Intent(Intent.ACTION_SEND);
        i.setType(type);
        i.putExtra(Intent.EXTRA_EMAIL  , new String[]{email});
        try {
            startActivity(Intent.createChooser(i, send));
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(getActivity(), msj, Toast.LENGTH_SHORT).show();
        }

    }

    public void sendFacebook(){

        String urlFacebook="https://es-es.facebook.com/museonacionaldelprado";

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);

        intent.setData(Uri.parse(urlFacebook));
        startActivity(intent);
    }

    public void sendTwiter(){

        String urlTwitter="https://twitter.com/museodelprado";

        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_VIEW);
        intent.addCategory(Intent.CATEGORY_BROWSABLE);
        intent.setData(Uri.parse(urlTwitter));
        startActivity(intent);
    }
}
