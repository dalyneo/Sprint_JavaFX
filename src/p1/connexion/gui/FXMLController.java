/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import devit.workit.entities.Certificat;
import devit.workit.entities.Test;
import devit.workit.service.ServiceCertificat;
import devit.workit.service.ServiceTest;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javax.swing.JOptionPane;
import sprint_java2.CertificatController;

/**
 * FXML Controller class
 *
 * @author walid belhadj
 */
public class FXMLController implements Initializable {

    
    @FXML
    private TableColumn<Certificat, String> colnomCer;
    @FXML
    private TextField tfnc;
    @FXML
    private TableView<Certificat> table2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          ServiceCertificat sc =new ServiceCertificat();
        ObservableList<Certificat> list3 = null;
      

        try {
            list3 = FXCollections.observableArrayList(sc.AfficherCertificat());
            
        } catch (SQLException ex) {
            Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
        colnomCer.setCellValueFactory(new PropertyValueFactory<>("Nom"));
       
        

        table2.setItems(list3);
        
    }    

   

    @FXML
    private void AjouterCertificat(ActionEvent event) {
         ServiceCertificat sc = new ServiceCertificat();
        if ( tfnc.getText().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setContentText("Merci de remplir le formulaire ");
            alert.showAndWait();
        } else {
            
            
            JOptionPane.showMessageDialog(null, "Certificat ajouté");
        
       Certificat c = new Certificat();
        c.setNom(tfnc.getText());       
       
        sc.AjouterCertificat(c);
             tfnc.clear();
       

          ObservableList<Certificat> list3 = null;
      

        try {
            list3 = FXCollections.observableArrayList(sc.AfficherCertificat());
            
        } catch (SQLException ex) {
            Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
        colnomCer.setCellValueFactory(new PropertyValueFactory<>("Nom"));
       
        table2.setItems(list3);
        }
    }

    
}
