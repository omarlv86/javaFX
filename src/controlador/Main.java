/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.io.IOException;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;


/**
 *
 * @author USER
 */
public class Main extends Application {

    @Override
    public void start(Stage primaryStage){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(Main.class.getResource("/vista/ejemploVista.fxml"));
            Pane ventana = (Pane) loader.load();
            
            //show the scene containing the root layour.
            Scene scene = new Scene(ventana);
            primaryStage.setScene(scene);
            primaryStage.show();
        }catch(IOException e){
        }
    }
    
    public static void main(String[] args){
        launch(args);
    }
    
}
