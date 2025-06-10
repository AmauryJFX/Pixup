package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.gui.LecturaAccion;
import org.torresgranadosamaury.pixup.negocio.Ejecutable;

public class ListaCatalogos extends LecturaAccion {
    public static ListaCatalogos listaCatalogos;

    private ListaCatalogos() {
    }

    public static ListaCatalogos getInstance() {
        if (listaCatalogos == null) {
            listaCatalogos = new ListaCatalogos();
        }
        return listaCatalogos;
    }

    @Override
    public void despliegaMenu() {
        System.out.println("Seleccione una opcion:");
        System.out.println("1.-Estado");
        System.out.println("2.-Municipio");
        System.out.println("3.-Colonia");
        System.out.println("4.- Disco");
        System.out.println("5.-Salir");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 5;
    }

    @Override
    public void procesaOpcion() {

        switch (opcion) {
            case 1 -> EstadoCatalogo.getInstance().menu();
            case 2 -> MunicipioCatalogos.getInstance().menu();
            case 3 -> System.out.println("NO IMPLEMENTADO");
            case 4 -> new MenuDisco().menu();
            case 5 -> flag = false;
            default -> System.out.println("Opción incorrecta.");
        }
    }
}
