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


public class AdapterCompte  extends ArrayAdapter<Compte> {

    Activity activity;
    int resource;
    List<Compte> list;





    public AdapterCompte(Activity activity, int resource, List<Compte> list) {
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


        TextView fullName =  view.findViewById(R.id.fullNameCompte);
        TextView numCard = view.findViewById(R.id.numCardCompte);
        TextView speciality = view.findViewById(R.id.specialityCompte);


        fullName.setText(list.get(position).getFirst_name()+" "+list.get(position).getFamily_name());
        numCard.setText(String.valueOf(list.get(position).getNum_cart()));
        speciality.setText(list.get(position).getSpeciality());

        return view;
    }
}
