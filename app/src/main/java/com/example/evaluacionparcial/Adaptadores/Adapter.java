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
    LayoutInflater inflater;
    ArrayList<Banderas> model;

    //Listener
    private  View.OnClickListener listener;

    public Adapter(Context context, ArrayList<Banderas> model){
        this.inflater= LayoutInflater.from(context);
        this.model = model;
    }

    public void setData(ArrayList<Banderas> banderas){
        this.model=banderas;
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
        View view=inflater.inflate(R.layout.listabanderas,parent,false);
        view.setOnClickListener(this);
        return new ViewHolder(view);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        String nombre=model.get(position).getName();
        Picasso.get().load(model.).into(holder.imagen);
        holder.nombre.setText(nombre);
        holder.imagen.setImageResource(imagen);
    }

    @Override
    public int getItemCount() {
        return 0;
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
