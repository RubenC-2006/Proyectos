/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.cortijomorenoruben_naturales;

import java.awt.BorderLayout;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import java.io.File;
import java.io.IOException;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartUtils;
import org.jfree.chart.JFreeChart;
import org.jfree.data.category.DefaultCategoryDataset;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javax.swing.JButton;

/**
 * FXML Controller class
 *
 * @author ruben
 */
public class PrincipalController implements Initializable {

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void abrirVentana() {
        JFrame ventanaControl = new JFrame("Restaurante");
        ventanaControl.setSize(300, 150);
        ventanaControl.setLocationRelativeTo(null);
        ventanaControl.setLayout(new BorderLayout());
        ventanaControl.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JButton botonAccion = new JButton("generar pdf y grafica");
        
        botonAccion.addActionListener(e -> {
            generarInformes();
            JOptionPane.showMessageDialog(null, "Pdf y grafica generados");
        });

        ventanaControl.add(botonAccion, BorderLayout.CENTER);
        ventanaControl.setVisible(true);
    }

    private void generarInformes() {
        String archivoImagen = "graficoInventario.jpg";
        String archivoPdf = "inventarioSemanal.pdf";

        DefaultCategoryDataset datosStock = new DefaultCategoryDataset();
        datosStock.addValue(120, "Kilos", "Patatas");
        datosStock.addValue(45, "Kilos", "Carne");
        datosStock.addValue(30, "Kilos", "Pescado");
        datosStock.addValue(15, "Kilos", "Verdura");

        JFreeChart graficoBarras = ChartFactory.createBarChart(
                "Stock disponible",
                "Ingrediente",
                "Cantidad (Kg)",
                datosStock
        );

        try {
            ChartUtils.saveChartAsJPEG(new File(archivoImagen), graficoBarras, 600, 400);

            PDDocument documento = new PDDocument();
            PDPage pagina = new PDPage();
            documento.addPage(pagina);

            PDImageXObject imagenGrafico = PDImageXObject.createFromFile(archivoImagen, documento);

            PDPageContentStream contenido = new PDPageContentStream(documento, pagina);
            
            contenido.beginText();
            contenido.setFont(PDType1Font.HELVETICA_BOLD, 14);
            contenido.newLineAtOffset(100, 750);
            contenido.showText("Informe de inventario");
            contenido.endText();

            contenido.drawImage(imagenGrafico, 100, 350, 400, 300);
            
            contenido.close();
            documento.save(archivoPdf);
            documento.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
