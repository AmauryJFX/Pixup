package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.util.ReadUtil;

/**
 * Menú principal de catálogos:
 * 1 Estado   | 2 Municipio | 3 Colonia | 4 Sub-menú Disco | 5 Salir
 */
public class MenuCatalogos {

    public void menu() {

        boolean salir = false;
        while (!salir) {

            System.out.println("\n=== Menú Catálogos ===");
            System.out.println("1. Estado");
            System.out.println("2. Municipio");
            System.out.println("3. Colonia");
            System.out.println("4. Disco");
            System.out.println("5. Salir");
            System.out.print("Elija opción: ");

            Integer op = ReadUtil.readInt();
            if (op == null) continue;

            switch (op) {
                case 1 -> EstadoCatalogo.getInstance().menu();
                case 2 -> MunicipioCatalogos.getInstance().menu();
                case 3 -> System.out.println("NO lista");
                case 4 -> new MenuDisco().menu();
                case 5 -> salir = true;
                default -> System.out.println("Opción incorrecta.");
            }
        }
    }
}
