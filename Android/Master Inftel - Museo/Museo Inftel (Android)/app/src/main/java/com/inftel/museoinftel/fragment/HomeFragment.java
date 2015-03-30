package com.inftel.museoinftel.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageSwitcher;

import com.inftel.museoinftel.R;
import com.inftel.museoinftel.service.RequestEventsTask;
import com.inftel.museoinftel.utility.Conexion;
import com.inftel.museoinftel.utility.DropboxConnection;

public class HomeFragment extends Fragment {

    DropboxConnection dc;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dc = new DropboxConnection(getActivity());
        dc.connect();
    }

    @Override
    public void onResume(){
        super.onResume();
        dc.resume();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_home, container, false);
        new RequestEventsTask(v, getActivity(), dc.getDropboxApi()).execute(Conexion.MUSEO_SERVER + Conexion.EVENT_RESOURCE);

        return v;
    }

}
