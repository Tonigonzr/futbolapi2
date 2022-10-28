package com.example.futbolapi;

import android.net.Uri;

import java.util.ArrayList;

public class futbolapi {
    ArrayList<equipos> getEquipo() {
        String url = "https://prxthhgbabeceaytlxqv.supabase.co/rest/v1/equipos?apikey=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzdXBhYmFzZSIsInJlZiI6InByeHRoaGdiYWJlY2VheXRseHF2Iiwicm9sZSI6ImFub24iLCJpYXQiOjE2NjY2OTM2MDEsImV4cCI6MTk4MjI2OTYwMX0.oa-Kzexh4abPUZ3q9P-Ar7gIueL7yHlcG18cxp6IWCM";
        ArrayList<equipos> equipo = new ArrayList<>();

        Uri Uribuilt = Uri.parse(url).buildUpon()
                .appendPath("equipo")
                .appendPath("fundacion")
                .appendPath("presidente")
                .appendPath("estadio")
                .build();
        String url1 = Uribuilt.toString();
        try {
            String result = HttpUtils.get(url);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return null;
    }




}
