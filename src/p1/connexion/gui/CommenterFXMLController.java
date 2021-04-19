/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import p1.connexion.entities.Commentaire;
import p1.connexion.services.CommenterCRUD;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class CommenterFXMLController implements Initializable {

    @FXML
    private TextField txfdes;
    @FXML
    private Label label;
    @FXML
    private TableView<Commentaire> tablecom;
    @FXML
    private TableColumn<Commentaire, String> col_des_com;
    @FXML
    private Button btnajouter;
    @FXML
    private Label labe1;
    private int forumId;
    @FXML
    private Button btnmodifier;
    @FXML
    private Button retourbtn;
    
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
               //  new animatefx.animation.ZoomInUp(btnajouter).play();
                 // new animatefx.animation.ZoomInUp(btnmodifier).play();
                
                
                
                CommenterCRUD c = new CommenterCRUD();
                     try {

            ObservableList<Commentaire> ls = c.read();

         
            col_des_com.setCellValueFactory(new PropertyValueFactory<>("commentaire"));

            tablecom.setItems(ls);

        } catch (Exception ex) {
            Logger.getLogger(CommenterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


public void showinformation(String b) throws SQLException {
        CommenterCRUD c = new CommenterCRUD();

         labe1.setText(b);
        System.out.println(labe1.getText());
      
      ObservableList<Commentaire> ls = c.read3(labe1.getText());

//            col_idcom.setCellValueFactory(new PropertyValueFactory<>("idCom"));
//            col_idf.setCellValueFactory(new PropertyValueFactory<>("idF"));
       
        col_des_com.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tablecom.setItems(ls);

    }

    @FXML
    private void ajoutercommentaire(ActionEvent event) throws SQLException {
      
        // commentaire f = new commentaire(Integer.parseInt(txfidcom.getText()),Integer.parseInt(txfidf.getText()),Integer.parseInt(txfidu.getText()), txfdes.getText());
        Commentaire f = new Commentaire( txfdes.getText());
        f.setForum_id(forumId);
     
        CommenterCRUD s = new CommenterCRUD();
        s.Ajouter(f);
        JOptionPane.showMessageDialog(null, "Ajouter avec sucess");

        

        ObservableList<Commentaire> ls = s.read3(labe1.getText());

        
        col_des_com.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tablecom.setItems(ls);

    }
    @FXML
    private void modifiercommentaire(ActionEvent event) throws SQLException {
        Commentaire c = (Commentaire) tablecom.getSelectionModel().getSelectedItem();

        CommenterCRUD fo = new CommenterCRUD();
       c.setCommentaire(txfdes.getText());

        fo.Modifier(c);

        ObservableList<Commentaire> ls = fo.read3(labe1.getText());
      
        col_des_com.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
        tablecom.setItems(ls);
    }

    @FXML
    private void displaySelected2(javafx.scene.input.MouseEvent event) {
        if (event.getClickCount() == 2) {
            Commentaire i = tablecom.getSelectionModel().getSelectedItem();
            CommenterCRUD si = new CommenterCRUD();
            si.Supprimer(i);
            JOptionPane.showMessageDialog(null, "Suppression avec sucess");
          

            
            try {
                ObservableList<Commentaire> ls = si.read3(labe1.getText());

                
                col_des_com.setCellValueFactory(new PropertyValueFactory<>("commentaire"));
                tablecom.setItems(ls);
            } catch (SQLException ex) {
                Logger.getLogger(CommenterFXMLController.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (event.getClickCount() == 1) {
            Commentaire c = (Commentaire) tablecom.getSelectionModel().getSelectedItem();
            if (c != null) {

                txfdes.setText(c.getCommentaire());

            }
        }


    }
     @FXML
    public void retour(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));

        Parent root = loader.load();
        retourbtn.getScene().setRoot(root);
    }

    public int getForumId() {
        return forumId;
    }

    public void setForumId(int forumId) {
        this.forumId = forumId;
    }
    
    
    
    
}
