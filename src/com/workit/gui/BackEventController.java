/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workit.gui;

import com.workit.entities.Evenement;
import com.workit.services.EvenementCrud;
import com.workit.tools.MyConnection;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Nadia
 */
public class BackEventController implements Initializable {

    @FXML
    private TableView<Evenement> tableE;
    @FXML
    private TableColumn<Evenement, String> col_id;
    @FXML
    private TableColumn<Evenement, String> col_nom;
    @FXML
    private TableColumn<Evenement, String> col_date;
    @FXML
    private TableColumn<Evenement, String> col_description;
    @FXML
    private TableColumn<Evenement, String> col_email;
    @FXML
    private TableColumn<Evenement , Integer> col_cat;
    @FXML
    private TextField tfId;
    @FXML
    private TextField tfNom;
    @FXML
    private TextField tfDate;
    @FXML
    private TextField tfDescription;
    @FXML
    private TextField tfEmail;
    @FXML
    private ComboBox<?> catC;
    @FXML
    private Button btnSupp;

   ObservableList<Evenement> obevent = FXCollections.observableArrayList();
    @FXML
    private Button btnActualiser;
    @FXML
    private TextField rNom;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        
        EvenementCrud ec = new EvenementCrud();
       catC.setItems((ObservableList)ec.selectIDP());
      
            
          
        try {
            // TODO

            Connection con = MyConnection.getInstance().getCnx();
            
            
            ResultSet rs = con.createStatement().executeQuery("select id , nom , date , description , email , idcat_id  from evenement ");
            while (rs.next()) {
               
                
                obevent.add(new Evenement(rs.getString("id"), rs.getString("nom"), rs.getString("description"), rs.getString("date"), rs.getString("email"), rs.getInt("idcat_id")));
            }
        } catch (SQLException ex) {
            Logger.getLogger(Evenement1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_cat.setCellValueFactory(new PropertyValueFactory<>("idcat_id"));
        
        
         tableE.setItems(obevent);
        RechercherEvenment();
        setCellValueFromTable();
    }    
    
    private void setCellValueFromTable() {
        tableE.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {

                Evenement e = tableE.getItems().get(tableE.getSelectionModel().getSelectedIndex());
                tfId.setText(e.getId());
                tfNom.setText(e.getNom());
                tfDate.setText(e.getDate());
                //Date.valueOf(eventDate.setText(e.getDate()));
                //Date.valueOf(tfDate.setText(e.getDate()));
                
                tfDescription.setText(e.getDescription());
                tfEmail.setText(e.getEmail());
               // tfParticipants.setText(String.valueOf(e.getNbp()));

            }

        });
    }

    @FXML
    private void SupprimerEvenement(ActionEvent event) {
        
        Connection con = MyConnection.getInstance().getCnx();

        EvenementCrud ec = new EvenementCrud();

        String id = tfId.getText();

        ec.DeleteEvent(id);

        tfId.clear();
        tfNom.clear();
        tfDate.clear();
        tfDescription.clear();
        tfEmail.clear();
        //tfParticipants.clear();
        JOptionPane.showMessageDialog(null, "evenement Supprime");
    }

    @FXML
    private void ActualiserEvenement(ActionEvent event) {
        
        
         obevent.clear();

        try {

            String requete = "SELECT id,nom,date,description,email,idcat_id FROM evenement ";
            ResultSet rs;
            try (PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete)) {
                rs = pst.executeQuery();
                while (rs.next()) {
                    obevent.add(new Evenement(rs.getString("id"), rs.getString("nom"), rs.getString("description"), rs.getString("date") , rs.getString("email"),rs.getInt("idcat_id")));
                    tableE.setItems(obevent);
                }
            }
            rs.close();
          

        } catch (SQLException ex) {
            Logger.getLogger(Evenement1Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
       private void RechercherEvenment() {

        /* Connection con = MyConnection.getInstance().getCnx();
        
        EvenementCrud ec = new EvenementCrud();
        
        String nom = rNom.getText();
        
        ec.RechercheEvenement(nom); */
 /*col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_nom.setCellValueFactory(new PropertyValueFactory<>("nom"));
        col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
        col_description.setCellValueFactory(new PropertyValueFactory<>("description"));
        col_email.setCellValueFactory(new PropertyValueFactory<>("email"));
        col_participant.setCellValueFactory(new PropertyValueFactory<>("participants")); */
 /* Employee emp1 = new Employee(112, "AMIT", "ams@gmail.com", "Finance", 30000);
        Employee emp2 = new Employee( 115, "Peter", "peter@gmail.com", "Defence System", 40000);
        Employee emp3 = new Employee( 116, "SAM", "sam@gmail.com", "Radar Anaysist", 80000);
        Employee emp4 = new Employee(117, "Jhon", "jhon@gmail.com", "Ground Staff", 80000);   */
        //dataList.addAll(emp1,emp2, emp3, emp4);
        // Wrap the ObservableList in a FilteredList (initially display all data).
        
        FilteredList<Evenement> filteredEvent = new FilteredList<>(obevent, b -> true);

        // 2. Set the filter Predicate whenever the filter changes.
        rNom.textProperty().addListener((observable, oldValue, newValue) -> {
            filteredEvent.setPredicate(evenement -> {
                // If filter text is empty, display all persons.

                if (newValue == null || newValue.isEmpty()) {
                    return true;
                }

                // Compare first name and last name of every person with filter text.
                String lowerCaseFilter = newValue.toLowerCase();

                if (evenement.getNom().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches first name.
                } else if (evenement.getDescription().toLowerCase().indexOf(lowerCaseFilter) != -1) {
                    return true; // Filter matches last name.
                } else {
                    return false; // Does not match.
                }
            });
        });

        // 3. Wrap the FilteredList in a SortedList. 
        SortedList<Evenement> sortedEvent = new SortedList<>(filteredEvent);

        // 4. Bind the SortedList comparator to the TableView comparator.
        // 	  Otherwise, sorting the TableView would have no effect.
        sortedEvent.comparatorProperty().bind(tableE.comparatorProperty());

        // 5. Add sorted (and filtered) data to the table.
        tableE.setItems(sortedEvent);

    }

    
}
