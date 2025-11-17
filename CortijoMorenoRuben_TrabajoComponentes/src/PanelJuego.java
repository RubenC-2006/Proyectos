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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PanelJuego extends JPanel implements KeyListener {

    private VentanaPrincipal ventana;
    private LabelPersonalizado jugador;
    private List<LabelPersonalizado> enemigos = new ArrayList<>();
    private BotonPersonalizado botonVolver;
    private Timer temporizadorColision;
    private Timer temporizadorHUD;
    private boolean enJuego = false;
    private int puntos = 0;
    private final int paso = 8;
    private JLabel etiquetaTiempo;
    private Random aleatorio = new Random();

    public PanelJuego(VentanaPrincipal ventana) {
        this.ventana = ventana;
        setLayout(null);
        setBackground(new Color(28, 40, 52));
        
        jugador = new LabelPersonalizado("/recursos/jugador.png", false);
        jugador.setSize(64, 64);
        jugador.setLocation(80, 260);
        jugador.setVisible(true);
        add(jugador);
        
        botonVolver = new BotonPersonalizado("Volver");
        botonVolver.setSize(140, 40);
        botonVolver.setLocation(10, 10);
        botonVolver.addActionListener(e -> {
            detenerJuego();
            limpiarEnemigosDelPanel();
            ventana.cambiarAPanelMenu();
        });
        add(botonVolver);
        
        etiquetaTiempo = new JLabel("Puntos conseguidos: 0");
        etiquetaTiempo.setForeground(Color.WHITE);
        etiquetaTiempo.setFont(new Font("SansSerif", Font.BOLD, 18));
        etiquetaTiempo.setBounds(350, 10, 300, 30);
        add(etiquetaTiempo);
        
        temporizadorColision = new Timer(30, e -> {
            if (!enJuego) return;
            for (LabelPersonalizado enemigo : enemigos) {
                if (jugador.getBounds().intersects(enemigo.getBounds())) {
                    detenerJuego();
                    
                    DialogoPersonalizado dialogo = new DialogoPersonalizado(
                            (JFrame) SwingUtilities.getWindowAncestor(this),
                            "Colisión. Puntos: " + puntos,
                            true
                    );
                    dialogo.setVisible(true);
                    
                    limpiarEnemigosDelPanel(); 
                    break;
                }
            }
        });
        
        temporizadorHUD = new Timer(500, e -> {
            if (!enJuego) return;
            puntos++;
            etiquetaTiempo.setText("Puntos conseguidos: " + puntos);
        });
        
        setFocusable(true);
        addKeyListener(this);
        addHierarchyListener(e -> {
            if ((e.getChangeFlags() & HierarchyEvent.SHOWING_CHANGED) != 0 && isShowing()) {
                requestFocusInWindow();
            }
        });
    }

    public void iniciarJuego(String modo) {
        enJuego = true;
        puntos = 0;
        botonVolver.setText("Volver");
        etiquetaTiempo.setText("Puntos conseguidos: 0");
        
        enemigos.clear();
        removerEnemigosGraficos(); 

        int cantidadEnemigos = 1;
        if (modo.equals("Normal")) cantidadEnemigos = 2;
        if (modo.equals("Difícil")) cantidadEnemigos = 3;

        int anchoPanel = getWidth();
        int altoPanel = getHeight();
        int anchoEntidad = 64;
        int altoEntidad = 64;
        int margenSuperior = 60; 
        
        if (anchoPanel == 0 || altoPanel == 0) {
            anchoPanel = 900;
            altoPanel = 600;
        }

        for (int i = 0; i < cantidadEnemigos; i++) {
            LabelPersonalizado enemigo = new LabelPersonalizado("/recursos/enemigo.png", true);
            enemigo.setSize(anchoEntidad, altoEntidad);
            
            int xAleatorio = aleatorio.nextInt(anchoPanel - anchoEntidad);
            int yLimiteInferior = altoPanel - altoEntidad;
            int yAleatorio = margenSuperior + aleatorio.nextInt(yLimiteInferior - margenSuperior);
            
            enemigo.setLocation(xAleatorio, yAleatorio);
            
            add(enemigo);
            enemigos.add(enemigo);
            enemigo.iniciarMovimiento();
        }

        temporizadorColision.start();
        temporizadorHUD.start();
        
        repaint();
    }

    public void detenerJuego() {
        enJuego = false;
        temporizadorColision.stop();
        temporizadorHUD.stop();
        for (LabelPersonalizado enemigo : enemigos) {
            enemigo.detenerMovimiento();
        }
    }
    
    private void limpiarEnemigosDelPanel() {
        removerEnemigosGraficos();
        enemigos.clear(); 
    }
    
    private void removerEnemigosGraficos() {
        for (LabelPersonalizado enemigo : enemigos) {
            remove(enemigo);
        }
        revalidate();
        repaint();
    }

    public void keyPressed(KeyEvent e) {
        if (!enJuego) return;
        Point p = jugador.getLocation();
        int k = e.getKeyCode();
        if (k == KeyEvent.VK_LEFT) p.x = Math.max(0, p.x - paso);
        if (k == KeyEvent.VK_RIGHT) p.x = Math.min(getWidth() - jugador.getWidth(), p.x + paso);
        if (k == KeyEvent.VK_UP) p.y = Math.max(0, p.y - paso);
        if (k == KeyEvent.VK_DOWN) p.y = Math.min(getHeight() - jugador.getHeight(), p.y + paso);
        jugador.setLocation(p);
    }

    public void keyReleased(KeyEvent e) {}
    public void keyTyped(KeyEvent e) {}
}