package com.example.futbolapi;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.bumptech.glide.Glide;
import com.example.futbolapi.databinding.FragmentLvFutbolBinding;
import com.example.futbolapi.databinding.FragmentSecondBinding;

import java.util.ArrayList;

public class lv_futbol extends Fragment {

    private FragmentLvFutbolBinding binding;


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLvFutbolBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle datos = getArguments();


        if(datos != null){
            Log.e("aña","ñin");
            equipos equipo= (equipos) datos.getSerializable("item");

            binding.txtnom.setText(equipo.getNombre());
            binding.txtestadio.setText(String.valueOf(equipo.getEstadio()));
            binding.txtpresident.setText(String.valueOf(equipo.getPresidente()));
            binding.txtfunda.setText(String.valueOf(equipo.getFundacion()));

            Glide.with(getContext()).load(equipo.getImagen()).into(binding.imgequipo);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

