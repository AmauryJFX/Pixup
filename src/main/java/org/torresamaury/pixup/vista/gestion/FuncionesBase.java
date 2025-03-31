package org.torresamaury.pixup.vista.gestion;
import org.torresamaury.pixup.vista.Ejecutable;
import org.torresamaury.pixup.vista.Menu;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class FuncionesBase<T> implements Ejecutable {
    protected ArrayList<T> elementos = new ArrayList<>();
    protected static final Scanner scanner = new Scanner(System.in);

    public abstract void alta();
    public abstract void baja();
    public abstract void cambios();
    public abstract void consulta();

    @Override
    public void run() {
        boolean flag = true;
        int opcion;
        while (flag) {
            mostrarMenu();
            Menu.principal4();
            while (true) {
                try {
                    opcion = scanner.nextInt();
                    scanner.nextLine();
                    break;
                } catch (InputMismatchException e) {
                    System.out.println("Por favor, ingrese un número entero válido.");
                    scanner.next();
                }
            }
            switch (opcion) {
                case 1:
                    alta();
                    break;
                case 2:
                    baja();
                    break;
                case 3:
                    cambios();
                    break;
                case 4:
                    consulta();
                    break;
                case 5:
                    flag = false;
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo.");
            }
        }
    }
    protected abstract void mostrarMenu();
    public abstract ArrayList<T> getElementos();
}
