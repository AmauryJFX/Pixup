package org.torresamaury.pixup.registro;

public class Domicilio
{

    private Integer id;
    private String nombre;
    private String num_interior;
    private String num_exterior;
    private Usuario usuario;
    private Colonia colonia;
    private Tipo_domicilio tipo_domicilio;

    public Domicilio() {
    }

    public Domicilio(Integer id, String nombre, String num_interior, String num_exterior, Usuario usuario, Colonia colonia, Tipo_domicilio tipo_domicilio) {
        this.id = id;
        this.nombre = nombre;
        this.num_interior = num_interior;
        this.num_exterior = num_exterior;
        this.usuario = usuario;
        this.colonia = colonia;
        this.tipo_domicilio = tipo_domicilio;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNum_interior() {
        return num_interior;
    }

    public void setNum_interior(String num_interior) {
        this.num_interior = num_interior;
    }

    public String getNum_exterior() {
        return num_exterior;
    }

    public void setNum_exterior(String num_exterior) {
        this.num_exterior = num_exterior;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Colonia getColonia() {
        return colonia;
    }

    public void setColonia(Colonia colonia) {
        this.colonia = colonia;
    }

    public Tipo_domicilio getTipo_domicilio() {
        return tipo_domicilio;
    }

    public void setTipo_domicilio(Tipo_domicilio tipo_domicilio) {
        this.tipo_domicilio = tipo_domicilio;
    }
}
