package org.torresgranadosamaury.pixup.repository.jdbc;

import org.torresgranadosamaury.pixup.model.Domicilio;

import java.util.List;

public interface DomicilioJdbc
{
    List<Domicilio> findAll( );
}

