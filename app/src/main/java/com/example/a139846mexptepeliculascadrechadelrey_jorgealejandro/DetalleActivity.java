package com.example.a139846mexptepeliculascadrechadelrey_jorgealejandro;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;

public class DetalleActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);

        Pelicula pelicula = (Pelicula) getIntent().getSerializableExtra("pelicula");

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView titulo = findViewById(R.id.titulo);
        titulo.setText(pelicula.getTitulo());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        TextView director = findViewById(R.id.director);
        director.setText(pelicula.getDirector());

        @SuppressLint({"MissingInflatedId", "LocalSuppress"})
        ImageView portada = findViewById(R.id.portada);
        Glide.with(this).load(pelicula.getPortada()).into(portada);
    }
}
