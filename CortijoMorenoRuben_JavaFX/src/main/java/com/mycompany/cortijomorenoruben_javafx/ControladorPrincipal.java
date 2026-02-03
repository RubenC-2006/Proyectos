/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.cortijomorenoruben_javafx;

/**
 * FXML Controller class
 *
 * @author ruben
 */

import java.io.IOException;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.animation.*;
import javafx.util.Duration;

public class ControladorPrincipal {

    @FXML
    private Label tTitulo;
    @FXML
    private Button bIniciar;
    @FXML
    private Button bSalir;

    @FXML
    private void Iniciar() throws IOException {
        ScaleTransition animacion = new ScaleTransition(Duration.millis(150), bIniciar);
        animacion.setToX(0.9);
        animacion.setToY(0.9);
        animacion.setOnFinished(e -> {
            try {
                App.Raiz("Juego");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        });
        animacion.play();
    }

    @FXML
    private void Salir() {
        Platform.exit();
    }
}
