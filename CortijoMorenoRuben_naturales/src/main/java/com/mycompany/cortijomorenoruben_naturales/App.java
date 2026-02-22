/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cortijomorenoruben_naturales;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

/**
 *
 * @author ruben
 */

public class App extends Application {

    private static Scene escena;

    @Override
    public void start(Stage escenarioPrincipal) throws IOException {
        escena = new Scene(cargarFXML("principal"), 640, 480);
        escenarioPrincipal.setTitle("Naturales");
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    private static Parent cargarFXML(String fxml) throws IOException {
        FXMLLoader cargadorFXML = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return cargadorFXML.load();
    }

    public static void main(String[] args) {
        launch();
    }
}