package org.gerdoc.pixup.model;

import java.io.Serializable;

public class Domicilio extends Catalogo implements Serializable
{
    private String nombre;
    private String numExterior;
    private String numInterior;
    private Colonia colonia;

    public Domicilio()
    {
    }

    public Domicilio(String nombre, String numExterior, String numInterior, Colonia colonia)
    {
        this.nombre = nombre;
        this.numExterior = numExterior;
        this.numInterior = numInterior;
        this.colonia = colonia;
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    public String getNumExterior()
    {
        return numExterior;
    }

    public void setNumExterior(String numExterior)
    {
        this.numExterior = numExterior;
    }

    public String getNumInterior()
    {
        return numInterior;
    }

    public void setNumInterior(String numInterior)
    {
        this.numInterior = numInterior;
    }

    public Colonia getColonia()
    {
        return colonia;
    }

    public void setColonia(Colonia colonia)
    {
        this.colonia = colonia;
    }

    @Override
    public String toString() {
        return "Domicilio{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", numExterior='" + numExterior + '\'' +
                ", numInterior='" + numInterior + '\'' +
                ", colonia=" + (colonia != null ?
                "Colonia{id=" + colonia.getId() +
                        ", nombre='" + colonia.getNombre() + '\'' +
                        ", cp='" + colonia.getCp() + '\'' +
                        ", municipio=" + (colonia.getMunicipio() != null ?
                        "Municipio{id=" + colonia.getMunicipio().getId() +
                                ", nombre='" + colonia.getMunicipio().getNombre() + '\'' +
                                "}" : "null") +
                        "}" : "null") +
                '}';
    }

    public void setDomicilio(String domicilio) {
    }
}
