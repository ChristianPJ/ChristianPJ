package com.inftel.museoinftel.activity;

import android.app.Activity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.inftel.museoinftel.R;

public class MapsActivity extends Activity {

    static final LatLng MuseoPrado = new LatLng(40.41378, -3.6921270999);
    private GoogleMap googleMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maps);
        try {
            if (googleMap == null) {
                googleMap = ((MapFragment) getFragmentManager().
                        findFragmentById(R.id.map)).getMap();
            }
            googleMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);

            googleMap.addMarker(new MarkerOptions().
                    position(MuseoPrado).title("Museo Prado"));

            googleMap.animateCamera(CameraUpdateFactory.newLatLngZoom(MuseoPrado, 12.0f));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
