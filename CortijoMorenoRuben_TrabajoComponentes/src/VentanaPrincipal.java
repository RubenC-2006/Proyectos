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

public class VentanaPrincipal extends JFrame {

    private PanelMenu panelMenu;
    private PanelJuego panelJuego;

    public VentanaPrincipal() {
        setTitle("Juego");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        panelMenu = new PanelMenu(this);
        panelJuego = new PanelJuego(this);
        add(panelMenu, BorderLayout.CENTER);
    }

    public void cambiarAPanelMenu() {
        getContentPane().removeAll();
        add(panelMenu, BorderLayout.CENTER);
        revalidate();
        repaint();
    }

    public void cambiarAPanelJuego(String modo) {
        getContentPane().removeAll();
        add(panelJuego, BorderLayout.CENTER);
        revalidate();
        repaint();
        panelJuego.requestFocusInWindow();
        panelJuego.iniciarJuego(modo);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new VentanaPrincipal().setVisible(true);
        });
    }
}