/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */
import javax.swing.*;
import java.awt.*;

public class PanelMenu extends JPanel {

    private VentanaPrincipal ventana;
    private TextFieldPersonalizado campoNombre;
    private JList<String> listaOpciones;

    public PanelMenu(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setLayout(new GridBagLayout());
        GridBagConstraints g = new GridBagConstraints();
        LabelPersonalizado logo = new LabelPersonalizado("/recursos/logo.png", false);
        logo.setPreferredSize(new Dimension(350, 220));
        g.gridx = 0;
        g.gridy = 0;
        g.insets = new Insets(10, 10, 10, 10);
        add(logo, g);
        JPanel panelControles = new JPanel(new GridBagLayout());
        panelControles.setOpaque(false);
        GridBagConstraints c = new GridBagConstraints();
        JLabel titulo = new JLabel("Bienvenido");
        titulo.setFont(new Font("SansSerif", Font.BOLD, 22));
        c.gridy = 0;
        c.insets = new Insets(5, 5, 5, 5);
        panelControles.add(titulo, c);
        campoNombre = new TextFieldPersonalizado(20);
        c.gridy = 1;
        panelControles.add(campoNombre, c);
        listaOpciones = new JList<>(new String[]{"Fácil", "Normal", "Difícil"});
        listaOpciones.setCellRenderer(new ListaPersonalizadaRender());
        c.gridy = 2;
        panelControles.add(new JScrollPane(listaOpciones), c);
        BotonPersonalizado botonJugar = new BotonPersonalizado("Jugar");
        botonJugar.addActionListener(e -> {
            String modo = listaOpciones.getSelectedValue();
            if (modo == null) {
                modo = "Fácil";
            }
            ventana.cambiarAPanelJuego(modo);
        });
        c.gridy = 3;
        panelControles.add(botonJugar, c);
        BotonPersonalizado botonSalir = new BotonPersonalizado("Salir");
        botonSalir.addActionListener(e -> System.exit(0));
        c.gridy = 4;
        panelControles.add(botonSalir, c);
        g.gridx = 1;
        g.gridy = 0;
        add(panelControles, g);
    }
}