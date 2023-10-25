package com.example.a139846mexptepeliculascadrechadelrey_jorgealejandro;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    PeliculaList peliculaList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Gson gson = new Gson();
        String jsonString = "";
        peliculaList = gson.fromJson(jsonString, PeliculaList.class);

        if (peliculaList != null) {

            List<Pelicula> peliculas = peliculaList.getPeliculas();
            LinearLayout layout = findViewById(R.id.linearLayout);
            for (Pelicula pelicula : peliculaList.getPeliculas()) {
                Button button = new Button(this);
                button.setText(pelicula.getTitulo());
                button.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, DetalleActivity.class);
                        intent.putExtra("pelicula", String.valueOf(pelicula));
                        startActivity(intent);
                    }
                });
                layout.addView(button);
            }
        }else {
            Button button = new Button(this);
            button.setText("No hay peliculas");
            button.setEnabled(false);
            LinearLayout layout = findViewById(R.id.linearLayout);
            layout.addView(button);
        }
    }
}