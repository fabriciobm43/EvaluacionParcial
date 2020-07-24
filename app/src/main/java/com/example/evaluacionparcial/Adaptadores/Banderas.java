package com.example.evaluacionparcial.Adaptadores;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Banderas {
     String name, alpha2Code;

        public Banderas(){

        }

    public Banderas(String name, String alpha2Code) {
        this.name = name;
        this.alpha2Code = alpha2Code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAlpha2Code() {
        return alpha2Code;
    }

    public void setAlpha2Code(String alpha2Code) {
        this.alpha2Code = alpha2Code;
    }

    public Banderas(JSONObject a) throws JSONException {
        name =  a.getString("name").toString();
        alpha2Code =  a.getString("alpha2Code").toString() ;


    }

    public static ArrayList<Banderas> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Banderas> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Banderas(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}
