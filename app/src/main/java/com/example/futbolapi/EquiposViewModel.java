package com.example.futbolapi;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import androidx.lifecycle.MutableLiveData;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class EquiposViewModel {

    private final Application appl;
    private MutableLiveData<List<equipos>> equipo;


    public EquiposViewModel(Application appl) {
        this.appl = appl;
    }

    public MutableLiveData<List<equipos>> getEquipos() {
        if (equipo == null) {
            equipo = new MutableLiveData<>();
        }
        return equipo;
    }

    public void refresh() {
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(appl.getApplicationContext());
        String tipo = preferences.getString("tipo", "");

        ExecutorService executor = Executors.newSingleThreadExecutor();
        executor.execute(() -> {
            futbolapi futapi = new futbolapi();
            ArrayList<equipos> pokemons = futapi.getEquipo();

            this.equipo.postValue(pokemons);
        });


    }
}

