package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.util.ReadUtil;

public class MenuDisco {

    public void menu() {
        boolean back = false;
        while (!back) {
            System.out.println("\n--- Sub-menú Disco ---");
            System.out.println("1. Disco");
            System.out.println("2. Artista");
            System.out.println("3. Cancion");
            System.out.println("4. Disquera");
            System.out.println("5. Genero Musical");
            System.out.println("6. Regresar");

            switch (ReadUtil.readInt()) {
                case 1 -> DiscoCatalogo.getInstance().menu();
                case 2 -> ArtistaCatalogo.getInstance().menu();
                case 3 -> CancionCatalogo.getInstance().menu();
                case 4 -> DisqueraCatalogo.getInstance().menu();
                case 5 -> GeneroMusicalCatalogo.getInstance().menu();
                case 6 -> back = true;
                default -> System.out.println("Opción incorrecta.");
            }
        }
    }
}
