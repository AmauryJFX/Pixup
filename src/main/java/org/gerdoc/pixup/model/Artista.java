package org.gerdoc.pixup.model;

import java.io.Serializable;

public class Artista extends Catalogo implements Serializable
{
    private String nombre;

    public Artista(String nombre) {
        this.nombre = nombre;
    }

    public Artista() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + nombre + '\'' +
                ", id=" + id +
                '}';
    }

}
