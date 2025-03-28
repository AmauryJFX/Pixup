package org.torresamaury.pixup.vista;

import org.torresamaury.pixup.util.ReadUtil;

public class Consola implements Ejecutable {
    private static Consola consola;

    public Consola() {
    }

    public static Consola getInstance() {
        if (consola == null) {
            consola = new Consola();
        }
        return consola;
    }

    @Override
    public void run() {
        boolean flag = true;
        int opcion = 0;
        Ejecutable ejecutable = null;
        while (flag) {
            ejecutable = null;
            Menu.principal2();
            opcion = ReadUtil.getInstance().leerInt();
            switch (opcion) {
                case 1:
                    ejecutable = Catalogo.getInstance();
                    break;
                case 2:
                    ejecutable = Pendiente.getInstance();
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
