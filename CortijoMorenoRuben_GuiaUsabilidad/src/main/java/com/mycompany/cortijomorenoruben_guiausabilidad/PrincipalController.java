/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.cortijomorenoruben_guiausabilidad;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author ruben
 */

public class PrincipalController {

    @FXML
    private Label tituloRegla;
    @FXML
    private TextArea areaTexto;

    @FXML
    private void gestionarBoton(ActionEvent evento) {
        String textoBoton = ((Button) evento.getSource()).getText();
        tituloRegla.setText(textoBoton);

        switch (textoBoton) {
            case "Familiaridad":
                areaTexto.setText("El ordenador, la interfaz y el entorno de trabajo deben estar a disposición del usuario. El usuario tiene que tener el ambiente flexible para que pueda aprender de forma rapida a usar la aplicación.");
                break;
            case "Consistencia":
                areaTexto.setText("Esto indica que operaciones parecidas tendrán que activarse de la misma forma. Además, se debe tener en cuenta la comodidad mediante menús, barras de acciones e iconos de fácil acceso e identificación.");
                break;
            case "Legibilidad":
                areaTexto.setText("La información mostrada debe ser fácil de identificar y leer. Es importante tener una buena presentación, como la colocación de objetos, evitar la presentación de excesiva información, etc.");
                break;
            case "Mínima Sorpresa":
                areaTexto.setText("El comportamiento de la aplicación no debe provocar sorpresas imprevistas a los usuarios.");
                break;
            case "Recuperabilidad":
                areaTexto.setText("La interfaz debe incluir mecanismos que permitan a los usuarios recuperarse de los errores.");
                break;
        }
    }
}
