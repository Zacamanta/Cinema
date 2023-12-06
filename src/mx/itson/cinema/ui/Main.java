/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package mx.itson.cinema.ui;

import mx.itson.cinema.entidades.Funcion;
import mx.itson.cinema.entidades.Pelicula;

/**
 *
 * @author omar_
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Pelicula.getAll("o");
        Funcion.getAll("i");
    }
    
}
