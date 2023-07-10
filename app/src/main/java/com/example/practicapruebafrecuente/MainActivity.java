package com.example.practicapruebafrecuente;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;


import com.example.practicapruebafrecuente.Adaptador.Adaptadorevista;

import com.example.practicapruebafrecuente.Modelo.Revista;
import com.example.practicapruebafrecuente.Webservice.Asynchtask;
import com.example.practicapruebafrecuente.Webservice.WebService;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity implements Asynchtask, AdapterView.OnItemClickListener {
    ListView Lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Lista = findViewById(R.id.lstlista);
        View header = getLayoutInflater().inflate(R.layout.lyheaderevisata, null);
        Lista.addHeaderView(header);

        Map<String, String> datos = new HashMap<String, String>();
        WebService ws= new WebService("https://revistas.uteq.edu.ec/ws/journals.php",
                datos, MainActivity.this, MainActivity.this);
        ws.execute("GET");
         Lista.setOnItemClickListener(this);
    }

    @Override
    public void processFinish(String result) throws JSONException {
        JSONArray jsonArray = new JSONArray(result);
        ArrayList<Revista>lstRevista= Revista.JsonObjectsBuild(jsonArray);
        Adaptadorevista adaptadorevista = new Adaptadorevista(this, lstRevista);
        Lista.setAdapter(adaptadorevista);

    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Revista revista=(Revista) parent.getItemAtPosition(position);
        String Iden = revista.getJournal_id().toString();
        Intent intent= new Intent(MainActivity.this, Edicion.class);
        Bundle Rita= new Bundle();
        Rita.putString("id",Iden);
        intent.putExtras(Rita);
        startActivity(intent);
    }
}