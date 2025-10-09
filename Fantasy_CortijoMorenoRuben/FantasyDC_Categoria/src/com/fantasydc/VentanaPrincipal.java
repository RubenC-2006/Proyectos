package com.fantasydc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class VentanaPrincipal extends JFrame {

    private Equipo equipo;

    public VentanaPrincipal() {
        super("Fantasy DC - Ventana Principal");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(600, 400);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        equipo = new Equipo(150);

        JMenuBar menuBar = new JMenuBar();
        JMenu menuArchivo = new JMenu("Archivo");
        JMenuItem salir = new JMenuItem("Salir");
        salir.addActionListener(e -> System.exit(0));
        menuArchivo.add(salir);

        JMenu menuOpciones = new JMenu("Opciones");
        JMenuItem crearEquipo = new JMenuItem("Crear equipo");
        JMenuItem verEquipo = new JMenuItem("Ver equipo");
        menuOpciones.add(crearEquipo);
        menuOpciones.add(verEquipo);

        menuBar.add(menuArchivo);
        menuBar.add(menuOpciones);
        setJMenuBar(menuBar);

        crearEquipo.addActionListener(e -> new VentanaCrearEquipo(equipo));
        verEquipo.addActionListener(e -> new VentanaResumen(equipo.getIntegrantes()));

        setVisible(true);
    }

    public static void main(String[] args) {
        new VentanaPrincipal();
    }
}
