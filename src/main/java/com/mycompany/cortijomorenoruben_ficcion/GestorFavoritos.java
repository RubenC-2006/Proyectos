/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cortijomorenoruben_ficcion;

import java.util.ArrayList;

/**
 *
 * @author ruben
 */

/**
 * Gestor de elementos favoritos
 * Permite agregar y mostrar elementos marcados como favoritos
 */
public class GestorFavoritos {
    private ArrayList<Object> favoritos;
    
    public GestorFavoritos() {
        favoritos = new ArrayList<>();
    }
    
    public void agregarFavorito(Object item) {
        if (!favoritos.contains(item)) {
            favoritos.add(item);
        }
    }

    public void mostrarFavoritos() {
        for (Object item : favoritos) {
            System.out.println(item.toString());
        }
    }

    public ArrayList<Object> getFavoritos() {
        return favoritos;
    }
}
