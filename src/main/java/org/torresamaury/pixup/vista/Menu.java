package org.torresamaury.pixup.vista;

public class Menu {

    public static void principal() {
        System.out.println("_________________________________________");
        System.out.println("    Seleccione una opción  ");
        System.out.println(" [1] Consola");
        System.out.println(" [2] Ventana");
        System.out.println(" [3] Salir");
        System.out.println("_________________________________________");
    }

    public static void principal2() {
        System.out.println("_________________________________________");
        System.out.println(" [1] Catalogo");
        System.out.println(" [2] Pendiente");
        System.out.println(" [3] Salir");
        System.out.println("_________________________________________");
    }

    public static void principal3() {
        System.out.println("_________________________________________");
        System.out.println(" [1] Estado");
        System.out.println(" [2] Municipio");
        System.out.println(" [3] Colonia");
        System.out.println(" [4] Domicilio");
        System.out.println(" [5] Salir");
        System.out.println("_________________________________________");
    }

    public static void principal4() {
        System.out.println("_________________________________________");
        System.out.println(" [1]Altas");
        System.out.println(" [2] Bajas");
        System.out.println(" [3] Cambios");
        System.out.println(" [4] Consultas");
        System.out.println(" (5) Salir");
        System.out.println("_________________________________________");
    }

    public static void opcionInvalida() {
        System.out.println("Opción invalida");
    }

    public static void Id() {
        System.out.println("Ingrese la ID");
    }

    public static void nombre() {
        System.out.println("Ingrese el Nombre");
    }

    public static void IdEstado() {
        System.out.println("Ingrese la ID del Estado");
    }

}
