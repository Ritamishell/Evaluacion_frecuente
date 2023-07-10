package com.example.practicapruebafrecuente.Modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Mostrar {
    private  String volume;
    private  String fecha;
    private  String portada;
    private String Tiulo;
    public Mostrar(JSONObject a) throws JSONException {

        Tiulo= a.getString("title").toString() ;
        volume = a.getString("volume").toString() ;
        fecha=a.getString("date_published").toString();
        portada=a.getString("cover").toString();
    }
    public static ArrayList<Mostrar> JsonObjectsBuild(JSONArray datos) throws JSONException {
        ArrayList<Mostrar> Mosedicion = new ArrayList<>();
        for (int i = 0; i < datos.length() && i<20; i++) {
            Mosedicion.add(new Mostrar(datos.getJSONObject(i)));
        }
        return Mosedicion;
    }

    public String getVolume() {
        return volume;
    }

    public void setVolume(String volume) {
        this.volume = volume;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }

    public String getTiulo() {
        return Tiulo;
    }

    public void setTiulo(String tiulo) {
        Tiulo = tiulo;
    }
}

