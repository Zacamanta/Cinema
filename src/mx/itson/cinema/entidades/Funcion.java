/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinema.entidades;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import mx.itson.cinema.persistence.MySQLConnection;

/**
 *
 * @author omar_
 */
public class Funcion {

    private int idFuncion;
    private String fecha;
    private int sala;

      public static List<Funcion> getAll(String filtro) {
        List<Funcion> Funcion = new ArrayList<>();

        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Funcion Where fecha LIKE ?");

            statement.setString(1, "?" + filtro + "?");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Funcion o = new Funcion();
                o.setIdFuncion(resultSet.getInt(1));
                o.setSala(resultSet.getInt(2));
                o.setFecha(resultSet.getString(3));
                Funcion.add(o);
            }
        } catch (SQLException ex) {

        }
        return Funcion;
    }
      
        public boolean save(String fecha, int sala) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO funcion (fecha, sala) VALUES (?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, fecha);
            statement.setInt(2, sala);
            statement.execute();
            
            result = statement.getUpdateCount() == 1;
            
            conexion.close();
            
        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());

        }
        return result;
    }
    
    public boolean update (int id, String fecha, int sala) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE alumno SET fecha = ? , sala = ? WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, fecha);
            statement.setInt(2, sala);
            statement.setInt(3, id);
            statement.execute();
            
            result = statement.getUpdateCount() == 1;
            
            conexion.close();
            
        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());

        }
        return result;
    }
    
    public boolean delete(int id) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "DELETE FROM funcion WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);

            statement.setInt(1, id);
            int rowsAffected = statement.executeUpdate(); // Ejecutar la consulta y obtener filas afectadas

            if (rowsAffected > 0) {
                result = true; // Si se elimina al menos una fila, se considera exitoso
            }

            conexion.close();
        } catch (Exception ex) {
            // Manejar errores de conexión o SQL
            System.err.println("Error: " + ex.getMessage());
        }
        return result;
    }


    public int getIdFuncion() {
        return idFuncion;
    }

    public void setIdFuncion(int idFuncion) {
        this.idFuncion = idFuncion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public int getSala() {
        return sala;
    }

    public void setSala(int sala) {
        this.sala = sala;
    }

}