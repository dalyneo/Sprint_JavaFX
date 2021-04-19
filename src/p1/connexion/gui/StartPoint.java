/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author HP-PC
 */
public class StartPoint extends Application {

    public static void main(String[] args) {
        launch(args);
    }

   
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
            root = FXMLLoader.load(getClass().getResource("FXML.fxml"));
        } catch (IOException e) {
            System.out.println(e);
        }
        Scene scene = new Scene(root,1800,800);
        scene.getStylesheets().add("style.css");
        

        
        
        primaryStage.setTitle("ESPRIT work ");
        primaryStage.setScene(scene);
        primaryStage.show();
    
}
}