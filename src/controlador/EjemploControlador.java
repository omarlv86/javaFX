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
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Operaciones;
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
    @FXML
    private RadioButton rbSuma;
    @FXML
    private RadioButton rbResta;
    @FXML
    private RadioButton rbMulti;
    @FXML
    private RadioButton rbDivision;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ToggleGroup tg = new ToggleGroup();
        this.rbSuma.setToggleGroup(tg);
        this.rbResta.setToggleGroup(tg);
        this.rbMulti.setToggleGroup(tg);
        this.rbDivision.setToggleGroup(tg);
        this.rbSuma.setSelected(true);
    }    

    private void click(ActionEvent event) {
        System.out.println("Hola mundo");
    }

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

    @FXML
    private void operacion(ActionEvent event) {
        try{
            int val1 = Integer.parseInt(this.txtValor1.getText());
            int val2 = Integer.parseInt(this.txtValor2.getText());

            Operaciones op = new Operaciones(val1, val2);

            if(this.rbSuma.isSelected()){
                this.txtResultado.setText(op.suma()+"");
            }else if(this.rbResta.isSelected()){
                this.txtResultado.setText(op.resta()+"");
            }else if(this.rbMulti.isSelected()){
                this.txtResultado.setText(op.mult()+"");
            }else if(this.rbDivision.isSelected()){
                if(val2 == 0){
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText(null);
                    alert.setTitle("Error");
                    alert.setContentText("El operando 2 no puede ser 0");
                    alert.showAndWait();
                }else{
                    this.txtResultado.setText(op.division()+"");
                }
            }
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
