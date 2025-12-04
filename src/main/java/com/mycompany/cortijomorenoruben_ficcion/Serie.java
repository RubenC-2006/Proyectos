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
 * <h2>Clase Serie</h2>
 * <p>Representa una serie de televisión.</p>
 * <p>Hereda de Título e implementa Identificable.</p>
 */

public class Serie extends Titulo implements Identificable{
    public int numeroTemporadas;
    public int[] capitulosPorTemporada;
    public int[] duracionEpisodios;
    public int id;
    public static int contadorId = 1;
    public String rutaImagen;
    
    public Serie(String nombre, int numeroTemporadas, int[] capitulosPorTemporada, int[] duracionEpisodios, String rutaImagen) {
        super(nombre);
        this.id = contadorId++;
        this.numeroTemporadas = numeroTemporadas;
        this.capitulosPorTemporada = capitulosPorTemporada;
        this.duracionEpisodios = duracionEpisodios;
        this.rutaImagen = rutaImagen;
    }
    
    public int calcularDuracionTotal() {
        int duracionTotal = 0;
        for (int i = 0; i < numeroTemporadas; i++) {
            duracionTotal += capitulosPorTemporada[i] * duracionEpisodios[i];
        }
        return duracionTotal;
    }
    
    public int getId() {
        return id;
    }
    
    public void mostrarAtributos() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Número de temporadas: " + numeroTemporadas);
        System.out.println("Capítulos por temporada: ");
        for (int i = 0; i < numeroTemporadas; i++) {
            System.out.println("  Temporada " + (i+1) + ": " + capitulosPorTemporada[i] + " capítulos");
        }
        System.out.println("Duración total: " + calcularDuracionTotal() + " minutos");
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