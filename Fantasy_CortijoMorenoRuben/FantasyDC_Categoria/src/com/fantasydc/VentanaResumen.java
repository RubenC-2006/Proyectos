package com.fantasydc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaResumen extends JFrame {

    public VentanaResumen(ArrayList<Personaje> equipo) {
        super("Resumen del Equipo");
        setSize(400,300);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        DefaultListModel<String> modelo = new DefaultListModel<>();
        int total = 0;
        for(Personaje p: equipo){
            modelo.addElement(p.toString());
            total += p.getCosto();
        }

        JList<String> lista = new JList<>(modelo);
        JScrollPane scroll = new JScrollPane(lista);
        gbc.gridx=0; gbc.gridy=0; gbc.weightx=1; gbc.weighty=1; gbc.fill=GridBagConstraints.BOTH;
        add(scroll, gbc);

        JLabel lblTotal = new JLabel("Costo total del equipo: "+total);
        gbc.gridx=0; gbc.gridy=1; gbc.weighty=0; gbc.fill=GridBagConstraints.HORIZONTAL;
        add(lblTotal, gbc);

        setVisible(true);
    }
}
