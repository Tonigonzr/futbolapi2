package com.example.futbolapi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.futbolapi.databinding.FragmentFirstBinding;

import java.util.ArrayList;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;
    private Adaptador adapter;
    ArrayList<equipos> equipo;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        equipo = new ArrayList<equipos>();
        futbolapi api = new futbolapi();
        adapter = new Adaptador(
                getContext(),
                R.layout.lw_futbol_row,
                R.id.txtEquipo,
                equipo
        );


        binding.lvfutbol.setAdapter(adapter);
        binding.lvfutbol.setOnClickListener(((adapterView, view1, i, l) -> {
            equipos it = (equipos) adapterView.getItemAtPosition(i);
            Bundle dat = new Bundle();
            dat.putSerializable("it", it);


        }
        ));


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}

