package com.example.a139846mexptepeliculascadrechadelrey_jorgealejandro;

import com.google.gson.annotations.SerializedName;

public class Pelicula {
    @SerializedName("titulo")
    private String titulo;
    @SerializedName("director")
    private String director;
    @SerializedName("actores")
    private String actores;
    @SerializedName("portada")
    private String portada;

    public Pelicula(String titulo, String director, String actores, String portada) {
        this.titulo = titulo;
        this.director = director;
        this.actores = actores;
        this.portada = portada;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getActores() {
        return actores;
    }

    public void setActores(String actores) {
        this.actores = actores;
    }

    public String getPortada() {
        return portada;
    }

    public void setPortada(String portada) {
        this.portada = portada;
    }
}
