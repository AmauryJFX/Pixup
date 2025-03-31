package org.torresamaury.pixup.vista.gestion;
import org.torresamaury.pixup.registro.Estado;

import java.util.ArrayList;

public class Func_Estado extends FuncionesBase<Estado> {
    private static Func_Estado func_estado;

    public static Func_Estado getInstance() {
        if (func_estado == null) {
            func_estado = new Func_Estado();
        }
        return func_estado;
    }

    @Override
    public void alta() {
        System.out.println("=== Alta de Estado ===");
        System.out.println("Ingrese el ID del Estado: ");
        int idEstado = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del Estado: ");
        String nombreEstado = scanner.nextLine();
        elementos.add(new Estado(idEstado, nombreEstado));
        System.out.println("Estado agregado exitosamente.");
    }

    @Override
    public void baja() {
        System.out.println("=== Baja de Estado ===");
        System.out.println("Ingrese el ID del Estado a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = elementos.removeIf(estado -> estado.getId().equals(idEliminar));
        if (eliminado) {
            System.out.println("Estado eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un Estado con el ID ingresado.");
        }
    }

    @Override
    public void cambios() {
        System.out.println("=== Cambios de Estado ===");
        System.out.println("Ingrese el ID del Estado a modificar: ");
        int idModificar = scanner.nextInt();
        scanner.nextLine();

        for (Estado estado : elementos) {
            if (estado.getId().equals(idModificar)) {
                System.out.println("Estado encontrado: " + estado.getNombre());
                System.out.println("Ingrese el nuevo ID del Estado (actual: " + estado.getId() + "): ");
                int nuevoId = scanner.nextInt();
                scanner.nextLine();
                System.out.println("Ingrese el nuevo nombre del Estado (actual: " + estado.getNombre() + "): ");
                String nuevoNombre = scanner.nextLine();

                estado.setId(nuevoId);
                estado.setNombre(nuevoNombre);
                System.out.println("Estado actualizado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró un Estado con el ID ingresado.");
    }

    @Override
    public void consulta() {
        System.out.println("=== Consulta de Estado ===");
        System.out.println("Ingrese el ID del Estado a consultar: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine();

        for (Estado estado : elementos) {
            if (estado.getId().equals(idConsulta)) {
                System.out.println("Información del Estado: " + estado.getNombre());
                System.out.println("ID del estado: " + estado.getId());
                return;
            }
        }
        System.out.println("No se encontró un Estado con el ID ingresado.");
    }

    @Override
    protected void mostrarMenu() {
        System.out.println("_________________________________________");
        System.out.println("Seleccione una opción:");
        System.out.println("[1] Alta de Estado");
        System.out.println("[2] Baja de Estado");
        System.out.println("[3] Cambios de Estado");
        System.out.println("[4] Consultar Estado");
        System.out.println("[5] Salir");
        System.out.println("_________________________________________");
    }
    public ArrayList<Estado> getElementos() {
        return elementos;
    }
}
