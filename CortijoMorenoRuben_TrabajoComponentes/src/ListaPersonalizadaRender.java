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

public class ListaPersonalizadaRender extends JLabel implements ListCellRenderer<String> {

    public ListaPersonalizadaRender() {
        setOpaque(true);
        setBorder(BorderFactory.createEmptyBorder(6,6,6,6));
    }

    public Component getListCellRendererComponent(JList<? extends String> lista, String valor, int indice,
                                                  boolean seleccionado, boolean foco) {
        setText(valor);
        setIcon(UIManager.getIcon("OptionPane.informationIcon"));
        setFont(new Font("SansSerif", Font.PLAIN, 13));

        if (seleccionado) {
            setBackground(new Color(60,179,113));
            setForeground(Color.WHITE);
        } else {
            setBackground(Color.WHITE);
            setForeground(Color.BLACK);
        }
        return this;
    }
}
