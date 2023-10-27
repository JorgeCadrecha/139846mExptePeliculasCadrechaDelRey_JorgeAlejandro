package com.example.a139846mexptepeliculascadrechadelrey_jorgealejandro;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gsonp1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class MainActivity extends AppCompatActivity  {

    private static final String JSON_URL = "https://uax.tionazo.com/pelis/peliculas.json";


    List<PeliModelo> Listapeliculas;
    RecyclerView recyclerView;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {                                                                            //♠
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Listapeliculas = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerView);



        GetData getData = new GetData();
        getData.execute();
    }

    public class GetData extends AsyncTask<String, String, String>{

        @Override
        protected String doInBackground(String... strings) {

            String actual = "";

            try{
                URL url;
                HttpURLConnection Conexion_con_url = null;

                try{
                    url = new URL(JSON_URL);
                    Conexion_con_url = (HttpURLConnection) url.openConnection();

                    InputStream is = Conexion_con_url.getInputStream();
                    InputStreamReader isr = new InputStreamReader(is);

                    int datos = isr.read();
                    while(datos != -1){
                        actual += (char) datos;
                        datos = isr.read();
                    }
                    return  actual;

                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }finally {
                    if(Conexion_con_url != null){
                        Conexion_con_url.disconnect();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

            return actual;
        }



        @Override
        protected void onPostExecute(String s){
            try {
                JSONObject jsonObject = new JSONObject(s);
                JSONArray jsonArray = jsonObject.getJSONArray("peliculas");

                for (int i = 0; i < jsonArray.length(); i++){
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);

                    PeliModelo model = new PeliModelo();
                    model.setTitulo(jsonObject1.getString("titulo"));
                    model.setDirector(jsonObject1.getString("director"));
                    model.setActores(Collections.singletonList(jsonObject1.getString("actores")));

                    model.setPortada(jsonObject1.getString("portada"));

                    Listapeliculas.add(model);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
            PonerDatosEnRecyclerView(Listapeliculas);
        }
    }
    private void PonerDatosEnRecyclerView(List<PeliModelo> movieList) {
        Adapter adapter = new Adapter(this, movieList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(adapter);
    }
}