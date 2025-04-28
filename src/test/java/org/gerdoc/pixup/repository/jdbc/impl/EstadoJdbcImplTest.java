package org.gerdoc.pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Estado;
import org.gerdoc.pixup.repository.jdbc.EstadoJdbc;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class EstadoJdbcImplTest {

    @Test
    void getInstance() {
        assertNotNull(EstadoJdbcImpl.getInstance());
    }

    @Test
    void findAll() {
        EstadoJdbc estadoJdbc=EstadoJdbcImpl.getInstance();
        List<Estado> list=estadoJdbc.findAll();
        assertNotNull( list );
        assertTrue(list.size( )>0 );
        assertEquals(3,list.size( ) );
        list.stream().forEach(System.out::println);

    }

    @Test
    void save ( )
    {
        Estado estado=new Estado();
        boolean res=false;
        EstadoJdbc estadoJdbc=EstadoJdbcImpl.getInstance();
        estado.setNombre("MORELOS");
        res=estadoJdbc.save(estado);
        assertEquals(true,res);

    }
    @Test
    void update ( )
    {
        Estado estado=new Estado();
        boolean res=false;
        estado.setNombre("Morelitos");
        estado.setId(1);
        EstadoJdbc estadoJdbc=EstadoJdbcImpl.getInstance();
        res=estadoJdbc.update(estado);
        assertEquals(true,res);

    }
}