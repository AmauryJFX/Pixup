package org.torresgranadosamaury.pixup.dao.impl;

import org.junit.jupiter.api.*;
import org.torresgranadosamaury.pixup.dao.DisqueraDao;
import org.torresgranadosamaury.pixup.model.Disquera;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DisqueraDaoImplTest {

    private static final DisqueraDao dao = DisqueraDaoImpl.getInstance();
    private static Disquera testDisquera;

    @BeforeAll
    static void setUp() {
        testDisquera = new Disquera();
        testDisquera.setNombre("Disquera Test");
        dao.save(testDisquera);
    }

    @AfterAll
    static void tearDown() {
        dao.delete(testDisquera);
    }

    @Test
    void testSave() {
        Disquera nueva = new Disquera();
        nueva.setNombre("Temporal Save");
        boolean resultado = dao.save(nueva);
        assertTrue(resultado, "La disquera debería guardarse exitosamente");
        assertNotNull(nueva.getId(), "La disquera debería tener ID asignado");
        dao.delete(nueva);
    }
}