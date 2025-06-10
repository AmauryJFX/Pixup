package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.model.GeneroMusical;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.File;

public class GeneroMusicalCatalogo extends Catalogos<GeneroMusical> {

    private static GeneroMusicalCatalogo instancia;
    private GeneroMusicalCatalogo() { super(); }

    public static GeneroMusicalCatalogo getInstance() {
        if (instancia == null) instancia = new GeneroMusicalCatalogo();
        return instancia;
    }

    @Override public GeneroMusical newT() { return new GeneroMusical(); }

    @Override public boolean processNewT(GeneroMusical g) {
        System.out.print("Descripción del género: ");
        g.setDescripcion(ReadUtil.read());
        return true;
    }

    @Override public void processEditT(GeneroMusical g) {
        System.out.println("Descripción actual: " + g.getDescripcion());
        System.out.print("Nueva descripción: ");
        g.setDescripcion(ReadUtil.read());
    }

    @Override public File getFile() { return new File("GeneroMusical.list"); }
    @Override public String getTitulo() { return "Géneros Musicales"; }
}
