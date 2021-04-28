/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint_java2;

import devit.workit.entities.Test;
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
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author walid belhadj
 */
public class FrontFXMLController implements Initializable {

     private ServiceTest sr = new ServiceTest();
    private Test test;
    @FXML
    private Pane stestpane;
   
    @FXML
    private TableView<Test> table1;
    @FXML
    private Pane testpane;
    @FXML
    private Text q1t;
    @FXML
    private TextField r1tf;
    @FXML
    private Text q2t;
    @FXML
    private TextField r2tf;
    @FXML
    private Text q3t;
    @FXML
    private TextField r3tf;
    @FXML
    private Text q4t;
    @FXML
    private TextField r4tf;
    @FXML
    private Text q5t;
    @FXML
    private TextField r5tf;
    @FXML
    private Button confirmerbtn;
    @FXML
    private Text resulttext;
    @FXML
    private Pane resultpane;
    @FXML
    private TableColumn<Test, String> colnom;
    @FXML
    private TableColumn<Test, String> colq1;
    @FXML
    private TableColumn<Test, String> colq2;
    @FXML
    private TableColumn<Test, String> colq3;
    @FXML
    private TableColumn<Test, String> colq4;
    @FXML
    private TableColumn<Test, String> colq5;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
          
        ObservableList<Test> list3 = null;
      

        try {
            list3 = FXCollections.observableArrayList(sr.AfficherTest());
            
        } catch (SQLException ex) {
            Logger.getLogger(CertificatController.class.getName()).log(Level.SEVERE, null, ex);
        }

     
        colnom.setCellValueFactory(new PropertyValueFactory<>("Nom"));
        colq1.setCellValueFactory(new PropertyValueFactory<>("Q1"));
        colq2.setCellValueFactory(new PropertyValueFactory<>("Q2"));
        colq3.setCellValueFactory(new PropertyValueFactory<>("Q3"));
        colq4.setCellValueFactory(new PropertyValueFactory<>("Q4"));
        colq5.setCellValueFactory(new PropertyValueFactory<>("Q5"));
      
        table1.setItems(list3);
        
        
    }    

    @FXML
    private void SelectTest(MouseEvent event) {
         ServiceTest st = new ServiceTest();

        int index = table1.getSelectionModel().getSelectedIndex();
        if (index <= -1) {

            return;
        }
       
        String nom = colnom.getCellData(index);
        String q1 = colq1.getCellData(index);
        
        String q2 = colq2.getCellData(index);
        
        String q3 = colq3.getCellData(index);
        
        String q4 = colq4.getCellData(index);
        
        String q5 = colq5.getCellData(index);
        
        test=st.findById(table1.getSelectionModel().getSelectedItem().getId());
        q1t.setText(test.getQ1());
        q2t.setText(test.getQ2());
        q3t.setText(test.getQ3());
        q4t.setText(test.getQ4());
        q5t.setText(test.getQ5());
        
        stestpane.setVisible(false);
        testpane.setVisible(true);
    }

    @FXML
    private void confirmertest(ActionEvent event) {
        int note=0;
        String r1=r1tf.getText();
        String r2=r2tf.getText();
        String r3=r3tf.getText();
        String r4=r4tf.getText();
        String r5=r5tf.getText();
        Test reponses = new Test(r1,r2,r3,r4,r5);
        if(reponses.getR1().equals(test.getR1()))
        {
            note++;
        }
        if(reponses.getR2().equals(test.getR2()))
        {
            note++;
        }
        if(reponses.getR3().equals(test.getR3()))
        {
            note++;
        }
        if(reponses.getR4().equals(test.getR4()))
        {
            note++;
        }
        if(reponses.getR5().equals(test.getR5()))
        {
            note++;
        }
        resultpane.setVisible(true);
        testpane.setVisible(false);
        if(note>=3)
        {
            resulttext.setText("Félicitation! vous avez bien passé le test: votre note est "+note+"/5");
        }else{
            resulttext.setText(" vous avez échoué le test: votre note est "+note+"/5");
        }
        
    }

    @FXML
    private void test(MouseEvent event) {
        stestpane.setVisible(true);
        testpane.setVisible(false);
        resultpane.setVisible(false);
        test=null;
    }
    
}

   