/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.gui;

import com.mycompany.gestionevenement.entities.Categorie;
import com.mycompany.gestionevenement.services.CategorieCrud;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadia
 */
public class AjoutCategorieController implements Initializable {

    @FXML
    private TextField tfNom;
    @FXML
    private Button btnAjouter;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void AjouterC(ActionEvent event) {
        
        try {
            //sauvgarder dans la base de donnees 
            
            CategorieCrud cc = new CategorieCrud();
            Categorie c = new Categorie();
            String tNom = tfNom.getText();
            
            c.setNom(tNom);
            
            cc.addCategorie2(c);
            
            //redirection vers la page d'affichage
            
            FXMLLoader loader = new FXMLLoader(getClass().getResource("AfficheCategorie.fxml"));
            Parent root = loader.load();
            AfficheCategorieController ac = loader.getController();
            ac.setResNom(tfNom.getText());
            tfNom.getScene().setRoot(root);
            
        } catch (IOException ex) {
            Logger.getLogger(AjoutCategorieController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
