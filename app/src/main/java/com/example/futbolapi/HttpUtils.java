package com.example.futbolapi;

import java.io.*;
import java.net.*;

public class HttpUtils {
    public static String get(String dUrl) throws IOException{
        URL url = new URL(dUrl);
        String r = null;

        HttpURLConnection urlC = (HttpURLConnection) url.openConnection();
        try{
            InputStream in = new BufferedInputStream(urlC.getInputStream());
            r = rs(in);
        }finally {
            urlC.disconnect();
        }
        return r;
    }

    private static String rs(InputStream in) throws IOException{
        InputStreamReader i = new InputStreamReader(in);
        BufferedReader rd = new BufferedReader(i);
        String l;
        StringBuilder res = new StringBuilder();
        while ((l = rd.readLine()) != null){
            res.append(l);
            res.append('\r');
        }
        rd.close();
        return res.toString();
    }

}
