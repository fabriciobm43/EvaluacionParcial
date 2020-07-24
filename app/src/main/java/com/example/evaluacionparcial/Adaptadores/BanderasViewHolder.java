package com.example.evaluacionparcial.Adaptadores;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacionparcial.R;

public class BanderasViewHolder extends RecyclerView.ViewHolder {
    ImageView imagen;
    TextView nombre;

    public BanderasViewHolder(@NonNull View itemView) {
        super(itemView);
        nombre=itemView.findViewById(R.id.txt_nombre);
        imagen=itemView.findViewById(R.id.imagen);

    }
}
