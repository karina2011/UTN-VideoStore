package com.company;

import com.sun.istack.internal.NotNull;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Collections.*;
import static java.util.Comparator.comparing;

public class VideoStore {
    private List<Pelicula> peliculas;
    private List<Cliente> clientes;
    private List<Alquiler> alquileres;
    private List<Alquiler> historial;

    public VideoStore() {
        this.peliculas = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.alquileres = new ArrayList<>();
        this.historial = new ArrayList<>();
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }

    //Quiere una forma de poder consultar los alquileres vigentes.
    public List<Alquiler> getAlquileres() {
        return alquileres;
    }

    public List<Alquiler> getHistorial() {
        return historial;
    }

    //Buscamos un objeto en una lista usando stream, se los dejo para que sepan que existe y cuando quieran pueden averiguar mas sobre el tema
    public Pelicula getPelicula (String unTitulo){
        return (peliculas.stream()
                         .filter(peli->peli.getTitulo().equals(unTitulo))
                         .limit(1)
                         .findFirst().orElse(null));
    }

    //Buscamos un objeto en una lista usando foreach
    public Cliente getCliente (String unDni){
        if(!clientes.isEmpty()){
            for (Cliente unCliente: clientes) {
                if (unCliente.getDni().equals(unDni)){
                    return unCliente;
                }
            }
        }
        return null;
    }
    
    public Boolean devolverPelicula (String unDni){
        for (Alquiler unAlquiler: alquileres) {
            if(unAlquiler.getCliente().getDni().equals(unDni)){
                alquileres.remove(unAlquiler);
                unAlquiler.getPelicula().sumarStock();
                unAlquiler.setFechaDevReal(LocalDate.now());
                historial.add(unAlquiler);
                return true;
            }
        }
        return false;
    }
    
    public Boolean alquilarPelicula (String unTitulo, String unDni) {
        Boolean alquilerOk = false;
        Pelicula unaPeli = this.getPelicula(unTitulo);
        Cliente unCliente = this.getCliente(unDni);
        if ((Objects.nonNull(unaPeli)) && (unCliente != null)){
            if(unaPeli.restarStock()) {
                alquileres.add(new Alquiler(unaPeli, unCliente, LocalDate.now()));
                unaPeli.sumarVecesAlquilada();
                alquilerOk = true;
            }
        }
        return alquilerOk;

        /*
        en la linea 76 les muestro dos formas de preguntar por un objeto nulo
        la linea 79 es lo mismo que hacer:
            Alquiler unAlquiler = new Alquiler(unaPeli,unCliente, LocalDate.now());
            alquileres.add(unAlquiler);
        */
    }

    //Le puse como parametro de entrada para poder manipular la fecha y probar el metodo
    public List<Alquiler> devolucionesDelDia(LocalDate fecha){
        return(alquileres.stream()
                  .filter(unAlquiler->unAlquiler.getFechaDev().equals(fecha))
                  .collect(Collectors.toList()));
    }

    //aca seria sin pasarle la fecha
    public List<Alquiler> devolucionesDelDia(){
        return(alquileres.stream()
                .filter(unAlquiler->unAlquiler.getFechaDev().equals(LocalDate.now()))
                .collect(Collectors.toList()));
    }

    //Quiere una forma de consultar los títulos que fueron más alquilados
    public List<Alquiler> alquileresOrdenadosPorVecesAlquiladas(){
        return (historial.stream()
                          .sorted((alquiler1,alquiler2) -> alquiler1.getPelicula().getVecesAlquilada().compareTo(alquiler2.getPelicula().getVecesAlquilada()))
                          .collect(Collectors.toList()));
    }

    //También quiere poder buscar títulos por género y ordenarlos según popularidad.
    public List<Alquiler> alquileresOrdenadosPorVecesAlquiladas(String unGenero){
        List<Alquiler> listaOrdenada = this.alquileresOrdenadosPorVecesAlquiladas();
        return (listaOrdenada.stream()
                .filter (historial1 -> historial1.getPelicula().getGenero().equals(unGenero))
                .collect(Collectors.toList()));
    }

    //Quiere poder consultar los últimos 10 alquileres de cada cliente
    public List<Alquiler> alquileresPorCliente(String unDni){
        return (historial.stream()
                .limit(10)
                .filter (historial1 -> historial1.getCliente().getDni().equals(unDni))
                .collect(Collectors.toList()));
    }
    // limit and foreach
      //  products.stream().limit(10).forEach(System.out::println);
}
