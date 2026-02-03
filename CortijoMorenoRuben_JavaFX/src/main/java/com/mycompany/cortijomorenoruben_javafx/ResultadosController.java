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

public class ResultadosController {

    @FXML
    private Label tPuntuacion;
    @FXML
    private Label tRecord;
    @FXML
    private Button bReiniciar;
    @FXML
    private Button bSalir;

    public void initialize() {
        tPuntuacion.setText("Puntuación: " + (App.puntuacionActual - 1));
        tRecord.setText("Récord: " + (App.record - 1));
    }

    @FXML
    private void Reiniciar() throws IOException {
        App.puntuacionActual = 0;
        App.Raiz("Juego");
    }

    @FXML
    private void Salir() {
        Platform.exit();
    }
}