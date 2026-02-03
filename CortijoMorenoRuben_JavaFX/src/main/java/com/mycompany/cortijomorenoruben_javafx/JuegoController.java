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
import javafx.animation.*;
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
        SequentialTransition secuenciaTotal = new SequentialTransition();
        secuenciaTotal.getChildren().add(new PauseTransition(Duration.seconds(0.5)));

        for (int color : secuencia) {
            secuenciaTotal.getChildren().add(crearAnimacionBoton(obtenerBoton(color)));
            secuenciaTotal.getChildren().add(new PauseTransition(Duration.seconds(0.2)));
        }

        secuenciaTotal.setOnFinished(e -> bloquearBotones(false));
        secuenciaTotal.play();
    }

    private ParallelTransition crearAnimacionBoton(Button boton) {
        ScaleTransition escala = new ScaleTransition(Duration.millis(200), boton);
        escala.setFromX(1.0);
        escala.setFromY(1.0);
        escala.setToX(1.15);
        escala.setToY(1.15);
        escala.setAutoReverse(true);
        escala.setCycleCount(2);

        FadeTransition desvanecimiento = new FadeTransition(Duration.millis(200), boton);
        desvanecimiento.setFromValue(0.6);
        desvanecimiento.setToValue(1.0);
        desvanecimiento.setAutoReverse(true);
        desvanecimiento.setCycleCount(2);

        return new ParallelTransition(escala, desvanecimiento);
    }

    @FXML
    private void pulsar(ActionEvent evento) throws IOException {
        Button botonPulsado = (Button) evento.getSource();
        crearAnimacionBoton(botonPulsado).play();
        
        int colorPulsado = obtenerIdBoton(botonPulsado);

        if (colorPulsado == secuencia.get(indiceUsuario)) {
            indiceUsuario++;
            if (indiceUsuario == secuencia.size()) {
                PauseTransition pausa = new PauseTransition(Duration.seconds(0.5));
                pausa.setOnFinished(e -> nuevaRonda());
                pausa.play();
            }
        } else {
            terminar();
        }
    }

    private int obtenerIdBoton(Button boton) {
        if (boton == bRojo) return 0;
        if (boton == bVerde) return 1;
        if (boton == bAzul) return 2;
        return 3;
    }

    private Button obtenerBoton(int id) {
        switch (id) {
            case 1: return bVerde;
            case 2: return bAzul;
            case 3: return bAmarillo;
            default: return bRojo;
        }
    }

    private void bloquearBotones(boolean estado) {
        bRojo.setMouseTransparent(estado);
        bVerde.setMouseTransparent(estado);
        bAzul.setMouseTransparent(estado);
        bAmarillo.setMouseTransparent(estado);
    }

    private void terminar() throws IOException {
        if (App.puntuacionActual > App.record) {
            App.record = App.puntuacionActual;
        }
        App.Raiz("Resultados");
    }
}