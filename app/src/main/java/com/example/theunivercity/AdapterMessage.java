package com.example.theunivercity;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;


public class AdapterMessage  extends ArrayAdapter<Message> {

    Activity activity;
    int resource;
    List<Message> list;



    public AdapterMessage(Activity activity, int resource, List<Message> list) {
        super(activity, resource,list);
        this.activity = activity;
        this.resource = resource;
        this.list = list;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = activity.getLayoutInflater();

        View view = layoutInflater.inflate(resource,null);


        TextView sendBy =  view.findViewById(R.id.sendBy);
        TextView message = view.findViewById(R.id.messageText);
        TextView time = view.findViewById(R.id.sendTime);


        sendBy.setText(list.get(position).getSendeBy());
        message.setText(list.get(position).getMessage());
        time.setText(list.get(position).getTime());

        return view;
    }
}
