package com.example.intentobjectjava.model;

import java.io.Serializable;
//pasos para crera metodos getter and setter auto
//click derecho    generate    getter and setter    seleccionar variablers    ok y listo
@SuppressWarnings("MDetalles")
public class MDetalles implements Serializable {
    private String nombre;
    private String descripcion;
    private String imagenUrl;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getImagenUrl() {
        return imagenUrl;
    }

    public void setImagenUrl(String imagenUrl) {
        this.imagenUrl = imagenUrl;
    }
}
