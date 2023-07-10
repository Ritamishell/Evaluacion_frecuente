package com.example.practicapruebafrecuente.Adaptador;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.practicapruebafrecuente.Modelo.Revista;
import com.example.practicapruebafrecuente.R;

import java.util.ArrayList;

public class Adaptadorevista extends ArrayAdapter<Revista> {
    public Adaptadorevista(Context context, ArrayList<Revista> datos) {
        super(context, R.layout.lyitemrevista,datos);
    }
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.lyitemrevista, null);

        TextView TITULO = (TextView)item.findViewById(R.id.Titulo);
        TITULO.setText(getItem(position).getTitulo());

        ImageView imageView = (ImageView)item.findViewById(R.id.Portada);
        Glide.with(this.getContext())
                .load(getItem(position).getPortada())
                .into(imageView);

        return(item);
    }
}
