package com.example.evaluacionparcial.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.evaluacionparcial.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class Adaptador extends RecyclerView.Adapter<BanderasViewHolder> implements View.OnClickListener {

    private Context Ctx;
    ArrayList<Banderas> banderas;
    private  View.OnClickListener listener;

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
        //Picasso.get().load("http://www.geognos.com/api/en/countries/flag/"+bandera.alpha2Code+".png").into(holder.imagen);
        Glide.with(Ctx).load("http://www.geognos.com/api/en/countries/flag/"+bandera.alpha2Code+".png").into(holder.imagen);
        holder.nombre.setText(bandera.name);
    }
    public void setOnClickListener(View.OnClickListener listener){
        this.listener=listener;
    }
    @Override
    public int getItemCount() {
        return banderas.size();
    }

    @Override
    public void onClick(View v) {
        if (listener!=null){
            listener.onClick(v);
        }
    }

}
