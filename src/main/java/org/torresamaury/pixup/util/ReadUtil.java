package org.torresamaury.pixup.util;

import java.util.Scanner;

public class ReadUtil
{
    private Scanner scanner;
    private static ReadUtil readUtil;

    public ReadUtil() {
    }

    public static ReadUtil getInstance() {
        if (readUtil == null) {
            readUtil = new ReadUtil();
        }
        return readUtil;
    }

    public String leer() {
        if (scanner == null) {
            scanner = new Scanner(System.in);
        }
        return scanner.next();
    }

    public Integer leerInt() {
        boolean flag = true;
        while (flag) {
            try {
                return Integer.valueOf(leer());
            } catch (NumberFormatException e) {
                System.out.println("No es un entero");
                System.out.println("Ingresa un entero");
            }
        }
        return null;
    }

    public Double leerDouble() {
        boolean flag = true;
        while (flag) {
            try {
                return Double.valueOf(leer());
            } catch (NumberFormatException e) {
                System.out.println("No es un double");
                System.out.println("Ingresa un double");
            }
        }
        return null;
    }

}
