package com.company;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Alquiler {
    private Pelicula pelicula;
    private Cliente cliente;
    private LocalDate fechaAlquiler;
    private LocalDate fechaDevReal;
    private LocalDate fechaDev;

    public Alquiler(Pelicula pelicula, Cliente cliente, LocalDate fechaAlquiler) {
        this.pelicula = pelicula;
        this.cliente = cliente;
        this.fechaAlquiler = fechaAlquiler;
        this.fechaDev= fechaAlquiler.plusDays(2);
    }

    public Pelicula getPelicula() {
        return pelicula;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public LocalDate getFechaDev() {
        return fechaDev;
    }

    public void setFechaDevReal(LocalDate fechaDevReal) {
        this.fechaDevReal = fechaDevReal;
    }

    @Override
    public String toString() {
        return "Alquiler{" +
                "pelicula=" + pelicula +
                ", cliente=" + cliente +
                ", fechaAlquiler=" + fechaAlquiler +
                ", fechaDevReal=" + fechaDevReal +
                ", fechaDev=" + fechaDev +
                "\n" +
                '}';
    }
}
