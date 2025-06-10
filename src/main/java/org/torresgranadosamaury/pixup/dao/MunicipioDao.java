package org.torresgranadosamaury.pixup.dao;

import  org.torresgranadosamaury.pixup.model.Municipio;

import java.util.List;

public interface MunicipioDao
{
    List<Municipio> findAll( );
    boolean save( Municipio municipio );
    boolean update( Municipio municipio );
    boolean delete( Municipio municipio );
    Municipio findById( int id );
}
