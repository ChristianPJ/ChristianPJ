package com.inftel.socialnetwork.utility;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.inftel.socialnetwork.R;
import com.inftel.socialnetwork.entity.Friends;
import com.inftel.socialnetwork.services.DownloadImageTask;

import java.util.List;

/**
 * Created by inftel10 on 23/3/15.
 */
public class SimpleArrayAdapter extends ArrayAdapter<Friends> {
    private final Context context;
    private final List<Friends> values;
    LayoutInflater inflater;
    Activity activity;
    private List<Friends> amigosSeleccionados;

    public SimpleArrayAdapter(Context context, List<Friends> values,List<Friends> amigosSeleccionados, Activity activity) {
        super(context, R.layout.friends_item, values);
        this.context = context;
        this.values = values;
        this.activity = activity;
        this.amigosSeleccionados = amigosSeleccionados;
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        View itemView = null;
        if (context.getClass().getName().equals("com.inftel.socialnetwork.activity.FriendsListActivity")) {
            itemView = inflater.inflate(R.layout.friends_item, parent, false);

            ImageView imagecomment = (ImageView) itemView.findViewById(R.id.icon_group);
            new DownloadImageTask(activity,imagecomment).execute(getItem(position).getFriendPhoto());


            TextView textTitulo = (TextView) itemView.findViewById(R.id.firstLine);
            textTitulo.setText(values.get(position).getFriendName());

            TextView textDescription = (TextView) itemView.findViewById(R.id.secondLine);
            textDescription.setText(values.get(position).getFriendEmail());

        } else if (context.getClass().getName().equals("com.inftel.socialnetwork.activity.NewGroupMembersActivity")) {

            itemView = inflater.inflate(R.layout.members_item, parent, false);

            ImageView imagecomment = (ImageView) itemView.findViewById(R.id.icon_group);
            new DownloadImageTask(activity,imagecomment).execute(getItem(position).getFriendPhoto());

            TextView textTitulo = (TextView) itemView.findViewById(R.id.firstLine);
            textTitulo.setText(values.get(position).getFriendName());

            TextView textDescription = (TextView) itemView.findViewById(R.id.secondLine);
            textDescription.setText(values.get(position).getFriendEmail());

            CheckBox checkbox = (CheckBox) itemView.findViewById(R.id.checkBox);
            checkbox.setOnClickListener(
                    new View.OnClickListener() {
                        @Override
                    public void onClick(View v){
                            if(((CheckBox)v).isChecked()){
                                amigosSeleccionados.add(values.get(position));
                            }
                            else{
                                amigosSeleccionados.remove(values.get(position));
                            }
                        }
                    });
        }
        return itemView;
    }
}