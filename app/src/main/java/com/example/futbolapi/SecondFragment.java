package com.example.futbolapi;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.preference.PreferenceManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.futbolapi.databinding.FragmentSecondBinding;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;
    private Adaptador adapter;
    ArrayList<equipos> equipo;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


        equipo = new ArrayList<>();
        adapter = new Adaptador(
                getContext(),
                R.layout.imagenynombre,
                R.id.txtnombre,
                equipo
        );

        binding.lvfutbol.setAdapter(adapter);
        refresh();
        binding.lvfutbol.setOnItemClickListener((adapter, view1, i, l) -> {
                equipos item = (equipos)adapter.getItemAtPosition(i);

                Bundle datos = new Bundle();

                datos.putSerializable("item", item);

                NavHostFragment.findNavController(this).navigate(R.id.action_SecondFragment_to_lv_futbol);
        });
        super.onViewCreated(view, savedInstanceState);
    }

    public void refresh(){

        ExecutorService executor = Executors.newSingleThreadExecutor();
        Handler handler = new Handler(Looper.getMainLooper());

        executor.execute(()->{
           SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getContext());
           futbolapi api = new futbolapi();
           ArrayList<equipos> equipo1 = api.getEquipo();
           handler.post(() ->{
              adapter.clear();
              adapter.addAll(equipo1);
           });
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}