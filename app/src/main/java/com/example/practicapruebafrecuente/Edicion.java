package com.example.practicapruebafrecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.practicapruebafrecuente.Adaptador.Adaptadormostrar;
import com.example.practicapruebafrecuente.Modelo.Mostrar;

import com.example.practicapruebafrecuente.Webservice.Asynchtask;
import com.example.practicapruebafrecuente.Webservice.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Edicion extends AppCompatActivity implements Asynchtask {
  private ListView Lis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edicion);

         Bundle Rita= this.getIntent().getExtras();

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/issues.php?j_id="
                +Rita.getString("id"),
                datos, Edicion.this, Edicion.this);
        ws.execute("GET");

        Lis = (ListView) findViewById(R.id.lstvolumen);
        View header = getLayoutInflater().inflate(R.layout.lyheaderedicion, null);
        Lis.addHeaderView(header);


    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Mostrar> lstlibros= Mostrar.JsonObjectsBuild(jsonArray);
        Adaptadormostrar mostrar = new Adaptadormostrar(Edicion.this, lstlibros);
        Lis.setAdapter(mostrar);
    }
}