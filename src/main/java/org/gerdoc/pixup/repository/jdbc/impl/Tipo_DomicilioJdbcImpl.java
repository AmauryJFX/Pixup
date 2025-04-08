package org.gerdoc.pixup.repository.jdbc.impl;

import org.gerdoc.pixup.model.Tipo_Domicilio;
import org.gerdoc.pixup.repository.jdbc.Conexion;
import org.gerdoc.pixup.repository.jdbc.Tipo_DomicilioJdbc;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Tipo_DomicilioJdbcImpl extends Conexion<Tipo_Domicilio> implements Tipo_DomicilioJdbc {
    private static Tipo_DomicilioJdbc tipoDomicilioJdbc;

    public Tipo_DomicilioJdbcImpl() {
    }

    public static Tipo_DomicilioJdbc getInstance() {
        if (tipoDomicilioJdbc == null) {
            tipoDomicilioJdbc = new Tipo_DomicilioJdbcImpl();
        }
        return tipoDomicilioJdbc;
    }

    @Override
    public List<Tipo_Domicilio> findAll() {
        Statement statement = null;
        ResultSet resultSet = null;
        List<Tipo_Domicilio> list = new ArrayList<>();
        String sql = "SELECT ID, DESCRIPCION FROM TBL_TIPO_DOMICILIO";

        try {
            if (openConnection()) {
                System.out.println("Error en conexión");
                return null;
            }

            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

            while (resultSet.next()) {
                Tipo_Domicilio tipo_Domicilio = new Tipo_Domicilio();
                tipo_Domicilio.setId(resultSet.getInt("ID"));
                tipo_Domicilio.setDescripcion(resultSet.getString("DESCRIPCION"));
                list.add(tipo_Domicilio);
            }

            resultSet.close();
            closeConnection();
            return list;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
    public boolean create(Tipo_Domicilio tipoDomicilio) {
        String sql = "INSERT INTO TBL_TIPO_DOMICILIO (DESCRIPCION) VALUES (?)";
        try {
            if (!openConnection()) {
                System.out.println("Error en conexión");
                return false;
            }

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, tipoDomicilio.getDescripcion()); // Esto asume que "nombre" se refiere a "descripción"
            int rowsAffected = preparedStatement.executeUpdate();

            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } finally {
            closeConnection();
        }
    }

    public static void main(String[] args) {
        Tipo_DomicilioJdbcImpl.getInstance().findAll().forEach(System.out::println);
    }
}
