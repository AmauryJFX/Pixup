package org.gerdoc.pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Colonia;
import org.gerdoc.pixup.model.Domicilio;
import org.gerdoc.pixup.model.Municipio;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.DomicilioJdbc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

public class DomicilioJdbcImpl extends Conexion<Domicilio> implements DomicilioJdbc {
    private static DomicilioJdbc domicilioJdbc;

    public DomicilioJdbcImpl() {
    }

    public static DomicilioJdbc getInstance() {
        if(domicilioJdbc == null) {
            domicilioJdbc = new DomicilioJdbcImpl();
        }
        return domicilioJdbc;
    }

    @Override
    public List<Domicilio> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Domicilio> list = null;
        Domicilio domicilio = null;

        String sql = "SELECT d.ID, d.DOMICILIO, d.NUM_EXTERIOR, d.NUM_INTERIOR, " +
                "c.ID AS COLONIA_ID, c.COLONIA AS COLONIA_NOMBRE, c.CP AS COLONIA_CP, " +
                "m.ID AS MUNICIPIO_ID, m.MUNICIPIO AS MUNICIPIO_NOMBRE " +
                "FROM TBL_DOMICILIO d " +
                "JOIN TBL_COLONIA c ON d.TBL_COLONIA_ID = c.ID " +
                "JOIN TBL_MUNICIPIO m ON c.TBL_MUNICIPIO_ID = m.ID";

        try {
            if(openConnection()) {
                System.out.println("Error en conexion");
                return null;
            }

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            if(resultSet == null) {
                return null;
            }

            list = new java.util.ArrayList<>();

            while(resultSet.next()) {
                domicilio = new Domicilio();
                domicilio.setId(resultSet.getInt("ID"));
                domicilio.setDomicilio(resultSet.getString("DOMICILIO"));
                domicilio.setNumExterior(resultSet.getString("NUM_EXTERIOR"));
                domicilio.setNumInterior(resultSet.getString("NUM_INTERIOR"));

                Municipio municipio = new Municipio();
                municipio.setId(resultSet.getInt("MUNICIPIO_ID"));
                municipio.setNombre(resultSet.getString("MUNICIPIO_NOMBRE"));

                Colonia colonia = new Colonia();
                colonia.setId(resultSet.getInt("COLONIA_ID"));
                colonia.setNombre(resultSet.getString("COLONIA_NOMBRE"));
                colonia.setCp(resultSet.getString("COLONIA_CP"));
                colonia.setMunicipio(municipio);

                domicilio.setColonia(colonia);

                list.add(domicilio);
            }

            resultSet.close();
            closeConnection();
            return list;
        } catch(SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        DomicilioJdbcImpl.getInstance().findAll().forEach(System.out::println);
    }
}