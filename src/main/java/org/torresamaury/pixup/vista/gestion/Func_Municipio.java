package org.torresamaury.pixup.vista.gestion;

import org.torresamaury.pixup.vista.Ejecutable;

public class Func_Municipio implements Ejecutable
{
  private static Func_Municipio func_municipio;

    public Func_Municipio() {
    }

    public static Func_Municipio getInstance() {
        if (func_municipio == null) {
            func_municipio = new Func_Municipio();
        }
        return func_municipio;
    }

    @Override
    public void run() {

    }
}
