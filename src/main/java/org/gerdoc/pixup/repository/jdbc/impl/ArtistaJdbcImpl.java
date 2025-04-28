package org.gerdoc.pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Artista;
import org.gerdoc.pixup.repository.jdbc.ArtistaJdbc;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.EstadoJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ArtistaJdbcImpl extends Conexion<Artista> implements ArtistaJdbc
{
private static  ArtistaJdbc artistaJdbc;

    public ArtistaJdbcImpl()
    {
    }

    public static ArtistaJdbc getInstance()
    {
        if( artistaJdbc == null )
        {
            artistaJdbc = new ArtistaJdbcImpl();
        }
        return artistaJdbc;
    }

    @Override
    public List<Artista> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Artista> list = null;
        Artista Artista = null;
        String sql ="Select * from TBL_ARTISTA";

        try
        {
            if( openConnection() )
            {
                System.out.println("Error en conexion");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery( sql );
            if( resultSet == null )
            {
                return null;
            }
            list =  new java.util.ArrayList<Artista>( );
            while( resultSet.next( ) )
            {
                Artista = new Artista();
                Artista.setId( resultSet.getInt( "ID" ) );
                Artista.setArtista( resultSet.getString( "Artista" ) );
                list.add( Artista );
            }
            resultSet.close( );
            closeConnection( );
            return list;
        }
        catch (SQLException e)
        {
            return null;
        }
    }

   // public static void main(String[] a) {
       // artistaJdbcImpl.getInstance().findAll().forEach(System.out::println);
   // }

}