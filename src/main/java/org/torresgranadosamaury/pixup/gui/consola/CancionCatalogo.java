package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.dao.CancionDao;
import org.torresgranadosamaury.pixup.dao.impl.CancionDaoImpl;
import org.torresgranadosamaury.pixup.model.Cancion;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.File;

public class CancionCatalogo extends Catalogos<Cancion> {

    private static CancionCatalogo instancia;
    private final CancionDao dao = CancionDaoImpl.getInstance();

    private CancionCatalogo() { super(); cargarDesdeBD(); }

    public static CancionCatalogo getInstance() {
        if (instancia == null) instancia = new CancionCatalogo();
        return instancia;
    }

    private void cargarDesdeBD() { list = dao.findAll(); }
    private void refresh()       { cargarDesdeBD(); }

    @Override public Cancion newT() { return new Cancion(); }

    @Override
    public boolean processNewT(Cancion c) {
        System.out.print("Título: ");
        c.setTitulo(ReadUtil.read());

        System.out.print("Duración (segundos): ");
        c.setDuracionSegundos(ReadUtil.readInt());

        System.out.print("ID Disco: ");
        c.setIdDisco(ReadUtil.readInt());

        if (dao.save(c)) {
            list.add(c);
            return true;
        }
        System.out.println("Error al guardar en BD.");
        return false;
    }

    @Override
    public void processEditT(Cancion c) {
        System.out.println("Título actual: " + c.getTitulo());
        System.out.print("Nuevo título: ");
        c.setTitulo(ReadUtil.read());

        System.out.println("Duración actual: " + c.getDuracionSegundos());
        System.out.print("Nueva duración (segundos): ");
        c.setDuracionSegundos(ReadUtil.readInt());

        System.out.println("ID Disco actual: " + c.getIdDisco());
        System.out.print("Nuevo ID Disco: ");
        c.setIdDisco(ReadUtil.readInt());

        if (dao.update(c))
            System.out.println("Canción modificada.");
        else
            System.out.println("Error al modificar en BD.");
    }

    @Override
    public void remove() {
        refresh();
        super.remove();
        if (t != null) dao.delete(t);
    }

    @Override
    public void print() {
        refresh();
        super.print();
    }

    @Override public File   getFile()   { return new File("Cancion.list"); }
    @Override public String getTitulo() { return "Canciones"; }
}
