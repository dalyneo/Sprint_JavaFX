/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.gui;

import devit.workit.entites.Offre;
import devit.workit.services.CommentCRUD;
import devit.workit.services.OffreCRUD;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AccueilController implements Initializable {

    @FXML
    private Button categorie;
    @FXML
    private TableView<?> tableforum;
    @FXML
    private TableColumn<?, ?> col_theme;
    @FXML
    private TableColumn<?, ?> col_titre;
    @FXML
    private TableColumn<?, ?> col_contenu;
    @FXML
    private TableColumn<?, ?> col_date;
    @FXML
    private TableColumn<?, ?> Editcol;
    @FXML
    private TextField txftitre;
    @FXML
    private TextField txfcontenu;
    @FXML
    private ComboBox<?> txftheme;
    @FXML
    private Button btnajouter;
    @FXML
    private Button btnmodifier;
    @FXML
    private ComboBox<?> filtre;
    @FXML
    private Button stat;
    @FXML
    private Button btntrier;
    @FXML
    private TextField btnrecherche;
    @FXML
    private Button offre;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void checkcategorie(MouseEvent event) {
    }

   
    @FXML
    private void checkoffre(MouseEvent event) throws IOException {
         FXMLLoader loader =
                    new FXMLLoader(getClass().getResource("DevitOffre.fxml"));
            Parent root = loader.load();
            DevitOffreController dc = loader.getController();
            offre.getScene().setRoot(root);
    }

    @FXML
    private void displaySelected(MouseEvent event) {
    }

    @FXML
    private void ajouterforum(ActionEvent event) {
    }

    @FXML
    private void modifierforum(ActionEvent event) {
    }

    @FXML
    private void filtrer(ActionEvent event) {
    }

    @FXML
    private void afficherStat(ActionEvent event) {
    }

    @FXML
    private void Trier(ActionEvent event) {
    }

    @FXML
    private void recherche(KeyEvent event) {
    }
    
}
