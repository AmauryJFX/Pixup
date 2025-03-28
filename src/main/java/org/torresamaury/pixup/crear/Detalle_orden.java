package org.torresamaury.pixup.crear;

public class Detalle_orden
{
    private Integer id_disco;
    private Integer id_orden;
    private Integer cantidad;
    private Float costo;

    public Detalle_orden() {
    }

    public Detalle_orden(Integer id_disco, Integer id_orden, Integer cantidad, Float costo) {
        this.id_disco = id_disco;
        this.id_orden = id_orden;
        this.cantidad = cantidad;
        this.costo = costo;
    }

    public Integer getId_disco() {
        return id_disco;
    }

    public void setId_disco(Integer id_disco) {
        this.id_disco = id_disco;
    }

    public Integer getId_orden() {
        return id_orden;
    }

    public void setId_orden(Integer id_orden) {
        this.id_orden = id_orden;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Float getCosto() {
        return costo;
    }

    public void setCosto(Float costo) {
        this.costo = costo;
    }
}
