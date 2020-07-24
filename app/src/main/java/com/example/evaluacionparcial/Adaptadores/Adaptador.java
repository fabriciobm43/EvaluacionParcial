package com.example.evaluacionparcial.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacionparcial.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<BanderasViewHolder> {

    private Context ct;
    ArrayList<Banderas> banderas;

    public Adaptador(){
        banderas=new ArrayList<>();
    }

    public void setData(ArrayList<Banderas> banderas){
        this.banderas=banderas;
    }
    @NonNull
    @Override
    public BanderasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.listabanderas,parent,false);

        return new BanderasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BanderasViewHolder holder, int position) {

        Banderas bandera= banderas.get(position);
        Picasso.get().load(bandera.flag).into(holder.imagen);
        holder.nombre.setText(bandera.name);
    }

    @Override
    public int getItemCount() {
        return banderas.size();
    }
}
