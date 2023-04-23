package com.company;

import java.time.LocalDate;

public class Pelicula {
    private String titulo;
    private LocalDate fechaLanzamiento;
    private Audiencia clasificacion;
    private String duracion;
    private String paisOrigen;
    private String genero;
    private String descripcion;
    private int stock;
    private Integer vecesAlquilada;

    public Pelicula(String titulo, String duracion, String genero, String descripcion, int stock, Audiencia clasificacion) {
        this.titulo = titulo;
        this.duracion = duracion;
        this.genero = genero;
        this.descripcion = descripcion;
        this.stock = stock;
        this.vecesAlquilada = 0;
        this.clasificacion = clasificacion;
    }

    public String getTitulo() {
        return titulo;
    }

    public int getStock() {
        return stock;
    }

    public String getGenero() {
        return genero;
    }

    public Integer getVecesAlquilada() {
        return vecesAlquilada;
    }

    public Audiencia getClasificacion() {
        return clasificacion;
    }

    public void setFechaLanzamiento(LocalDate fechaLanzamiento) {
        this.fechaLanzamiento = fechaLanzamiento;
    }

    public void setClasificacion(Audiencia clasificacion) {
        this.clasificacion = clasificacion;
    }

    public void setPaisOrigen(String paisOrigen) {
        this.paisOrigen = paisOrigen;
    }

    public void sumarStock (){
        this.stock++;
    }

    public Boolean restarStock (){
        Boolean restaOk = false;
        if (this.stock>0){
            this.stock--;
            restaOk = true;
        }
        return restaOk;
    }

    public void sumarVecesAlquilada(){
        this.vecesAlquilada++;
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "titulo='" + titulo + '\'' +
                ", clasificacion='" + clasificacion + '\'' +
                ", duracion='" + duracion + '\'' +
                ", genero='" + genero + '\'' +
                ", descripcion='" + descripcion + '\'' +
                ", stock=" + stock +
                ", vecesAlquilada=" + vecesAlquilada +
                '}';
    }
}
