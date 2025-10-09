package com.fantasydc;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class VentanaCrearEquipo extends JFrame {

    private JComboBox<String> comboCategoria;
    private JComboBox<Personaje> comboPersonajes;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaEquipo;
    private Equipo equipo;
    private JLabel lblPresupuestoRestante;
    private ArrayList<Personaje> personajesDisponibles;

    public VentanaCrearEquipo(Equipo equipo) {
        super("Crear Equipo");
        this.equipo = equipo;

        setSize(500,400);
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        // Categorías
        comboCategoria = new JComboBox<>(new String[]{"Héroe","Villano","Antihéroe"});
        gbc.gridx=0; gbc.gridy=0; gbc.gridwidth=2; gbc.fill=GridBagConstraints.HORIZONTAL; gbc.insets = new Insets(5,5,5,5);
        add(comboCategoria, gbc);

        // Personajes
        personajesDisponibles = new ArrayList<>();
        agregarPersonajes();
        comboPersonajes = new JComboBox<>();
        actualizarComboPersonajes("Héroe");
        gbc.gridx=0; gbc.gridy=1; gbc.gridwidth=2;
        add(comboPersonajes, gbc);

        JButton btnAgregar = new JButton("Agregar al equipo");
        gbc.gridx=0; gbc.gridy=2; gbc.gridwidth=1;
        add(btnAgregar, gbc);

        JButton btnCerrar = new JButton("Cerrar");
        gbc.gridx=1; gbc.gridy=2;
        add(btnCerrar, gbc);

        lblPresupuestoRestante = new JLabel("Presupuesto restante: "+(equipo.getPresupuestoMaximo() - equipo.costoActual()));
        gbc.gridx=0; gbc.gridy=3; gbc.gridwidth=2;
        add(lblPresupuestoRestante, gbc);

        modeloLista = new DefaultListModel<>();
        listaEquipo = new JList<>(modeloLista);
        JScrollPane scroll = new JScrollPane(listaEquipo);
        gbc.gridx=0; gbc.gridy=4; gbc.gridwidth=2; gbc.weightx=1; gbc.weighty=1; gbc.fill=GridBagConstraints.BOTH;
        add(scroll, gbc);

        comboCategoria.addActionListener(e -> actualizarComboPersonajes((String)comboCategoria.getSelectedItem()));
        btnAgregar.addActionListener(e -> agregarSeleccionado());
        btnCerrar.addActionListener(e -> dispose());

        setVisible(true);
    }

    private void agregarPersonajes() {
        // Héroes
        personajesDisponibles.add(new Personaje("Superman","Héroe",25));
        personajesDisponibles.add(new Personaje("Batman","Héroe",20));
        personajesDisponibles.add(new Personaje("Wonder Woman","Héroe",22));
        personajesDisponibles.add(new Personaje("Flash","Héroe",18));
        personajesDisponibles.add(new Personaje("Green Lantern","Héroe",17));
        personajesDisponibles.add(new Personaje("Aquaman","Héroe",15));

        // Villanos
        personajesDisponibles.add(new Personaje("Joker","Villano",20));
        personajesDisponibles.add(new Personaje("Lex Luthor","Villano",18));
        personajesDisponibles.add(new Personaje("Darkseid","Villano",25));
        personajesDisponibles.add(new Personaje("Cheetah","Villano",16));
        personajesDisponibles.add(new Personaje("Sinestro","Villano",19));
        personajesDisponibles.add(new Personaje("Bane","Villano",17));

        // Antihéroes
        personajesDisponibles.add(new Personaje("Catwoman","Antihéroe",15));
        personajesDisponibles.add(new Personaje("Harley Quinn","Antihéroe",16));
        personajesDisponibles.add(new Personaje("Deathstroke","Antihéroe",20));
        personajesDisponibles.add(new Personaje("Red Hood","Antihéroe",18));
        personajesDisponibles.add(new Personaje("Rorschach","Antihéroe",19));
        personajesDisponibles.add(new Personaje("Spawn","Antihéroe",22));
    }

    private void actualizarComboPersonajes(String categoria){
        comboPersonajes.removeAllItems();
        for(Personaje p: personajesDisponibles){
            if(p.getCategoria().equals(categoria)){
                comboPersonajes.addItem(p);
            }
        }
    }

    private void agregarSeleccionado(){
        Personaje seleccionado = (Personaje) comboPersonajes.getSelectedItem();
        if(seleccionado!=null){
            boolean agregado = equipo.agregarPersonaje(seleccionado);
            if(agregado){
                modeloLista.addElement(seleccionado.toString());
                lblPresupuestoRestante.setText("Presupuesto restante: "+(equipo.getPresupuestoMaximo() - equipo.costoActual()));
            } else {
                JOptionPane.showMessageDialog(this,"No se puede agregar. Máximo 6 integrantes o presupuesto superado.");
            }
        }
    }
}
