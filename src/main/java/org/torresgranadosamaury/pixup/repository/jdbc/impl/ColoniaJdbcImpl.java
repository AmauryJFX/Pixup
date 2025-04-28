package org.torresgranadosamaury.pixup.repository.jdbc.impl;

import org.torresgranadosamaury.pixup.model.Colonia;
import org.torresgranadosamaury.pixup.model.Estado;
import org.torresgranadosamaury.pixup.model.Municipio;
import org.torresgranadosamaury.pixup.repository.jdbc.ColoniaJdbc;
import org.torresgranadosamaury.pixup.repository.jdbc.Conexion;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class ColoniaJdbcImpl extends Conexion<Colonia> implements ColoniaJdbc
{
    private static ColoniaJdbc coloniaJdbc;

    public ColoniaJdbcImpl()
    {
    }

    public static ColoniaJdbc getInstance()
    {
        if (coloniaJdbc == null)
        {
            coloniaJdbc = new ColoniaJdbcImpl();
        }
        return coloniaJdbc;
    }

    @Override
    public List<Colonia> findAll()
    {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Colonia> list = null;
        Colonia colonia = null;

        String sql = "SELECT c.ID, c.COLONIA AS COLONIA_NOMBRE, c.CP AS COLONIA_CP, " +
                "m.ID AS MUNICIPIO_ID, m.MUNICIPIO AS MUNICIPIO_NOMBRE, " +
                "e.ID AS ESTADO_ID, e.ESTADO AS ESTADO_NOMBRE " +
                "FROM TBL_COLONIA c " +
                "JOIN TBL_MUNICIPIO m ON c.TBL_MUNICIPIO_ID = m.ID " +
                "JOIN TBL_ESTADO e ON m.TBL_ESTADO_ID = e.ID";

        try
        {
            if (openConnection())
            {
                System.out.println("Error en conexion");
                return null;
            }
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet == null)
            {
                return null;
            }

            list = new java.util.ArrayList<>();

            while (resultSet.next())
            {
                colonia = new Colonia();
                colonia.setId(resultSet.getInt("ID"));
                colonia.setNombre(resultSet.getString("COLONIA_NOMBRE"));
                colonia.setCp(resultSet.getString("COLONIA_CP"));

                Municipio municipio = new Municipio();
                municipio.setId(resultSet.getInt("MUNICIPIO_ID"));
                municipio.setNombre(resultSet.getString("MUNICIPIO_NOMBRE"));

                Estado estado = new Estado();
                estado.setId(resultSet.getInt("ESTADO_ID"));
                estado.setNombre(resultSet.getString("ESTADO_NOMBRE"));

                municipio.setEstado(estado);
                colonia.setMunicipio(municipio);

                list.add(colonia);
            }

            resultSet.close();
            closeConnection();
            return list;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        ColoniaJdbcImpl.getInstance().findAll().forEach(System.out::println);
    }
}
