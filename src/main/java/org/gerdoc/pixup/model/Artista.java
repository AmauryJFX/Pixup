package org.gerdoc.pixup.model;

import java.io.Serializable;

public class Artista extends Catalogo implements Serializable
{
    private String artista;

    public Artista(String nombre) {
        this.artista = artista;
    }

    public Artista() {
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    @Override
    public String toString() {
        return "Artista{" +
                "nombre='" + artista + '\'' +
                ", id=" + id +
                '}';
    }

}
