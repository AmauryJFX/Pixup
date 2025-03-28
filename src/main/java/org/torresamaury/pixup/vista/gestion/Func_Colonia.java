package org.torresamaury.pixup.vista.gestion;

import org.torresamaury.pixup.vista.Ejecutable;

public class Func_Colonia implements Ejecutable {
    private static Func_Colonia func_colonia;

    public Func_Colonia() {
    }

    public static Func_Colonia getInstance() {
        if (func_colonia == null) {
            func_colonia= new Func_Colonia();
        }
        return func_colonia;
    }

    @Override
    public void run() {

    }
}
