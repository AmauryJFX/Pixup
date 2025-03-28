package org.torresamaury.pixup.registro;

public class Tipo_domicilio
{
    private Integer id;
    private String descripcion;

    public Tipo_domicilio() {
    }

    public Tipo_domicilio(Integer id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
