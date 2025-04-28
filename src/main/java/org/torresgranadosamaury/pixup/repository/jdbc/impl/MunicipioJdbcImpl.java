package org.torresgranadosamaury.pixup.repository.jdbc.impl;

import org.torresgranadosamaury.pixup.model.Estado;
import org.torresgranadosamaury.pixup.model.Municipio;
import org.torresgranadosamaury.pixup.repository.jdbc.Conexion;
import org.torresgranadosamaury.pixup.repository.jdbc.MunicipioJdbc;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;


public class MunicipioJdbcImpl extends Conexion<Municipio> implements MunicipioJdbc
{
    private static  MunicipioJdbc municipioJdbc;

    public MunicipioJdbcImpl()
    {
    }

    public static MunicipioJdbc getInstance()
    {
        if( municipioJdbc == null )
        {
            municipioJdbc = new MunicipioJdbcImpl();
        }
        return municipioJdbc;
    }

    @Override
    public List<Municipio> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Municipio> list = null;
        Municipio municipio = null;
        String sql = "SELECT m.ID, m.MUNICIPIO, e.ID AS ESTADO_ID, e.ESTADO AS ESTADO_NOMBRE " +
                "FROM TBL_MUNICIPIO m " +
                "JOIN TBL_ESTADO e ON m.TBL_ESTADO_ID = e.ID";


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
            list =  new java.util.ArrayList<Municipio>( );
            while( resultSet.next( ) )
            {
                municipio = new Municipio();
                municipio.setId(resultSet.getInt("ID"));
                municipio.setNombre(resultSet.getString("MUNICIPIO"));

                Estado estado = new Estado();
                estado.setId(resultSet.getInt("ESTADO_ID"));
                estado.setNombre(resultSet.getString("ESTADO_NOMBRE"));

                municipio.setEstado(estado);
                list.add( municipio );
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

    public static void main(String[] a) {
        MunicipioJdbcImpl.getInstance().findAll().forEach(System.out::println);
    }

}
