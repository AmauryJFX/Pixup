package org.torresamaury.pixup.vista.gestion;

import org.torresamaury.pixup.registro.Estado;
import org.torresamaury.pixup.registro.Municipio;
import java.util.ArrayList;

public class Func_Municipio extends FuncionesBase<Municipio> {
    private static Func_Municipio func_municipio;

    public static Func_Municipio getInstance() {
        if (func_municipio == null) {
            func_municipio = new Func_Municipio();
        }
        return func_municipio;
    }

    @Override
    public void alta() {
        System.out.println("=== Alta de Municipio ===");
        System.out.println("Ingrese el ID del Municipio: ");
        int idMunicipio = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre del Municipio: ");
        String nombreMunicipio = scanner.nextLine();

        System.out.println("Ingrese el ID del Estado asociado: ");
        int idEstado = scanner.nextInt();
        scanner.nextLine();

        Estado estadoSeleccionado = null;
        for (Estado estado : getEstados()) {
            if (estado.getId().equals(idEstado)) {
                estadoSeleccionado = estado;
                break;
            }
        }

        if (estadoSeleccionado != null) {
            elementos.add(new Municipio(idMunicipio, nombreMunicipio, estadoSeleccionado));
            System.out.println("Municipio agregado exitosamente.");
        } else {
            System.out.println("No se encontró un Estado con el ID ingresado. Municipio no agregado.");
        }
    }

    @Override
    public void baja() {
        System.out.println("=== Baja de Municipio ===");
        System.out.println("Ingrese el ID del Municipio a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = elementos.removeIf(municipio -> municipio.getId().equals(idEliminar));
        if (eliminado) {
            System.out.println("Municipio eliminado exitosamente.");
        } else {
            System.out.println("No se encontró un Municipio con el ID ingresado.");
        }
    }

    @Override
    public void cambios() {
        System.out.println("=== Cambios de Municipio ===");
        System.out.println("Ingrese el ID del Municipio a modificar: ");
        int idModificar = scanner.nextInt();
        scanner.nextLine();

        for (Municipio municipio : elementos) {
            if (municipio.getId().equals(idModificar)) {
                System.out.println("Municipio encontrado: " + municipio.getNombre());
                System.out.println("Ingrese el nuevo ID del Municipio (actual: " + municipio.getId() + "): ");
                int nuevoId = scanner.nextInt();
                scanner.nextLine();

                System.out.println("Ingrese el nuevo nombre del Municipio (actual: " + municipio.getNombre() + "): ");
                String nuevoNombre = scanner.nextLine();

                municipio.setId(nuevoId);
                municipio.setNombre(nuevoNombre);
                System.out.println("Municipio actualizado exitosamente.");
                return;
            }
        }
        System.out.println("No se encontró un Municipio con el ID ingresado.");
    }

    @Override
    public void consulta() {
        System.out.println("=== Consulta de Municipio ===");
        System.out.println("Ingrese el ID del Municipio a consultar: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine();

        for (Municipio municipio : elementos) {
            if (municipio.getId().equals(idConsulta)) {
                Estado estado = municipio.getEstado();
                if (estado != null) {
                    System.out.println("El Estado es: " + estado.getNombre());
                } else {
                    System.out.println("No se encontró el Estado asociado al Municipio.");
                }
                System.out.println("El Municipio es: " + municipio.getNombre());
                System.out.println("ID del municipio: " + municipio.getId());
                return;
            }
        }
        System.out.println("No se encontró un Municipio con el ID ingresado.");
    }

    @Override
    protected void mostrarMenu() {
        System.out.println("_________________________________________");
        System.out.println("===Seleccione una opción:====");
        System.out.println("[1] Alta de Municipio");
        System.out.println("[2] Baja de Municipio");
        System.out.println("[3] Cambios de Municipio");
        System.out.println("[4] Consultar Municipio");
        System.out.println("[5] Salir");
        System.out.println("_________________________________________");
    }

    @Override
    public ArrayList<Municipio> getElementos() {
        return elementos;
    }

    private ArrayList<Estado> getEstados() {
        return Func_Estado.getInstance().getElementos();
    }
}
