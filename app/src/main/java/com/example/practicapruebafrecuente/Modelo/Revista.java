package com.example.practicapruebafrecuente.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Revista {
    private  String Titulo;
    private String portada;
    private String journal_id;


    public Revista(JSONObject a) throws JSONException {
        Titulo = a.getString("name").toString() ;
        portada = a.getString("portada").toString() ;
        journal_id=a.getString("journal_id").toString();
    }
    public static ArrayList<Revista> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Revista> revistas = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            revistas.add(new Revista(datos.getJSONObject(i)));
        }
        return revistas;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(String journal_id) {
        this.journal_id = journal_id;
    }
}
