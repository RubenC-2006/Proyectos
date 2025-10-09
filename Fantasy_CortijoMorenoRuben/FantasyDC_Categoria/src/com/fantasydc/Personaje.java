package com.fantasydc;

public class Personaje {
    private String nombre;
    private String categoria;
    private int costo;

    public Personaje(String nombre, String categoria, int costo) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.costo = costo;
    }

    public String getNombre() { return nombre; }
    public String getCategoria() { return categoria; }
    public int getCosto() { return costo; }

    @Override
    public String toString() {
        return nombre + " (" + categoria + ") - Costo: " + costo;
    }
}
