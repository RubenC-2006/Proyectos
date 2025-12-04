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
 * <h2>Clase Título</h2>
 * <p>Clase base que representa un título audiovisual.</p>
 * <p>Contiene información básica como el nombre.</p>
 */

public class Titulo {
    private String nombre;
    
    public Titulo(String nombre) {
        this.nombre = nombre;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
