package com.example.a139846mexptepeliculascadrechadelrey_jorgealejandro;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.gsonp1.R;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder>  {

    private Context mContext;
    private List<PeliModelo> mData;


    public Adapter(Context mContext, List<PeliModelo> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    Button button;
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        v = inflater.inflate(R.layout.activity_detail, parent, false);

        return new MyViewHolder(v);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, @SuppressLint("RecyclerView")  int position) {                                                              //♠
        holder.titulo.setText(mData.get(position).getTitulo());
        holder.director.setText(mData.get(position).getDirector());

        Glide.with(mContext)
                .load(mData.get(position).getPortada())
                .into(holder.portada);



        /**
         NO CONSIGO QUE EL BOTON HAGA SU FUNCION
         */
        holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent intent = new Intent(mContext, PeliDetailActivity.class);
                    intent.putExtra("peliculas", String.valueOf(mData.get(position)));
                    mContext.startActivity(intent);
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e("ERROR", "onClick: " + e.getMessage());
                }
            }
        });
    }



    @Override
    public int getItemCount() {
        return mData.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView titulo;
        TextView director;
        ImageView portada;
        Button button;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            titulo = itemView.findViewById(R.id.titulo_textView);
            director = itemView.findViewById(R.id.director_textView);
            portada = itemView.findViewById(R.id.portada_imageView);

            button = itemView.findViewById(R.id.info_button);
        }
    }
}
