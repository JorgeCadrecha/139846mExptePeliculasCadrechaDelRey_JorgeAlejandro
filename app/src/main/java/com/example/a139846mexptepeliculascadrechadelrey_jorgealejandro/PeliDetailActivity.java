package com.example.a139846mexptepeliculascadrechadelrey_jorgealejandro;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.gsonp1.R;

public class PeliDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);

        PeliModelo movie = (PeliModelo) getIntent().getSerializableExtra("movie");

        if (movie!=null){
            TextView titulo = findViewById(R.id.textView_titulo);
            TextView director = findViewById(R.id.textView_director);
            RecyclerView actores = findViewById(R.id.recyclerView_actores);
            ImageView portada = findViewById(R.id.imageView_portada);

            titulo.setText(movie.getTitulo());
            director.setText(movie.getDirector());

            Glide.with(this)
                    .load(movie.getPortada())
                    .into(portada);
        }
    }
}
