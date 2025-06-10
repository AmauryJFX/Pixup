package org.torresgranadosamaury.pixup.dao;

import org.torresgranadosamaury.pixup.model.Domicilio;

import java.util.List;

public interface DomicilioDao
{
    List<Domicilio> findAll( );
    boolean save( Domicilio domicilio );
    boolean update( Domicilio domicilio );
    boolean delete( Domicilio domicilio );
    Domicilio findById( int id );
}
