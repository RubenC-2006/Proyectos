/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cortijomorenoruben_javafx;

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
    
    static Scene escena;

    static int puntuacionActual = 0;
    static int record = 0;
    
    @Override
    public void start(Stage escenario) throws Exception {
        escena = new Scene(cargarFXML("principal"), 640, 480);
        escenario.setTitle("Juego de memoria");
        escenario.setScene(escena);
        escenario.show();
    }
    
    public static void Raiz(String fxml) throws IOException {
        escena.setRoot(cargarFXML(fxml));
    }
    
    public static Parent cargarFXML (String fxml) throws IOException {
        FXMLLoader cargadorFxml = new FXMLLoader(App.class.getResource("/com/mycompany/cortijomorenoruben_javafx/" + fxml + ".fxml"));
        return cargadorFxml.load();
    }
    
    public static void main(String[] args) {
        launch(args);
    }
    
}
