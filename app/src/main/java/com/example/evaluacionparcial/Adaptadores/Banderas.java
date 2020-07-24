package com.example.evaluacionparcial.Adaptadores;

import android.widget.ImageView;

public class Banderas {
    private String nombre, imagenurl;
    private String urlavatar;

    public String getUrlavatar() {
        return urlavatar;
    }

    public void setUrlavatar(String urlavatar) {
        this.urlavatar = urlavatar;
    }

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
}
