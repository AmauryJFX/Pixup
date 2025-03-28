package org.torresamaury.pixup.crear;

public class Pago
{
    private Integer id;
    private String numero_tarjeta;
    private Float monto;
    //private fecha;
    private Orden orden;

    public Pago() {
    }

    public Pago(Integer id, String numero_tarjeta, Float monto, Orden orden) {
        this.id = id;
        this.numero_tarjeta = numero_tarjeta;
        this.monto = monto;
        this.orden = orden;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumero_tarjeta() {
        return numero_tarjeta;
    }

    public void setNumero_tarjeta(String numero_tarjeta) {
        this.numero_tarjeta = numero_tarjeta;
    }

    public Float getMonto() {
        return monto;
    }

    public void setMonto(Float monto) {
        this.monto = monto;
    }

    public Orden getOrden() {
        return orden;
    }

    public void setOrden(Orden orden) {
        this.orden = orden;
    }
}
