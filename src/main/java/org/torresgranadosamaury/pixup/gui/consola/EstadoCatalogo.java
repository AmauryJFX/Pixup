package org.torresgranadosamaury.pixup.gui.consola;

import org.torresgranadosamaury.pixup.dao.EstadoDao;
import org.torresgranadosamaury.pixup.dao.impl.EstadoDaoImpl;
import org.torresgranadosamaury.pixup.model.Estado;
import org.torresgranadosamaury.pixup.util.ReadUtil;

import java.io.File;

public class EstadoCatalogo extends Catalogos<Estado> {

    private static EstadoCatalogo estadoCatalogo;
    private final EstadoDao estadoDao;

    private EstadoCatalogo() {
        super();
        estadoDao = new EstadoDaoImpl();
        cargarDesdeBD();
    }

    public static EstadoCatalogo getInstance() {
        if (estadoCatalogo == null) {
            estadoCatalogo = new EstadoCatalogo();
        }
        return estadoCatalogo;
    }

    @Override
    public Estado newT() {
        return new Estado();
    }

    @Override
    public boolean processNewT(Estado estado) {
        System.out.println("Teclee un estado:");
        estado.setNombre(ReadUtil.read());
        if (estadoDao.save(estado)) {
            list.add(estado);
            return true;
        }
        return false;
    }

    @Override
    public void processEditT(Estado estado) {
        System.out.println("Id del Estado: " + estado.getId());
        System.out.println("Estado a editar: " + estado.getNombre());
        System.out.println("Teclee el nuevo nombre del estado:");
        estado.setNombre(ReadUtil.read());
        if (estadoDao.update(estado)) {
            System.out.println("Estado actualizado correctamente.");
        } else {
            System.out.println("Error al actualizar el estado.");
        }
    }

    @Override
    public File getFile() {
        return new File("Estado.list");
    }

    @Override
    public String getTitulo() {
        return "Estados";
    }

    public void cargarDesdeBD() {
        list = estadoDao.findAll();
    }

    @Override
    public void remove() {
        if (isListEmpty()) {
            System.out.println("No hay elementos");
            return;
        }
        flag2 = true;
        while (flag2) {
            System.out.println("Ingrese el id del elemento a borrar");
            print();
            t = list.stream().filter(e -> e.getId().equals(ReadUtil.readInt())).findFirst().orElse(null);
            if (t == null) {
                System.out.println("Id incorrecto, intente nuevamente");
            } else {
                if (estadoDao.delete(t)) {
                    list.remove(t);
                    System.out.println("Elemento borrado");
                } else {
                    System.out.println("Error al borrar el elemento de la base de datos");
                }
                flag2 = false;
            }
        }
    }
}
