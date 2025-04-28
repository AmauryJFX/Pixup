package org.torresgranadosamaury.pixup.model;

public class Tipo_Domicilio extends Catalogo {
    private String descripcion;

    public Tipo_Domicilio() {
    }

    public Tipo_Domicilio(int id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "TipoDomicilio{" +
                "id=" + id +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}
