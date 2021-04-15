/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.gui;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Nadia
 */
public class StartPointC extends Application {
    
    @Override
    public void start(Stage primaryStage) {
       
         System.out.println(getClass().getResource("AjoutCategorie.fxml").getPath());
        try {
            Parent root = FXMLLoader.load(getClass().getResource("AjoutCategorie.fxml"));
            
            Scene scene = new Scene(root,900,700);
            
            primaryStage.setTitle("Ajouter Categorie");
            primaryStage.setScene(scene);
            primaryStage.show();
            
        } catch (IOException ex) {
            Logger.getLogger(StartPointC.class.getName()).log(Level.SEVERE, null, ex);
        }
            
            
        
        
        
       
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
