package org.torresgranadosamaury.pixup.repository.jdbc;

import org.torresgranadosamaury.pixup.model.Estado;

import java.util.List;

public interface EstadoJdbc
{
        List<Estado> findAll( );
}

