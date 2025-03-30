package org.torresamaury.pixup.vista.gestion;

import org.torresamaury.pixup.registro.Colonia;
import org.torresamaury.pixup.registro.Municipio;
import java.util.ArrayList;

public class Func_Colonia extends FuncionesBase<Colonia> {
    private static Func_Colonia func_colonia;

    public static Func_Colonia getInstance() {
        if (func_colonia == null) {
            func_colonia = new Func_Colonia();
        }
        return func_colonia;
    }

    @Override
    public void alta() {
        System.out.println("=== Alta de Colonia ===");
        System.out.println("Ingrese el ID de la Colonia: ");
        int idColonia = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Ingrese el nombre de la Colonia: ");
        String nombreColonia = scanner.nextLine();
        System.out.println("Ingrese el Código Postal de la Colonia: ");
        String cpColonia = scanner.nextLine();

        System.out.println("Ingrese el ID del Municipio asociado: ");
        int idMunicipio = scanner.nextInt();
        scanner.nextLine();

        Municipio municipioSeleccionado = null;
        for (Municipio municipio : getMunicipios()) {
            if (municipio.getId().equals(idMunicipio)) {
                municipioSeleccionado = municipio;
                break;
            }
        }

        if (municipioSeleccionado != null) {
            elementos.add(new Colonia(idColonia, nombreColonia, cpColonia, municipioSeleccionado));
            System.out.println("Colonia agregada exitosamente.");
        } else {
            System.out.println("No se encontró un Municipio con el ID ingresado. Colonia no agregada.");
        }
    }

    @Override
    public void baja() {
        System.out.println("=== Baja de Colonia ===");
        System.out.println("Ingrese el ID de la Colonia a eliminar: ");
        int idEliminar = scanner.nextInt();
        scanner.nextLine();

        boolean eliminado = elementos.removeIf(colonia -> colonia.getId().equals(idEliminar));
        if (eliminado) {
            System.out.println("Colonia eliminada exitosamente.");
        } else {
            System.out.println("No se encontró una Colonia con el ID ingresado.");
        }
    }

    @Override
    public void cambios() {
        System.out.println("=== Cambios de Colonia ===");
        System.out.println("Ingrese el ID de la Colonia a modificar: ");
        int idModificar = scanner.nextInt();
        scanner.nextLine();

        for (Colonia colonia : elementos) {
            if (colonia.getId().equals(idModificar)) {
                System.out.println("Colonia encontrada: " + colonia.getNombre());
                System.out.println("Ingrese el nuevo nombre de la Colonia (actual: " + colonia.getNombre() + "): ");
                String nuevoNombre = scanner.nextLine();
                System.out.println("Ingrese el nuevo Código Postal (actual: " + colonia.getCp() + "): ");
                String nuevoCp = scanner.nextLine();
                System.out.println("Ingrese el ID del nuevo Municipio: ");
                int nuevoIdMunicipio = scanner.nextInt();
                scanner.nextLine();

                Municipio nuevoMunicipio = null;
                for (Municipio municipio : getMunicipios()) {
                    if (municipio.getId().equals(nuevoIdMunicipio)) {
                        nuevoMunicipio = municipio;
                        break;
                    }
                }

                if (nuevoMunicipio != null) {
                    colonia.setNombre(nuevoNombre);
                    colonia.setCp(nuevoCp);
                    colonia.setMunicipio(nuevoMunicipio);
                    System.out.println("Colonia actualizada exitosamente.");
                } else {
                    System.out.println("No se encontró un Municipio con el ID ingresado. No se realizaron cambios.");
                }
                return;
            }
        }
        System.out.println("No se encontró una Colonia con el ID ingresado.");
    }

    @Override
    public void consulta() {
        System.out.println("=== Consulta de Colonia ===");
        System.out.println("Ingrese el ID de la Colonia a consultar: ");
        int idConsulta = scanner.nextInt();
        scanner.nextLine();

        for (Colonia colonia : elementos) {
            if (colonia.getId().equals(idConsulta)) {
                System.out.println("ID: " + colonia.getId());
                System.out.println("Nombre: " + colonia.getNombre());
                System.out.println("Código Postal: " + colonia.getCp());
                System.out.println("Municipio: " + colonia.getMunicipio().getNombre());
                return;
            }
        }
        System.out.println("No se encontró una Colonia con el ID ingresado.");
    }

    @Override
    protected void mostrarMenu() {
        System.out.println("_________________________________________");
        System.out.println("===Seleccione una opción:====");
        System.out.println("[1] Alta de Colonia");
        System.out.println("[2] Baja de Colonia");
        System.out.println("[3] Cambios de Colonia");
        System.out.println("[4] Consultar Colonia");
        System.out.println("[5] Salir");
        System.out.println("_________________________________________");
    }

    @Override
    public ArrayList<Colonia> getElementos() {
        return elementos;
    }

    private ArrayList<Municipio> getMunicipios() {
        return Func_Municipio.getInstance().getElementos();
    }
}