package org.torresamaury.pixup.registro;

public class Notificacion
{
    private Integer id;
    private String fecha_notificacion;
    private Usuario usuario;
    private Tipo_notificacion tipo_notificacion;

    public Notificacion() {
    }

    public Notificacion(Integer id, String fecha_notificacion, Usuario usuario, Tipo_notificacion tipo_notificacion) {
        this.id = id;
        this.fecha_notificacion = fecha_notificacion;
        this.usuario = usuario;
        this.tipo_notificacion = tipo_notificacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFecha_notificacion() {
        return fecha_notificacion;
    }

    public void setFecha_notificacion(String fecha_notificacion) {
        this.fecha_notificacion = fecha_notificacion;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Tipo_notificacion getTipo_notificacion() {
        return tipo_notificacion;
    }

    public void setTipo_notificacion(Tipo_notificacion tipo_notificacion) {
        this.tipo_notificacion = tipo_notificacion;
    }
}
