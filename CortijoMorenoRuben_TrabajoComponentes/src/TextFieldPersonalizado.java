/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;

public class TextFieldPersonalizado extends JTextField {

    public TextFieldPersonalizado(int columnas) {
        super(columnas);
        setFont(new Font("SansSerif", Font.PLAIN, 13));
        getDocument().addDocumentListener(new DocumentListener() {
            public void insertUpdate(DocumentEvent e) { actualizarFondo(); }
            public void removeUpdate(DocumentEvent e) { actualizarFondo(); }
            public void changedUpdate(DocumentEvent e) { actualizarFondo(); }
            private void actualizarFondo() {
                int n = getText().length();
                if (n == 0) setBackground(Color.WHITE);
                else if (n < 6) setBackground(new Color(255,245,238));
                else setBackground(new Color(235,255,240));
            }
        });
    }
}
