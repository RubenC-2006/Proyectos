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
 * <h2>Clase Cliente</h2>
 * <p>Representa a un cliente del sistema.</p>
 * <p>Hereda de Persona e implementa Identificable.</p>
 */

public class Cliente extends Persona implements Identificable{
    private TipoCliente tipoCliente;
    private int id;
    private static int contadorId = 1;
    private String rutaImagen;
    
    public Cliente(String nombre, int edad, TipoCliente tipoCliente) {
        super(nombre, edad);
        this.id = contadorId++;
        this.tipoCliente = tipoCliente;
        this.rutaImagen = rutaImagen;
    }
    
    public TipoCliente getTipoCliente() {
        return tipoCliente;
    }
    
    public void setTipoCliente(TipoCliente tipoCliente) {
        this.tipoCliente = tipoCliente;
    }
    
    public int getId() {
        return id;
    }
    
    public void mostrarAtributos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Edad: " + getEdad());
        System.out.println("Tipo de cliente: " + tipoCliente);
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
