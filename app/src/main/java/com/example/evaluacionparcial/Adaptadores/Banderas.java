package com.example.evaluacionparcial.Adaptadores;

import android.widget.ImageView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Banderas {
    private String nombre, imagenurl;


    public Banderas() {

    }


        public Banderas(String nombre, String imagenurl) {
                this.nombre = nombre;
                this.imagenurl = imagenurl;
        }

        public String getNombre() {
                return nombre;
        }

        public void setNombre(String nombre) {
                this.nombre = nombre;
        }

        public String getImagenurl() {
                return imagenurl;
        }

        public void setImagenurl(String imagenurl) {
                this.imagenurl = imagenurl;
        }

    public Banderas(JSONObject a) throws JSONException {
        nombre =  a.getString("first_name").toString();
        imagenurl =  a.getString("email").toString() ;
    }
    public static ArrayList<Banderas> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Banderas> usuarios = new ArrayList<>();

        for (int i = 0; i < datos.length(); i++) {
            usuarios.add(new Banderas(datos.getJSONObject(i)));
        }
        return usuarios;
    }
}
