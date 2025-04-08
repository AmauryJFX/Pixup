package org.gerdoc.pixup.model;

public class Estado extends Catalogo
{
    private String nombre;

    public Estado()
    {
    }

    public String getNombre()
    {
        return nombre;
    }

    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return nombre + " (id=" + id + ")";
    }
}
