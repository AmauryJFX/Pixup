package org.torresgranadosamaury.pixup.repository.jdbc;

import org.torresgranadosamaury.pixup.model.Colonia;

import java.util.List;

public interface ColoniaJdbc
{
    List<Colonia> findAll( );
}

