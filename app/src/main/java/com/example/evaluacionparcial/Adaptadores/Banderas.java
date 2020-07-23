package com.example.evaluacionparcial.Adaptadores;

import android.widget.ImageView;

public class Banderas {
        String name;
        ImageView imagen;
        public void Banderas(){

        }

        public Banderas(String name, ImageView imagen) {
                this.name = name;
                this.imagen = imagen;
        }

        public String getName() {
                return name;
        }

        public void setName(String name) {
                this.name = name;
        }

        public ImageView getImagen() {
                return imagen;
        }

        public void setImagen(ImageView imagen) {
                this.imagen = imagen;
        }
}
