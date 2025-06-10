package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.dao.DiscoDao;
import org.torresgranadosamaury.pixup.dao.impl.DiscoDaoImpl;
import org.torresgranadosamaury.pixup.gui.LecturaAccion;
import org.torresgranadosamaury.pixup.model.Disco;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

public class DiscoCatalogo extends LecturaAccion {

    /* ---------- singleton ---------- */
    private static DiscoCatalogo instancia;

    public static DiscoCatalogo getInstance() {
        if (instancia == null) instancia = new DiscoCatalogo();
        return instancia;
    }

    private final DiscoDao dao = DiscoDaoImpl.getInstance();
    private final Scanner sc = new Scanner(System.in);

    private DiscoCatalogo() {
        super();
    }

    /* ---------- menú ---------- */
    @Override
    public void despliegaMenu() {
        System.out.println("\n--- Menú Disco ---");
        System.out.println("1. Agregar Disco");
        System.out.println("2. Modificar Disco");
        System.out.println("3. Buscar Disco");
        System.out.println("4. Eliminar Disco");
        System.out.println("5. Regresar");
    }

    @Override
    public int valorMinMenu() {
        return 1;
    }

    @Override
    public int valorMaxMenu() {
        return 5;
    }

    @Override
    public void procesaOpcion() {
        switch (opcion) {
            case 1 -> agregarDisco();
            case 2 -> modificarDisco();
            case 3 -> buscarDisco();
            case 4 -> eliminarDisco();
        }
    }

    /* ---------- agregar ---------- */
    private void agregarDisco() {
        Disco d = new Disco();

        System.out.print("Título: ");
        d.setTitulo(sc.nextLine().trim());
        System.out.print("Precio: ");
        d.setPrecio(ReadUtil.readFloat());
        System.out.print("Existencia: ");
        d.setExistencia(ReadUtil.readInt());
        System.out.print("Descuento (0 = sin): ");
        d.setDescuento(ReadUtil.readFloat());

        while (true) {
            try {
                System.out.print("Fecha (AAAA-MM-DD): ");
                d.setFechaLanzamiento(LocalDate.parse(sc.nextLine().trim()));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida.");
            }
        }

        System.out.print("Imagen: ");
        d.setImagen(sc.nextLine().trim());
        System.out.print("ID Artista: ");
        d.setIdArtista(ReadUtil.readInt());
        System.out.print("ID Disquera: ");
        d.setIdDisquera(ReadUtil.readInt());
        System.out.print("ID Género Musical: ");
        d.setIdGeneroMusical(ReadUtil.readInt());

        System.out.println(dao.save(d) ? "Disco guardado." : "Error al guardar.");
    }

    /* ---------- modificar ---------- */
    private void modificarDisco() {
        System.out.print("ID a modificar: ");
        int id = ReadUtil.readInt();
        Disco d = dao.findById(id);
        if (d == null) {
            System.out.println("No existe.");
            return;
        }

        System.out.printf("Título (%s): ", d.getTitulo());
        String in = sc.nextLine().trim();
        if (!in.isBlank()) d.setTitulo(in);

        System.out.printf("Precio (%.2f): ", d.getPrecio());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setPrecio(Float.parseFloat(in));

        System.out.printf("Existencia (%d): ", d.getExistencia());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setExistencia(Integer.parseInt(in));

        System.out.printf("Descuento (%.2f): ", d.getDescuento());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setDescuento(Float.parseFloat(in));

        while (true) {
            System.out.printf("Fecha (%s, Enter=igual): ", d.getFechaLanzamiento());
            in = sc.nextLine().trim();
            if (in.isBlank()) break;
            try {
                d.setFechaLanzamiento(LocalDate.parse(in));
                break;
            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida.");
            }
        }

        System.out.printf("Imagen (%s): ", d.getImagen());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setImagen(in);

        System.out.printf("ID Artista (%d): ", d.getIdArtista());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setIdArtista(Integer.parseInt(in));

        System.out.printf("ID Disquera (%d): ", d.getIdDisquera());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setIdDisquera(Integer.parseInt(in));

        System.out.printf("ID Género (%d): ", d.getIdGeneroMusical());
        in = sc.nextLine().trim();
        if (!in.isBlank()) d.setIdGeneroMusical(Integer.parseInt(in));

        System.out.println(dao.update(d) ? "Disco modificado." : "Error al modificar.");
    }

    /* ---------- buscar ---------- */
    private void buscarDisco() {
        System.out.print("ID: ");
        int id = ReadUtil.readInt();
        Disco d = dao.findById(id);
        if (d == null) {
            System.out.println("No existe.");
            return;
        }

        System.out.printf("%nID: %d%nTítulo: %s%nPrecio: %.2f%nExistencia: %d%nDescuento: %.2f%n" +
                        "Fecha: %s%nImagen: %s%nArtista: %d%nDisquera: %d%nGénero: %d%n",
                d.getId(), d.getTitulo(), d.getPrecio(), d.getExistencia(),
                d.getDescuento(), d.getFechaLanzamiento(), d.getImagen(),
                d.getIdArtista(), d.getIdDisquera(), d.getIdGeneroMusical());
    }

    /* ---------- eliminar ---------- */
    private void eliminarDisco() {
        System.out.print("ID a eliminar: ");
        int id = ReadUtil.readInt();
        Disco d = dao.findById(id);
        if (d == null) {
            System.out.println("No existe.");
            return;
        }

        System.out.print("¿Seguro? 1=Sí 0=No: ");
        if (ReadUtil.readInt() == 1)
            System.out.println(dao.delete(d) ? "Eliminado." : "Error al eliminar.");
        else
            System.out.println("Cancelado.");
    }

    public void menu() {
        int op;
        do {
            despliegaMenu();
            op = ReadUtil.readInt();
            if (op >= valorMinMenu() && op <= valorMaxMenu()) {
                opcion = op;
                procesaOpcion();
            } else {
                System.out.println("Opción fuera de rango");
            }
        } while (op != valorMaxMenu());
    }
}
