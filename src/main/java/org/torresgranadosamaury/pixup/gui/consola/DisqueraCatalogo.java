package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.dao.DisqueraDao;
import org.torresgranadosamaury.pixup.dao.impl.DisqueraDaoImpl;
import org.torresgranadosamaury.pixup.model.Disquera;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.File;

public class DisqueraCatalogo extends Catalogos<Disquera> {

    private static DisqueraCatalogo instancia;
    private final DisqueraDao dao = DisqueraDaoImpl.getInstance();

    private DisqueraCatalogo() { super(); cargarDesdeBD(); }

    public static DisqueraCatalogo getInstance() {
        if (instancia == null) instancia = new DisqueraCatalogo();
        return instancia;
    }

    private void cargarDesdeBD() { list = dao.findAll(); }
    private void refresh()       { cargarDesdeBD(); }

    @Override public Disquera newT() { return new Disquera(); }

    @Override
    public boolean processNewT(Disquera d) {
        System.out.print("Nombre disquera: ");
        d.setNombre(ReadUtil.read());
        if (dao.save(d)) { list.add(d); return true; }
        System.out.println("Error al guardar en BD."); return false;
    }

    @Override
    public void processEditT(Disquera d) {
        System.out.println("Nombre actual: " + d.getNombre());
        System.out.print("Nuevo nombre: ");
        d.setNombre(ReadUtil.read());
        if (dao.update(d))
            System.out.println("Disquera modificada.");
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

    @Override public File   getFile()   { return new File("Disquera.list"); }
    @Override public String getTitulo() { return "Disqueras"; }
    // Métodos seguros para testing automatizado sin usar ReadUtil

    public boolean processNewT_Test(Disquera d) {
        if (dao.save(d)) {
            list.add(d);
            return true;
        }
        return false;
    }

    public boolean processEditT_Test(Disquera d, String nuevoNombre) {
        d.setNombre(nuevoNombre);
        return dao.update(d);
    }

    public boolean eliminarPorId(int id) {
        t = list.stream().filter(e -> e.getId().equals(id)).findFirst().orElse(null);
        if (t != null) {
            list.remove(t);
            return dao.delete(t);
        }
        return false;
    }

}
