package com.example.evaluacionparcial.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.evaluacionparcial.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> implements View.OnClickListener{

    private Context ct;
    ArrayList<Banderas>  banderas;

    private  View.OnClickListener listener;

    public Adapter(){
        banderas=new ArrayList<>();
    }

    public void setData(ArrayList<Banderas> banderas){
        this.banderas=banderas;
    }
    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view= layoutInflater.inflate(R.layout.listabanderas,parent,false);

        return new Adapter.ViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        Banderas bandera= banderas.get(position);
        Picasso.get().load(String.valueOf(bandera.imagenurl)).into(holder.imagen);
        holder.nombre.setText(bandera.nombre);

    }

    @Override
    public int getItemCount() {
        return banderas.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView nombre;
        ImageView imagen;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.txt_Nombre);
            imagen=itemView.findViewById(R.id.img_bandera);
        }
    }
}
