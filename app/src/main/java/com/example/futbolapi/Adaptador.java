package com.example.futbolapi;

import android.content.Context;
import android.gesture.GestureLibraries;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adaptador extends ArrayAdapter<equipos> {

    public Adaptador(@NonNull Context context, int resource, int lw_futbol_row, List<equipos> ob) {
        super(context, resource, ob);
    }

    @Override
    public View getView(int pos, View converView, ViewGroup parent){
        equipos equipo = getItem(pos);

        if(converView == null){
            LayoutInflater inf = LayoutInflater.from(getContext());
            converView = inf.inflate(R.layout.imagenynombre, parent,false);
        }

        TextView txtEquipo = converView.findViewById(R.id.txtnombre);
        ImageView imgEquipo = converView.findViewById(R.id.imgfutbol);
        txtEquipo.setText(equipo.getNombre());
        Glide.with(getContext()).load(equipo.getImagen()).into(imgEquipo);

        return converView;
    }
}
