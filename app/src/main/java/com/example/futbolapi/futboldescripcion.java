package com.example.futbolapi;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.futbolapi.databinding.FragmentFutboldescripcionBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link futboldescripcion#newInstance} factory method to
 * create an instance of this fragment.
 */


public class futboldescripcion extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    private FragmentFutboldescripcionBinding binding;

    public futboldescripcion() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment futboldescripcion.
     */
    // TODO: Rename and change types and number of parameters
    public static futboldescripcion newInstance(String param1, String param2) {
        futboldescripcion fragment = new futboldescripcion();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFutboldescripcionBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Bundle datos = getArguments();


        if(datos != null){
            Log.e("aña","ñin");
            equipos equipo= (equipos) datos.getSerializable("items");

            binding.txtnom.setText("Nombre: "+equipo.getNombre());
            binding.txtestadio.setText("Estadio: "+equipo.getEstadio());
            binding.txtpresident.setText("Presidente: " + equipo.getPresidente());
            binding.txtfunda.setText("Fundación: "+equipo.getFundacion());

            Glide.with(getContext()).load(equipo.getImagen()).into(binding.imgequipo);
        }
    }



    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}