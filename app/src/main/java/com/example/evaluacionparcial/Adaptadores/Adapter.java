package com.example.evaluacionparcial.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.evaluacionparcial.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    private Context Ctx;
    private List<Banderas> lstBanderas;

    public Adapter(Context mCtx, List<Banderas> banderas) {
        this.lstBanderas = banderas;
        Ctx=mCtx;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(Ctx);
        View view = inflater.inflate(R.layout.listabanderas, null);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Banderas bandera = lstBanderas.get(position);

        holder.nombre.setText(bandera.getName());

        Glide.with(Ctx)
                .load(bandera.getAlpha2Code())
                .into(holder.imagen);

    }

    @Override
    public int getItemCount() {
        return lstBanderas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.txt_nombre);
            imagen=itemView.findViewById(R.id.imagen);
        }
    }
}
