package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.dao.ArtistaDao;
import org.torresgranadosamaury.pixup.dao.impl.ArtistaDaoImpl;
import org.torresgranadosamaury.pixup.model.Artista;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.File;

public class ArtistaCatalogo extends Catalogos<Artista> {

    private static ArtistaCatalogo instancia;
    public static ArtistaCatalogo getInstance() {
        if (instancia == null) instancia = new ArtistaCatalogo();
        return instancia;
    }

    private final ArtistaDao dao = ArtistaDaoImpl.getInstance();

    private ArtistaCatalogo() {
        super();
        cargarDesdeBD();
    }

    private void cargarDesdeBD() { list = dao.findAll(); }
    private void refresh()        { cargarDesdeBD(); }

    @Override public Artista newT() { return new Artista(); }


    @Override
    public boolean processNewT(Artista a) {
        System.out.print("Nombre del artista: ");
        a.setNombre(ReadUtil.read());
        if (dao.save(a)) {
            list.add(a);
            return true;
        }
        System.out.println("Error al guardar en BD.");
        return false;
    }

    @Override
    public void processEditT(Artista a) {
        System.out.println("Nombre actual: " + a.getNombre());
        System.out.print("Nuevo nombre: ");
        a.setNombre(ReadUtil.read());
        if (dao.update(a)) {
            System.out.println("Artista modificado.");
        } else {
            System.out.println("Error al modificar en BD.");
        }
    }
    
    @Override
    public void remove() {
        refresh();
        super.remove();
        if (t != null) dao.delete(t);
    }

    @Override public void print() {
        refresh();
        super.print();
    }

    @Override public File getFile()     { return new File("Artista.list"); }
    @Override public String getTitulo() { return "Artistas"; }
}
