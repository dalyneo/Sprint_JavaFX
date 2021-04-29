/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sprint_java2;

import devit.workit.entities.Reclamation;
import devit.workit.services.ServiceReclamation;
import devit.workit.tools.StaticValue;
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
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * FXML Controller class
 *
 * @author Wael Belhadj
 */
public class ReclafrontFXMLController implements Initializable {

    @FXML
    private Pane profilepan;
    @FXML
    private Hyperlink logouthl;
    @FXML
    private TextField fname;
    @FXML
    private TextArea descf;
    @FXML
    private Button addbtn;
    @FXML
    private Button userbtn;
    @FXML
    private Button recfr;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void logout1(ActionEvent event) throws IOException {
         Stage stage = (Stage) logouthl.getScene().getWindow();
            stage.close();
            StaticValue.utilisateur=null;
        StaticValue.utilisateur=null;
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("LoginFXML.fxml"));
        Parent root1 = (Parent) fxmlLoader.load();
        Stage stager = new Stage();
        stager.initModality(Modality.APPLICATION_MODAL);
        stager.initStyle(StageStyle.UNDECORATED);
        stager.setTitle("WorkIt");
        stager.setScene(new Scene(root1));
        stager.show();
    }

    @FXML
    private void addbtn(ActionEvent event) {
           ServiceReclamation sv = new ServiceReclamation();
        Reclamation p = new Reclamation();
        p.setNom(fname.getText());
        p.setDescription(descf.getText());
        
       
      
       sv.addrecla(p);
    }

    @FXML
    private void userbtn(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("frontFXML.fxml"));
            Stage stage = (Stage) userbtn.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(FrontUserFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void recfr(ActionEvent event) {
         try {
            Parent root = FXMLLoader.load(getClass().getResource("reclafrontFXML.fxml"));
            Stage stage = (Stage) recfr.getScene().getWindow();
            stage.close();
            Scene scene = new Scene(root);
            
            stage.setScene(scene);
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(ReclafrontFXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
