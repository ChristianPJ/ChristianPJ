package com.inftel.socialnetwork.utility;

import android.app.Activity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.CommentActivity;
import com.inftel.socialnetwork.activity.FriendsListActivity;
import com.inftel.socialnetwork.activity.GooglePlayServicesActivity;
import com.inftel.socialnetwork.activity.GroupsListActivity;
import com.inftel.socialnetwork.activity.LoginActivity;
import com.inftel.socialnetwork.activity.MainActivity;
import com.inftel.socialnetwork.activity.QRActivity;

public class NavigationAdapter extends BaseAdapter {

    private static Activity activity;
    private static DrawerLayout drawerLayout;

    ArrayList<NavigationItem> arrayitms;

    static ListView navLista;

    public NavigationAdapter(Activity activity,ArrayList<NavigationItem> listarry) {
       super();  
       this.activity = activity;  
       this.arrayitms=listarry;
    }

    @Override
    public Object getItem(int position) {
       return arrayitms.get(position);
   }   

    public int getCount() {
      // TODO Auto-generated method stub  
        return arrayitms.size();  
    }

    @Override
    public long getItemId(int position) {
        return position;
    }   

    public static class Fila
    {  
    		TextView titulo_itm;
    		ImageView icono;
    }  

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
	    Fila view;
        LayoutInflater inflator = activity.getLayoutInflater();
        if(convertView==null)
        {
            view = new Fila();
            NavigationItem itm=arrayitms.get(position);
            convertView = inflator.inflate(R.layout.navigation_item, null);

            view.titulo_itm = (TextView) convertView.findViewById(R.id.title_item);
            view.titulo_itm.setText(itm.getTitulo());
            view.icono = (ImageView) convertView.findViewById(R.id.icon);
            view.icono.setImageResource(itm.getIcono());
            convertView.setTag(view);
        } else {
           view = (Fila) convertView.getTag();  
        }  
        return convertView;  
    }

    public static void drawNavigationDrawer(Activity activity){

        String[] titulos;
        ListView navList;
        ArrayList<NavigationItem> navItms;
        TypedArray navIcons;
        NavigationAdapter navAdapter;

        navList = (ListView) activity.findViewById(R.id.listaNav);
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout);
        navList.setOnItemClickListener(new SlideMenuClickListener());

        View header = activity.getLayoutInflater().inflate(R.layout.navigation_header, null);
        navList.addHeaderView(header);

        navIcons = activity.getResources().obtainTypedArray(R.array.navigation_iconos);
        titulos = activity.getResources().getStringArray(R.array.nav_options);

        navItms = new ArrayList<NavigationItem>();
        navItms.add(new NavigationItem(titulos[0], navIcons.getResourceId(0, -1)));
        navItms.add(new NavigationItem(titulos[1], navIcons.getResourceId(1, -1)));
        navItms.add(new NavigationItem(titulos[2], navIcons.getResourceId(2, -1)));
        navItms.add(new NavigationItem(titulos[3], navIcons.getResourceId(3, -1)));
        navItms.add(new NavigationItem(titulos[4], navIcons.getResourceId(4, -1)));


        navAdapter= new NavigationAdapter(activity,navItms);
        navList.setAdapter(navAdapter);
        navLista = navList;
    }
    private static class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            displayView(position);
        }
    }

    private static void displayView(int position) {
        Intent intentLocal;

        switch (position) {
            case 1:
                intentLocal = new Intent(activity, MainActivity.class);
                activity.startActivity(intentLocal);
                break;
            case 2:
                intentLocal = new Intent(activity, CommentActivity.class);
                activity.startActivity(intentLocal);
                break;
            case 3:
                intentLocal = new Intent(activity, FriendsListActivity.class);
                activity.startActivity(intentLocal);
                break;
            case 4:
                intentLocal = new Intent(activity, GroupsListActivity.class);
                activity.startActivity(intentLocal);
                break;
            case 5:
                intentLocal = new Intent(activity, QRActivity.class);
                activity.startActivity(intentLocal);
                break;

            default:
                break;
        }
        navLista.setItemChecked(position, true);
        navLista.setSelection(position);
        drawerLayout.closeDrawer(navLista);
    }
}