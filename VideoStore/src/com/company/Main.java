package com.company;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {

        VideoStore videoStore = new VideoStore();


        // creamos peliculas
        Pelicula pelicula = new Pelicula("Nintendo","2,5","accion","linda",1, Audiencia.NC17);
        videoStore.getPeliculas().add(pelicula);
        System.out.println("Audiencia de una pelicula " + pelicula.getClasificacion().getAudiencia());
        pelicula = new Pelicula("Luca","2,5","infantil","linda",3, Audiencia.G);
        videoStore.getPeliculas().add(pelicula);
        pelicula = new Pelicula("Red","2,5","infantil","linda",3,Audiencia.G);
        videoStore.getPeliculas().add(pelicula);
        pelicula = new Pelicula("Gato con botas","2,5","infantil","linda",3, Audiencia.G);
        videoStore.getPeliculas().add(pelicula);

	   // creamos clientes
        Cliente cliente = new Cliente("Felice","Karina","32101068");
        videoStore.getClientes().add(cliente);
        cliente = new Cliente("Barreiro","Santino","50457524");
        videoStore.getClientes().add(cliente);
        cliente = new Cliente("Barreiro","Dominick","48457524");
        videoStore.getClientes().add(cliente);
        cliente = new Cliente("Lopez","Juan","34567345");
        videoStore.getClientes().add(cliente);


        System.out.println((videoStore.alquilarPelicula("Luca","50457524"))==true?"Alquiler exitoso":"Error en alquiler");
        System.out.println((videoStore.alquilarPelicula("Nintendo","32101068"))==true?"Alquiler exitoso":"Error en alquiler");
        System.out.println((videoStore.alquilarPelicula("Nintendo","32101068"))==true?"Alquiler exitoso":"Error en alquiler");
        System.out.println((videoStore.alquilarPelicula("Luca","48457524"))==true?"Alquiler exitoso":"Error en alquiler");
        System.out.println((videoStore.alquilarPelicula("Gato con botas","34567345"))==true?"Alquiler exitoso":"Error en alquiler");
        System.out.println("ALQUILER VIGENTES   " + videoStore.getAlquileres());
        System.out.println("HISTORIAL DE ALQUILER   " + videoStore.getHistorial());
        System.out.println("*********************************************");

        System.out.println((videoStore.devolverPelicula("50457524"))==true?"Devolucion exitoso":"Error devolucion");
        System.out.println((videoStore.devolverPelicula("34567345"))==true?"Devolucion exitoso":"Error devolucion");
        System.out.println("ALQUILER VIGENTES   " + videoStore.getAlquileres());
        System.out.println("HISTORIAL DE ALQUILER   " + videoStore.getHistorial());
        System.out.println("*********************************************");

        //devuelve los aquileres de la fecha pasada por parametro
        System.out.println("ALQUILER QUE SE DEVUELVEN HOY (por parametro)   " + videoStore.devolucionesDelDia(LocalDate.of(2023,04,25)));
        //es correcto que me devuelva vacio ya que no tengo alquileres que se deban devolver el dia de hoy
        System.out.println("ALQUILER QUE SE DEVUELVEN HOY (sin parametro)   " + videoStore.devolucionesDelDia());

        System.out.println("HISTORIAL DE ALQUILER ordenada por veces alquilada  " + videoStore.alquileresOrdenadosPorVecesAlquiladas());

        System.out.println("HISTORIAL DE ALQUILER ordenada por veces alquilada por genero " + videoStore.alquileresOrdenadosPorVecesAlquiladas("infantil"));

        System.out.println("HISTORIAL DE ALQUILER por cliente " + videoStore.alquileresPorCliente("50457524"));



    }
}
