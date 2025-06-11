package org.torresgranadosamaury.pixup.gui.consola;

import org.junit.jupiter.api.*;
import org.torresgranadosamaury.pixup.model.Disquera;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraCatalogoTest {

    DisqueraCatalogo catalogo = DisqueraCatalogo.getInstance();

    @Test
    void testGetInstance() {
        assertNotNull(catalogo);
    }

    @Test
    void testCargarDesdeBD() {
        List<Disquera> disqueras = catalogo.getList();
        assertNotNull(disqueras);
    }

    @Test
    void testAgregarDisquera() {
        Disquera nueva = new Disquera();
        nueva.setNombre("Test Records");

        boolean resultado = catalogo.processNewT_Test(nueva);
        assertTrue(resultado, "Debe agregarse la disquera correctamente");

        boolean encontrada = catalogo.getList().stream()
                .anyMatch(d -> "Test Records".equals(d.getNombre()));
        assertTrue(encontrada, "La disquera debería encontrarse en la lista");
    }

    @Test
    void testEditarDisquera() {
        List<Disquera> lista = catalogo.getList();
        if (lista.isEmpty()) {
            fail("No hay disqueras para editar");
        }

        Disquera primera = lista.get(0);
        String original = primera.getNombre();
        boolean actualizado = catalogo.processEditT_Test(primera, "Nombre Editado");
        assertTrue(actualizado);
        assertEquals("Nombre Editado", primera.getNombre());

    
        catalogo.processEditT_Test(primera, original);
    }

    @Test
    void testEliminarDisquera() {
        Disquera temporal = new Disquera();
        temporal.setNombre("Disquera Temporal");

        catalogo.processNewT_Test(temporal);
        List<Disquera> listaAntes = catalogo.getList();
        int sizeAntes = listaAntes.size();

        Disquera ultima = listaAntes.get(listaAntes.size() - 1);
        boolean eliminada = catalogo.eliminarPorId(ultima.getId());

        List<Disquera> listaDespues = catalogo.getList();
        int sizeDespues = listaDespues.size();

        assertTrue(eliminada, "Debe eliminarse correctamente");
        assertTrue(sizeDespues < sizeAntes, "La lista debería ser menor");
    }

    @Test
    void testGetTitulo() {
        assertEquals("Disqueras", catalogo.getTitulo());
    }

    @Test
    void testGetFile() {
        assertTrue(catalogo.getFile().getName().contains("Disquera"));
    }
}
