/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mx.itson.cinema.persistence;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author omar_
 */
public class MySQLConnection {
       
    public static Connection get() {
        Connection connection = null;
        try {

           connection = DriverManager.getConnection("jdbc:mysql://localhost/prueba","root","123456");
           
        } catch (Exception ex) {

            System.err.print("ERROR" + ex.getMessage());
        }
        return connection;
    }
}
