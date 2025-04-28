package org.torresgranadosamaury.pixup.dao;

import org.torresgranadosamaury.pixup.model.Estado;

import java.util.List;

public interface EstadoDao
{
    List<Estado> findAll( );
    boolean save( Estado estado );
    boolean update( Estado estado );
    boolean delete( Estado estado );
    Estado findById( int id );
}