/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author ruben
 */
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;

public class LabelPersonalizado extends JLabel {

    private BufferedImage imagen;
    private double escala = 1.0;
    private boolean grande = false;
    private Timer movimiento;
    private Timer animacionEscala;
    private double escalaObjetivo = 1.0;
    private int dx = -4;
    private int dy = 2;

    public LabelPersonalizado(String ruta, boolean esAutomatico) {
        try { 
            imagen = ImageIO.read(getClass().getResource(ruta));
        }
        catch (Exception e) {
            imagen = null;
        }
        
        if (esAutomatico) {
            movimiento = new Timer(25, e -> {
                if (getParent() == null) return;
                Point p = getLocation();
                int nx = p.x + dx;
                int ny = p.y + dy;
                if (nx < 0 || nx + getWidth() > getParent().getWidth()) dx = -dx;
                if (ny < 0 || ny + getHeight() > getParent().getHeight()) dy = -dy;
                setLocation(p.x + dx, p.y + dy);
            });
        }
        
        if (imagen != null) {
            setSize(imagen.getWidth(), imagen.getHeight());
        } else {
            setSize(64,64);
        }
        setVisible(true);
    }

    private void animarEscala() {
        if (animacionEscala != null && animacionEscala.isRunning()) return;
        grande = !grande;
        escalaObjetivo = grande ? 1.6 : 1.0;
        animacionEscala = new Timer(20, e -> {
            escala += (escalaObjetivo - escala) * 0.2;
            if (Math.abs(escala - escalaObjetivo) < 0.01) { escala = escalaObjetivo; animacionEscala.stop(); }
            if (imagen != null) { setSize((int)(imagen.getWidth()*escala),(int)(imagen.getHeight()*escala)); }
            else { setSize((int)(64*escala),(int)(64*escala)); }
            repaint();
        });
        animacionEscala.start();
    }

    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (imagen != null) {
            int ancho = (int)(imagen.getWidth()*escala);
            int alto = (int)(imagen.getHeight()*escala);
            g.drawImage(imagen, 0, 0, ancho, alto, this);
        } else {
            Graphics2D g2 = (Graphics2D) g.create();
            g2.setColor(new Color(200, 60, 60));
            g2.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            g2.setColor(Color.WHITE);
            g2.setFont(g2.getFont().deriveFont(Font.BOLD, 12f));
            FontMetrics fm = g2.getFontMetrics();
            String s = "IMG";
            int tx = (getWidth() - fm.stringWidth(s)) / 2;
            int ty = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();
            g2.drawString(s, tx, ty);
            g2.dispose();
        }
    }

    public void iniciarMovimiento() { if (movimiento != null) movimiento.start(); }
    public void detenerMovimiento() { if (movimiento != null) movimiento.stop(); }
}