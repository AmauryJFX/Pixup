package org.torresamaury.pixup.vista.gestion;

import org.torresamaury.pixup.registro.Datos;
import org.torresamaury.pixup.registro.Estado;
import org.torresamaury.pixup.util.ReadUtil;
import org.torresamaury.pixup.vista.Ejecutable;
import org.torresamaury.pixup.vista.Menu;
import org.torresamaury.pixup.vista.SolicitaDatos;

public class Func_Estado implements Ejecutable {
    private static Func_Estado func_estado;


    public Func_Estado() {
    }

    public static Func_Estado getInstance() {
        if (func_estado == null) {
            func_estado = new Func_Estado();
        }
        return func_estado;
    }

    @Override
    public void run() {
        boolean flag = true;
        int opcion = 0;
        Datos datos = null;
        while (flag) {
            datos = null;
            Menu.principal4();
            opcion = ReadUtil.getInstance().leerInt();
            switch (opcion) {
                case 1:
                    datos = new Estado();
                    break;
                case 2:

                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    Menu.opcionInvalida();
            }
            if (datos != null) {
                ((SolicitaDatos) datos).leerDatos();
            }
        }
    }
}
