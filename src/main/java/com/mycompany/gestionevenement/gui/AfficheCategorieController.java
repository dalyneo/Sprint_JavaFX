/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.gui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Nadia
 */
public class AfficheCategorieController implements Initializable {

    @FXML
    private TextField resNom;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }   

    public TextField getResNom() {
        return resNom;
    }

    public void setResNom(String resNom) {
        this.resNom.setText(resNom);
    }
    
    
    
}
