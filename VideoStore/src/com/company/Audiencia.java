package com.company;

public enum Audiencia {
    G("Apta para todos los públicos"), PG("Sugiere la compañía de un adulto para los menores de 10 años"),
    PG13("Sugiere la compañía de un adulto para los menores de 13 años"), R("Restringido a menores de 17 años si no es con la compañía de un adulto"),
    NC17("Contenido sólo para mayores de 18 años"),UNRATED("Películas que no han pasado el proceso de calificación");



    private String audiencia;


    private Audiencia(String audiencia){
        this.audiencia = audiencia;
    }

    public String getAudiencia(){
        return audiencia;
    }
}
