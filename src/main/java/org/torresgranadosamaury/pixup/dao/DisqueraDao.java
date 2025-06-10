package org.torresgranadosamaury.pixup.dao;

import org.torresgranadosamaury.pixup.model.Disquera;

import java.util.List;

public interface DisqueraDao
{
    List<Disquera> findAll( );
    boolean save( Disquera disquera );
    boolean update( Disquera disquera );
    boolean delete( Disquera disquera );
    Disquera findById( int id );
}
