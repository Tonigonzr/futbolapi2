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

    public Adaptador(@NonNull Context context, int lw_futbol_row, int resource, List<equipos> ob) {
        super(context, resource, ob);
    }

    public View getView(int pos, View converView, ViewGroup parent){
        equipos equipo = getItem(pos);

        if(converView == null){
            LayoutInflater inf = LayoutInflater.from(getContext());
            converView = inf.inflate(R.layout.lw_futbol_row, parent,false);
        }

        TextView txtEquipo = converView.findViewById(R.id.txtEquipo);
        TextView txtFundacion = converView.findViewById(R.id.txtFundacion);
        TextView txtPresidente = converView.findViewById(R.id.txtPresidente);
        TextView txtEstadio = converView.findViewById(R.id.txtEstadio);
        ImageView imgEquipo = converView.findViewById(R.id.img3esc);

        txtEquipo.setText(equipo.getNombre());
        txtFundacion.setText(equipo.getFundacion());
        txtPresidente.setText(equipo.getPresidente());
        txtEstadio.setText(equipo.getEstadio());

        Glide.with(getContext()).load(equipo.getImagen()).into(imgEquipo);

        return converView;
    }
}
