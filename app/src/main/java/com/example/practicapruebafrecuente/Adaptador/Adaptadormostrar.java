package com.example.practicapruebafrecuente.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.practicapruebafrecuente.Modelo.Mostrar;
import com.example.practicapruebafrecuente.R;

import java.util.ArrayList;

public class Adaptadormostrar  extends ArrayAdapter <Mostrar>{
    public Adaptadormostrar(Context context, ArrayList<Mostrar> datos) {
        super(context, R.layout.lyitemmostrar, datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemmostrar, null);

        TextView Titulo = (TextView)item.findViewById(R.id.txttitulo);
        Titulo.setText(getItem(position).getTiulo());
        TextView Volume = (TextView)item.findViewById(R.id.txtvolume);
        Volume.setText(getItem(position).getVolume());
        TextView Fecha= (TextView)item.findViewById(R.id.txtfecha);
        Fecha.setText(getItem(position).getFecha());
        ImageView imageView = (ImageView)item.findViewById(R.id.Img);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);

        return(item);
}
}
