package org.gerdoc.pixup.repository.jdbc;

import org.gerdoc.pixup.model.Colonia;
import org.gerdoc.pixup.model.Domicilio;
import org.gerdoc.pixup.model.Municipio;

import java.util.List;

public interface DomicilioJdbc
{
    List<Domicilio> findAll( );
}

