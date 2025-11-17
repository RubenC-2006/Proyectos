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

public class DialogoPersonalizado extends JDialog {

    private Timer temporizadorCierre;

    public DialogoPersonalizado(JFrame ventana, String texto, boolean esModal) {
        super(ventana, esModal);
        setLayout(new BorderLayout());

        JLabel etiqueta = new JLabel(texto, SwingConstants.CENTER);
        add(etiqueta, BorderLayout.CENTER);

        JProgressBar barra = new JProgressBar(0,100);
        barra.setStringPainted(true);
        add(barra, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(ventana);

        temporizadorCierre = new Timer(40, e -> {
            barra.setValue(barra.getValue()+1);
            if (barra.getValue() >= 100) {
                temporizadorCierre.stop();
                dispose();
            }
        });
        temporizadorCierre.start();
    }
}