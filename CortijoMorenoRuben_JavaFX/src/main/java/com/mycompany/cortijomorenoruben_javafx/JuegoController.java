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
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.util.Duration;

public class JuegoController {

    @FXML
    private Label tRonda;
    @FXML
    private Button bRojo;
    @FXML
    private Button bVerde;
    @FXML
    private Button bAzul;
    @FXML
    private Button bAmarillo;

    private List<Integer> secuencia = new ArrayList<>();
    private int indiceUsuario = 0;
    private Random aleatorio = new Random();

    public void initialize() {
        App.puntuacionActual = 0;
        nuevaRonda();
    }

    private void nuevaRonda() {
        indiceUsuario = 0;
        App.puntuacionActual++;
        tRonda.setText("Ronda: " + App.puntuacionActual);
        secuencia.add(aleatorio.nextInt(4));
        reproducirSecuencia();
    }

    private void reproducirSecuencia() {
        bloquearBotones(true);
        Timeline lineaTiempo = new Timeline();

        for (int i = 0; i < secuencia.size(); i++) {
            final int posicion = i;
            KeyFrame frameEnciende = new KeyFrame(Duration.seconds(i + 0.5), e -> iluminar(secuencia.get(posicion)));
            lineaTiempo.getKeyFrames().add(frameEnciende);
        }

        lineaTiempo.setOnFinished(e -> bloquearBotones(false));
        lineaTiempo.play();
    }

    private void iluminar(int color) {
        Button boton = obtenerBoton(color);
        String estiloOriginal = boton.getStyle();
        
        boton.setStyle("-fx-background-color: white; -fx-opacity: 1.0; -fx-background-radius: 20;");
        
        Timeline pausa = new Timeline(new KeyFrame(Duration.seconds(0.4), e -> boton.setStyle(estiloOriginal)));
        pausa.play();
    }

    @FXML
    private void pulsar(ActionEvent evento) throws IOException {
        Button botonPulsado = (Button) evento.getSource();
        int colorPulsado;

        if (botonPulsado == bRojo) {
            colorPulsado = 0;
        } else if (botonPulsado == bVerde) {
            colorPulsado = 1;
        } else if (botonPulsado == bAzul) {
            colorPulsado = 2;
        } else {
            colorPulsado = 3;
        }

        if (colorPulsado == secuencia.get(indiceUsuario)) {
            indiceUsuario++;
            if (indiceUsuario == secuencia.size()) {
                nuevaRonda();
            }
        } else {
            terminar();
        }
    }

    @FXML
    private void terminar() throws IOException {
        if (App.puntuacionActual > App.record) {
            App.record = App.puntuacionActual;
        }
        App.Raiz("Resultados");
    }

    private void bloquearBotones(boolean estado) {
        bRojo.setDisable(estado);
        bVerde.setDisable(estado);
        bAzul.setDisable(estado);
        bAmarillo.setDisable(estado);
    }

    private Button obtenerBoton(int id) {
        switch (id) {
            case 1: return bVerde;
            case 2: return bAzul;
            case 3: return bAmarillo;
            default: return bRojo;
        }
    }
}