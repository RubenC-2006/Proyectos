/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cortijomorenoruben_ficcion;

/**
 *
 * @author ruben
 */

/**
 * <h2>Interfaz Identificable</h2>
 * <p>Interfaz que permite a las clases mostrar su identificador.</p>
 * <p>Incluye un método default para mostrar el ID.</p>
 */

public interface Identificable {
    default void mostrarId() {
        System.out.println("ID: " + obtenerId());
    }
    
    int obtenerId();
}
