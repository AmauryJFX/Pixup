package org.gerdoc.pixup.repository.jdbc;

import org.gerdoc.pixup.model.Estado;

import java.util.List;

public interface EstadoJdbc
{
        List<Estado> findAll( );

        boolean save(Estado estado);
        boolean update(Estado estado);
        boolean delete(Estado estado);
}

