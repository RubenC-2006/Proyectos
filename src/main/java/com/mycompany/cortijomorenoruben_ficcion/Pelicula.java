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
 * <h2>Clase Película</h2>
 * <p>Representa una película en el sistema.</p>
 * <p>Hereda de Título e implementa Identificable.</p>
 */
public class Pelicula extends Titulo implements Identificable{
    private int duracion;
    private int id;
    public static int contadorId = 1;
    private String rutaImagen;
    
    public Pelicula(String nombre, int duracion, String rutaImagen) {
        super(nombre);
        this.id = contadorId++;
        this.duracion = duracion;
        this.rutaImagen = rutaImagen;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
    public int getId() {
        return id;
    }
    
    public void mostrarAtributos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Duración: " + duracion + " minutos");
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
