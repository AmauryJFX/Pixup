package org.torresamaury.pixup.inicio;

import org.torresamaury.pixup.util.ReadUtil;
import org.torresamaury.pixup.vista.Consola;
import org.torresamaury.pixup.vista.Ejecutable;
import org.torresamaury.pixup.vista.Menu;
import org.torresamaury.pixup.vista.Ventana;

public class Inicio {

    public Inicio() {
    }

    public static void main(String[] args) {

        boolean flag = true;
        int opcion = 0;
        Ejecutable ejecutable = null;
        while (flag) {
            ejecutable = null;
            Menu.principal();
            opcion = ReadUtil.getInstance().leerInt();
            switch (opcion) {
                case 1:
                    ejecutable = Consola.getInstance();
                    break;
                case 2:
                    ejecutable = Ventana.getInstance();
                    break;
                case 3:
                    flag = false;
                    break;
                default:
                    Menu.opcionInvalida();
            }
            if (ejecutable != null) {
                ejecutable.run();
            }
        }
    }
}
