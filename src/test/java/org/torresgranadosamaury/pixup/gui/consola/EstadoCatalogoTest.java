package org.torresgranadosamaury.pixup.gui.consola;

import org.junit.jupiter.api.Test;
import org.torresgranadosamaury.pixup.model.Estado;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstadoCatalogoTest {

    @Test
    void getInstance() {
        EstadoCatalogo catalogo = EstadoCatalogo.getInstance();
        assertNotNull(catalogo);
    }

    @Test
    void cargarDesdeBD() {
        EstadoCatalogo catalogo = EstadoCatalogo.getInstance();
        catalogo.cargarDesdeBD();
        List<Estado> estados = catalogo.getList();

        assertNotNull(estados, "La lista de estados no debería ser null");
        assertFalse(estados.isEmpty(), "La lista de estados no debería estar vacía si la BD tiene datos");
    }

    @Test
    void getTitulo() {
        EstadoCatalogo catalogo = EstadoCatalogo.getInstance();
        assertEquals("Estados", catalogo.getTitulo());
    }

    @Test
    void getFile() {
        EstadoCatalogo catalogo = EstadoCatalogo.getInstance();
        assertTrue(catalogo.getFile().getName().contains("Estado"));
    }
}
