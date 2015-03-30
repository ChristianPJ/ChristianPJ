package com.inftel.socialnetwork.utility;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.activity.DropboxConnnection;
import com.inftel.socialnetwork.entity.Groups;
import com.inftel.socialnetwork.services.DropboxServiceGetPhoto;

import java.util.List;

/**
 * Created by inftel10 on 23/3/15.
 */
public class SimpleArrayGroupAdapter extends ArrayAdapter<Groups> {
    private final Activity activity;
    private final List<Groups> values;
    LayoutInflater inflater;
    private DropboxConnnection dropboxConnnection;
    RoundedImageView roundedImageView;

    public SimpleArrayGroupAdapter(Activity activity, List<Groups> values,DropboxConnnection dropboxConnnection) {
        super(activity, R.layout.groups_item, values);
        this.activity = activity;
        this.values = values;
        this.dropboxConnnection = dropboxConnnection;
        inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = inflater.inflate(R.layout.groups_item, parent, false);

        TextView textTitulo = (TextView) itemView.findViewById(R.id.firstLine);
        textTitulo.setText(values.get(position).getName());

        if(values.get(position).isCreador()){
            TextView textDescription = (TextView) itemView.findViewById(R.id.secondLine);
            textDescription.setText("Creador");
        }

        ImageView imagecomment = (ImageView) itemView.findViewById(R.id.icon_group);
        String nameImage = getItem(position).getImageUrl();

        if ((nameImage!=null)&&(!nameImage.equals(""))){
            DropboxServiceGetPhoto dropboxServiceGetPhoto = new DropboxServiceGetPhoto(activity, dropboxConnnection.getmDBApi(), nameImage,imagecomment);
            dropboxServiceGetPhoto.execute();
        }

        return itemView;
    }
}

