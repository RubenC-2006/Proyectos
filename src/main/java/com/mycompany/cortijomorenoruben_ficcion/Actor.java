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
 * <h2>Clase Actor</h2>
 * <p>Representa a un actor en el sistema.</p>
 * <p>Hereda de Persona e implementa Identificable.</p>
 */

public class Actor extends Persona implements Identificable {
    private int id;
    private static int contadorId = 1;
    private String rutaImagen;
    
    public Actor(String nombre, int edad) {
        super(nombre, edad);
        this.id = contadorId++;
        this.rutaImagen = rutaImagen;
    }
    
    public int getId() {
        return id;
    }
    
    public void mostrarAtributos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
    }
    
    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    @Override
    public int obtenerId() {
        return this.id;
    }
}
