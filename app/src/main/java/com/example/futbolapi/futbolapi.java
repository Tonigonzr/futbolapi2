package com.example.futbolapi;

import android.net.Uri;
import android.util.Log;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class futbolapi extends SecondFragment{

   public ArrayList<equipos> getEquipo() {
       String url = "https://prxthhgbabeceaytlxqv.supabase.co/rest/v1/equipos?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InByeHRoaGdiYWJlY2VheXRseHF2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjY2OTM2MDEsImV4cCI6MTk4MjI2OTYwMX0.oa-Kzexh4abPUZ3q9P-Ar7gIueL7yHlcG18cxp6IWCM";



        try {
            String result = HttpUtils.get(url);
            JSONArray jsonResult = new JSONArray(result);
            ArrayList<equipos> equipo = new ArrayList<>();

            for (int i = 0; i<jsonResult.length(); i++){
                JSONObject futboljson = jsonResult.getJSONObject(i);
                equipos equiposs = new equipos();

                equiposs.setNombre(futboljson.getString("nombre"));
                equiposs.setImagen(futboljson.getString("imagenes"));
                equipo.add(equiposs);

            }
            return equipo;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




}
