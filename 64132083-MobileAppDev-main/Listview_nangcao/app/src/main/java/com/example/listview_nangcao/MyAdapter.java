package com.example.listview_nangcao;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class MyAdapter extends ArrayAdapter<Phone> {
    //Khai bao bien
    Activity context;
    int idlayout;
    ArrayList<Phone> listPhone;

    public MyAdapter( Activity context, int idlayout, ArrayList<Phone> listPhone) {
        super(context, idlayout, listPhone);
        this.context = context;
        this.idlayout = idlayout;
        this.listPhone = listPhone;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // tao de chua layout
        LayoutInflater myFlater = context.getLayoutInflater();
        // dua layout vao de
        convertView = myFlater.inflate(idlayout, null);
        //lay 1 phone trong mang dua vao position
        Phone myPhone = listPhone.get(position);
        // khai bao, anh xa id va set thuoc tinh len layout
        ImageView imgPhone = convertView.findViewById(R.id.imgPhone);
        imgPhone.setImageResource(myPhone.getImage());
        TextView txtPhone = convertView.findViewById(R.id.txtPhone);
        txtPhone.setText(myPhone.getName());
        return convertView;
    }
}
