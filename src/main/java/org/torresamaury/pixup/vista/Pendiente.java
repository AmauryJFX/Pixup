package org.torresamaury.pixup.vista;


public class Pendiente implements Ejecutable {

    private static Pendiente pendiente;

    public Pendiente() {
    }

    public static Pendiente getInstance() {
        if (pendiente == null) {
            pendiente = new Pendiente();
        }
        return pendiente;
    }

    @Override
    public void run() {

    }
}
