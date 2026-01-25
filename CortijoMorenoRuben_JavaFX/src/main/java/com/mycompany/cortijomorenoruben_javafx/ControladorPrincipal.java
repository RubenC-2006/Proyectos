/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.cortijomorenoruben_javafx;

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/**
 * FXML Controller class
 *
 * @author ruben
 */
public class ControladorPrincipal {

    @FXML
    private Label tTitulo;

    @FXML
    private Button bIniciar;
    
    @FXML
    private Button bSalir;

    @FXML
    private void Iniciar() throws IOException {
        App.Raiz("Juego");
    }  
    
    @FXML
    private void Salir() {
        Platform.exit();
    }
    
}
