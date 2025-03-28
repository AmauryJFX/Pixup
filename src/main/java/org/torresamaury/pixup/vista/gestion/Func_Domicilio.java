package org.torresamaury.pixup.vista.gestion;

import org.torresamaury.pixup.vista.Ejecutable;

public class Func_Domicilio implements Ejecutable
{
    private static Func_Domicilio func_domicilio;

    public Func_Domicilio() {
    }

    public static Func_Domicilio getInstance() {
        if (func_domicilio == null){
         func_domicilio = new Func_Domicilio();
        }
        return func_domicilio;
    }

    @Override
    public void run() {

    }
}
