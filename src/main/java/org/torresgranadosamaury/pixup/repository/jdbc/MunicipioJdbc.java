package org.torresgranadosamaury.pixup.repository.jdbc;

import org.torresgranadosamaury.pixup.model.Municipio;

import java.util.List;

public interface MunicipioJdbc
{
    List<Municipio> findAll( );
}

