package org.torresgranadosamaury.pixup.repository.jdbc;

import org.torresgranadosamaury.pixup.model.Tipo_Domicilio;

import java.util.List;

public interface Tipo_DomicilioJdbc
{
    List<Tipo_Domicilio> findAll( );
}

