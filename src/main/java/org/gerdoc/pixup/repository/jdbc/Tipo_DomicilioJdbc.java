package org.gerdoc.pixup.repository.jdbc;

import org.gerdoc.pixup.model.Colonia;
import org.gerdoc.pixup.model.Tipo_Domicilio;

import java.util.List;

public interface Tipo_DomicilioJdbc
{
    List<Tipo_Domicilio> findAll( );
}

