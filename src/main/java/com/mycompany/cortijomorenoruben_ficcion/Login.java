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
 * Ventana de inicio de sesión
 * Permite al usuario ingresar con usuario y contraseña
 */
public class Login extends javax.swing.JFrame {
    private javax.swing.JButton botonLogin;
    private javax.swing.JPasswordField campoContrasena;
    private javax.swing.JTextField campoUsuario;
    private javax.swing.JLabel etiquetaContrasena;
    private javax.swing.JLabel etiquetaTitulo;
    private javax.swing.JLabel etiquetaUsuario;

    public Login() {
        initComponents();
    }

    private void initComponents() {
        etiquetaTitulo = new javax.swing.JLabel();
        etiquetaUsuario = new javax.swing.JLabel();
        campoUsuario = new javax.swing.JTextField();
        etiquetaContrasena = new javax.swing.JLabel();
        campoContrasena = new javax.swing.JPasswordField();
        botonLogin = new BotonPersonalizado("Iniciar Sesión");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Inicio de Sesión");

        etiquetaTitulo.setFont(new java.awt.Font("Arial", 1, 18));
        etiquetaTitulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        etiquetaTitulo.setText("Pelis y series");

        etiquetaUsuario.setText("Usuario:");

        etiquetaContrasena.setText("Contraseña:");

        botonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botonLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(etiquetaTitulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(etiquetaUsuario)
                            .addComponent(etiquetaContrasena))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoUsuario)
                            .addComponent(campoContrasena)))
                    .addComponent(botonLogin, javax.swing.GroupLayout.DEFAULT_SIZE, 380, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(etiquetaTitulo)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaUsuario)
                    .addComponent(campoUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(etiquetaContrasena)
                    .addComponent(campoContrasena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addComponent(botonLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }

    private void botonLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String usuario = campoUsuario.getText();
        String contrasena = new String(campoContrasena.getPassword());
        
        if ("admin".equals(usuario) && "1234".equals(contrasena)) {
            this.setVisible(false);
            new SeleccionFrame().setVisible(true);
        } else {
            JOptionPane.showMessageDialog(this, "Credenciales incorrectas");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }
}
