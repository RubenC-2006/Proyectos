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
import java.awt.event.*;

public class BotonPersonalizado extends JButton {

    private Color colorNormal = new Color(52,152,219);
    private Color colorHover = new Color(41,128,185);
    private Color colorPresionado = new Color(31,97,141);

    public BotonPersonalizado(String texto) {
        super(texto);
        setBackground(colorNormal);
        setForeground(Color.WHITE);
        setFocusPainted(false);
        setBorderPainted(false);
        setOpaque(true);
        setCursor(new Cursor(Cursor.HAND_CURSOR));

        addMouseListener(new MouseAdapter() {
            public void mouseEntered(MouseEvent e) { setBackground(colorHover); }
            public void mouseExited(MouseEvent e) { setBackground(colorNormal); }
            public void mousePressed(MouseEvent e) { setBackground(colorPresionado); }
            public void mouseReleased(MouseEvent e) { setBackground(colorHover); }
        });
    }
}
