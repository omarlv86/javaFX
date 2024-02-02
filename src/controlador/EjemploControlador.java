/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package controlador;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.Suma;

/**
 * FXML Controller class
 *
 * @author USER
 */
public class EjemploControlador implements Initializable {

    @FXML
    private Button btnSumar;
    @FXML
    private TextField txtValor1;
    @FXML
    private TextField txtValor2;
    @FXML
    private TextField txtResultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    private void click(ActionEvent event) {
        System.out.println("Hola mundo");
    }

    @FXML
    private void sumar(ActionEvent event) {
        try{
            int val1 = Integer.parseInt(this.txtValor1.getText());
            int val2 = Integer.parseInt(this.txtValor2.getText());
            
            Suma s = new Suma(val1, val2);
            int resultado = s.suma();
            
            this.txtResultado.setText(resultado+"");
            
        }catch(NumberFormatException e){
            System.out.println("Error: " + e);
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait(); 
        }  
    }
    
}
