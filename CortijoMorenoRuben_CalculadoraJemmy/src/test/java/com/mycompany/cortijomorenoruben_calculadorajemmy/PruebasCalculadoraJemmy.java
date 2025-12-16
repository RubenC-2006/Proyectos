package com.mycompany.cortijomorenoruben_calculadorajemmy;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author ruben
 */

import com.mycompany.cortijomorenoruben_calculadorajemmy.CalculadoraJframe;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.netbeans.jemmy.operators.*;
import static org.junit.jupiter.api.Assertions.*;


public class PruebasCalculadoraJemmy {
    
    private JFrameOperator ventanaCalculadora;
    private JTextFieldOperator pantalla;
    
    @BeforeEach
    public void configurar() throws Exception {
        java.awt.EventQueue.invokeLater(() -> {
            new CalculadoraJframe().setVisible(true);
        });
        
        Thread.sleep(1000);
        ventanaCalculadora = new JFrameOperator("Calculadora");
        pantalla = new JTextFieldOperator(ventanaCalculadora);
    }
    
    @Test
    public void pruebaSumaBasica() throws Exception {
        new JButtonOperator(ventanaCalculadora, "7").push();
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "8").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("15.0", pantalla.getText());
    }
    
    @Test
    public void pruebaResta() throws Exception {
        new JButtonOperator(ventanaCalculadora, "9").push();
        new JButtonOperator(ventanaCalculadora, "-").push();
        new JButtonOperator(ventanaCalculadora, "4").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("5.0", pantalla.getText());
    }
    
    @Test
    public void pruebaMultiplicacion() throws Exception {
        new JButtonOperator(ventanaCalculadora, "6").push();
        new JButtonOperator(ventanaCalculadora, "*").push();
        new JButtonOperator(ventanaCalculadora, "7").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("42.0", pantalla.getText());
    }
    
    @Test
    public void pruebaDivision() throws Exception {
        new JButtonOperator(ventanaCalculadora, "8").push();
        new JButtonOperator(ventanaCalculadora, "/").push();
        new JButtonOperator(ventanaCalculadora, "2").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("4.0", pantalla.getText());
    }
    
    @Test
    public void pruebaDivisionPorCero() throws Exception {
        new JButtonOperator(ventanaCalculadora, "5").push();
        new JButtonOperator(ventanaCalculadora, "/").push();
        new JButtonOperator(ventanaCalculadora, "0").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("Error", pantalla.getText());
    }
    
    @Test
    public void pruebaLimpiarPantalla() throws Exception {
        new JButtonOperator(ventanaCalculadora, "1").push();
        new JButtonOperator(ventanaCalculadora, "2").push();
        new JButtonOperator(ventanaCalculadora, "3").push();
        new JButtonOperator(ventanaCalculadora, "C").push();
        
        Thread.sleep(500);
        assertEquals("0", pantalla.getText());
    }
    
    @Test
    public void pruebaExpresionCompletaVisible() throws Exception {
        new JButtonOperator(ventanaCalculadora, "2").push();
        assertEquals("2", pantalla.getText());
        
        new JButtonOperator(ventanaCalculadora, "+").push();
        assertEquals("2+", pantalla.getText());
        
        new JButtonOperator(ventanaCalculadora, "3").push();
        assertEquals("2+3", pantalla.getText());
        
        new JButtonOperator(ventanaCalculadora, "*").push();
        assertEquals("2+3*", pantalla.getText());
        
        new JButtonOperator(ventanaCalculadora, "4").push();
        assertEquals("2+3*4", pantalla.getText());
    }
    
    @Test
    public void pruebaPrecedenciaOperadores() throws Exception {
        new JButtonOperator(ventanaCalculadora, "2").push();
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "3").push();
        new JButtonOperator(ventanaCalculadora, "*").push();
        new JButtonOperator(ventanaCalculadora, "4").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("14.0", pantalla.getText());
    }
    
    @Test
    public void pruebaOperacionMultiple() throws Exception {
        new JButtonOperator(ventanaCalculadora, "1").push();
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "2").push();
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "3").push();
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "4").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("10.0", pantalla.getText());
    }
    
    @Test
    public void pruebaReemplazarOperador() throws Exception {
        new JButtonOperator(ventanaCalculadora, "5").push();
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "-").push();
        new JButtonOperator(ventanaCalculadora, "3").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("2.0", pantalla.getText());
    }
    
    @Test
    public void pruebaCeroInicial() throws Exception {
        new JButtonOperator(ventanaCalculadora, "+").push();
        new JButtonOperator(ventanaCalculadora, "5").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("5.0", pantalla.getText());
    }
    
    @Test
    public void pruebaNumeroGrande() throws Exception {
        new JButtonOperator(ventanaCalculadora, "9").push();
        new JButtonOperator(ventanaCalculadora, "9").push();
        new JButtonOperator(ventanaCalculadora, "9").push();
        new JButtonOperator(ventanaCalculadora, "*").push();
        new JButtonOperator(ventanaCalculadora, "2").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("1998.0", pantalla.getText());
    }
    
    @Test
    public void pruebaOperacionesConsecutivas() throws Exception {
        new JButtonOperator(ventanaCalculadora, "1").push();
        new JButtonOperator(ventanaCalculadora, "0").push();
        new JButtonOperator(ventanaCalculadora, "/").push();
        new JButtonOperator(ventanaCalculadora, "2").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(300);
        assertEquals("5.0", pantalla.getText());
        
        new JButtonOperator(ventanaCalculadora, "*").push();
        new JButtonOperator(ventanaCalculadora, "3").push();
        new JButtonOperator(ventanaCalculadora, "=").push();
        
        Thread.sleep(500);
        assertEquals("15.0", pantalla.getText());
    }
    
    @AfterEach
    public void limpiar() {
        if (ventanaCalculadora != null && ventanaCalculadora.isVisible()) {
            ventanaCalculadora.dispose();
        }
    }
    
    public static void main(String[] args) {
        try {
            PruebasCalculadoraJemmy tester = new PruebasCalculadoraJemmy();            
            
            tester.configurar();
            System.out.println("1. Probando suma básica...");
            tester.pruebaSumaBasica();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("2. Probando resta...");
            tester.pruebaResta();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("3. Probando multiplicación...");
            tester.pruebaMultiplicacion();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("4. Probando división...");
            tester.pruebaDivision();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("5. Probando división por cero...");
            tester.pruebaDivisionPorCero();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("6. Probando limpiar pantalla...");
            tester.pruebaLimpiarPantalla();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("7. Probando expresión completa visible...");
            tester.pruebaExpresionCompletaVisible();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("8. Probando precedencia de operadores...");
            tester.pruebaPrecedenciaOperadores();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("9. Probando operación múltiple...");
            tester.pruebaOperacionMultiple();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("10. Probando reemplazar operador...");
            tester.pruebaReemplazarOperador();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("11. Probando cero inicial...");
            tester.pruebaCeroInicial();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("12. Probando número grande...");
            tester.pruebaNumeroGrande();
            System.out.println("Pasó");
            tester.limpiar();
            
            tester.configurar();
            System.out.println("13. Probando operaciones consecutivas...");
            tester.pruebaOperacionesConsecutivas();
            System.out.println("Pasó");
            tester.limpiar();
            
            System.out.println("Pruebas pasadas");
            
        } catch (AssertionError e) {
            System.err.println("Error en la prueba: " + e.getMessage());
            e.printStackTrace();
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}