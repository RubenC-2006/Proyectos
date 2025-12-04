/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cortijomorenoruben_ficcion;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

/**
 *
 * @author ruben
 */

/**
 * Componente que hereda de JButton
 * Tiene colores de fondo y letra modificados por defecto
 */
public class BotonPersonalizado extends JButton {
    public BotonPersonalizado(String texto) {
        super(texto);
        configurarApariencia();
    }
    
    private void configurarApariencia() {
        setBackground(new Color(70, 130, 180));
        setForeground(Color.WHITE);
        setFont(new Font("Arial", Font.BOLD, 14));
        setFocusPainted(false);
    }
}
