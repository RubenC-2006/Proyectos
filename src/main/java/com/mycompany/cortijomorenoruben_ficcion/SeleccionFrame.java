/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cortijomorenoruben_ficcion;

import javax.swing.*;

/**
 *
 * @author ruben
 */

/**
 * Ventana de selección de contenido
 * Permite elegir entre películas y series
 */

public class SeleccionFrame extends javax.swing.JFrame {
    private BotonPersonalizado botonPeliculas;
    private BotonPersonalizado botonSeries;
    private javax.swing.JLabel etiquetaTitulo;

    public SeleccionFrame() {
        initComponents();
    }

    private void initComponents() {
        etiquetaTitulo = new javax.swing.JLabel();
        botonPeliculas = new BotonPersonalizado("Películas");
        botonSeries = new BotonPersonalizado("Series");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Seleccionar Contenido");

        etiquetaTitulo.setFont(new java.awt.Font("Arial", 1, 18));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("¿Qué deseas ver?");

        botonPeliculas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonPeliculasActionPerformed(evt);
            }
        });

        botonSeries.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonSeriesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE)
                    .addComponent(botonPeliculas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(botonSeries, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addGap(30, 30, 30)
                .addComponent(botonPeliculas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(botonSeries, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void botonPeliculasActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new PeliculasFrame().setVisible(true);
    }

    private void botonSeriesActionPerformed(java.awt.event.ActionEvent evt) {
        this.dispose();
        new SeriesFrame().setVisible(true);
    }
}
