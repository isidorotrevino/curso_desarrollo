package com.ies.curso.tema16.micronaut.chat.dto;

import java.time.LocalDateTime;

public class Noticia {

    private LocalDateTime fecha;
    private String encabezado;

    public Noticia(){

    }
    public Noticia(LocalDateTime f,String e){
        fecha=f;
        encabezado=e;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getEncabezado() {
        return encabezado;
    }

    public void setEncabezado(String encabezado) {
        this.encabezado = encabezado;
    }
}
