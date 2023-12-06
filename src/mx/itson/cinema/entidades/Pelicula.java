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
public class Pelicula {

    private int idPelicula;
    private String Nombre;
    private String Descripcion;
    private String Categoria;

    public static List<Pelicula> getAll(String filtro) {
        List<Pelicula> Pelicula = new ArrayList<>();

        try {
            Connection conexion = MySQLConnection.get();
            PreparedStatement statement = conexion.prepareStatement("SELECT * FROM Pelicula Where nombre LIKE ?");

            statement.setString(1, "?" + filtro + "?");

            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()) {
                Pelicula o = new Pelicula();
                o.setIdPelicula(resultSet.getInt(1));
                o.setNombre(resultSet.getString(2));
                o.setDescripcion(resultSet.getString(3));
                o.setCategoria(resultSet.getString(4));
                Pelicula.add(o);
            }
        } catch (SQLException ex) {

        }
        return Pelicula;
    }

    public boolean save(String Nombre, String Descripcion, String Categoria) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "INSERT INTO pelicula (Nombre, Descripcion, Categoria) VALUES (?,?,?)";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, Nombre);
            statement.setString(2, Descripcion);
            statement.setString(3, Categoria);

            statement.execute();

            result = statement.getUpdateCount() == 1;

            conexion.close();

        } catch (Exception ex) {
            System.err.println("Error:" + ex.getMessage());

        }
        return result;
    }

    public boolean update(int id, String Nombre, String Descripcion, String Categoria) {
        boolean result = false;
        try {
            Connection conexion = MySQLConnection.get();
            String query = "UPDATE pelicula SET nombre = ? , descripcion = ?, Categoria = ?  WHERE id = ?";
            PreparedStatement statement = conexion.prepareStatement(query);
            statement.setString(1, Nombre);
            statement.setString(2, Descripcion);
            statement.setInt(3, id);
            statement.setString(4, Categoria);
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
            String query = "DELETE FROM pelicula WHERE id = ?";
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

    public int getIdPelicula() {
        return idPelicula;
    }

    public void setIdPelicula(int idPelicula) {
        this.idPelicula = idPelicula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    public String getCategoria() {
        return Categoria;
    }

    public void setCategoria(String Categoria) {
        this.Categoria = Categoria;
    }

}
