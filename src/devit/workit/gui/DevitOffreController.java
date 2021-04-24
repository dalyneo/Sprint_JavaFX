/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.gui;

import devit.workit.entites.AlertDialog;
import devit.workit.entites.Comment;
import devit.workit.entites.Offre;
import devit.workit.entites.SessionWorkit;
import devit.workit.entites.staticEntity;
import devit.workit.services.CommentCRUD;
import devit.workit.services.OffreCRUD;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import static java.time.LocalDateTime.now;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class DevitOffreController implements Initializable {

    @FXML
    private Button categorie;
    @FXML
    private Button offre;
    @FXML
    private ScrollPane scroll;
    staticEntity se = new staticEntity();
    @FXML
    private ScrollPane scroll2;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        try {
            show();
            // TODO
        } catch (FileNotFoundException ex) {
            Logger.getLogger(DevitOffreController.class.getName()).log(Level.SEVERE, null, ex);
        }
       
        
    }
    public void show1()
    {
         VBox btn = new VBox();
        ScrollPane Co = new ScrollPane();
        Button btnad = new Button();
        btnad.setText("Ajouter une offre");
        btn.getChildren().add(btnad);
        scroll2.setContent(btn);
         btnad.setOnAction(e -> {
             try {
                 FXMLLoader loader
                         = new FXMLLoader(getClass().getResource("AddOffre.fxml"));
                 Parent root = loader.load();
                 AddOffreController dc = loader.getController();  
                 btnad.getScene().setRoot(root);
             } catch (IOException ex) {
                 Logger.getLogger(DevitOffreController.class.getName()).log(Level.SEVERE, null, ex);
             }
         });
    }
    public void show() throws FileNotFoundException {
        OffreCRUD of = new OffreCRUD();
        CommentCRUD com = new CommentCRUD();
        List<Offre> liste = of.getAllOffre();
        VBox offres = new VBox();
                offres.setStyle("-fx-border-color: red;\n" +
                   "-fx-border-insets: 5;\n" +
                   "-fx-border-width: 3;\n");
        ScrollPane Co = new ScrollPane();
        VBox comm = new VBox();
        for (Offre oo : liste) {
            if("recruteur".equals(SessionWorkit.getType()))
            {
                show1();
            }
            VBox ligne = new VBox();
            HBox col = new HBox();
            VBox ll = new VBox();
            ligne.setSpacing(20);
            ll.setSpacing(10);
            col.setSpacing(40);
            Button bt = new Button("Make Offre");
            HBox hb = new HBox();
            hb.getChildren().add(bt);
            if(SessionWorkit.getId()==oo.getIdrecruteur_id())
            {
            Button bts = new Button("Delete this offre");
            hb.getChildren().add(bts);
            bts.setOnAction(e -> {
                Alert a = new Alert(Alert.AlertType.NONE);
                a.setAlertType(Alert.AlertType.CONFIRMATION);
                a.setTitle("Confirmation");
                a.setHeaderText(null);
                a.setContentText("Are you sure to delete this offre");
                Optional <ButtonType> action = a.showAndWait();
        if(action.get()== ButtonType.OK)
        {
                OffreCRUD offe = new OffreCRUD();
                 boolean test = false ;
                    try {
                        test = offe.Supprimer(oo.getId());
                         AlertDialog.showNotification("Offre", "Offre supprimée", AlertDialog.image_checked);
                         acc();
                    } catch (SQLException ex) {
                        Logger.getLogger(DevitOffreController.class.getName()).log(Level.SEVERE, null, ex);
                    } catch (FileNotFoundException ex) {
                        Logger.getLogger(DevitOffreController.class.getName()).log(Level.SEVERE, null, ex);
                    }
        }
            });
            }
            bt.setOnAction(e -> {
                se.setId(oo.getId());
                se.setNom(oo.getNom());
                se.setViews(oo.getAbn());
                se.setDescription(oo.getDescription());
                se.setImage(oo.getLogo());
                boolean test = false;
                try {
                    Offre o = new Offre(oo.getId(), oo.getAbn());
                    test = of.NbViews(o);
                } catch (SQLException ex) {
                }
                FXMLLoader loader
                        = new FXMLLoader(getClass().getResource("MakeOffre.fxml"));
                Parent root;
                try {
                    root = loader.load();
                    MakeOffreController dc = loader.getController();
                    bt.getScene().setRoot(root);
                } catch (IOException ex) {
                    Logger.getLogger(DevitOffreController.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            
            /**
             * **************************
             */
            Label Titre = new Label("Title : " + oo.getTitle());
            Titre.setPrefSize(600, 15);
            ligne.getChildren().add(Titre);
            ligne.setPadding(new Insets(30, 250, 30, 250));
            ImageView imgButton = new ImageView();
            String ImageUrl = "/picture/";
            Image image2 = new Image(ImageUrl + oo.getLogo());
            imgButton.setImage(image2);
            imgButton.setFitHeight(200);
            imgButton.setFitWidth(300);
            Text desc = new Text("Description :\n" + oo.getDescription());
            Label view = new Label("Views: " + String.valueOf(oo.getAbn()));
            Label nom = new Label("Nom d'offre : " + oo.getNom());
            ll.getChildren().addAll(nom,desc, view);
            col.getChildren().addAll(imgButton, ll);
            Label rec = new Label("By  : " + SessionWorkit.getPrenom());
            ligne.getChildren().addAll(col, rec, hb);
            offres.getChildren().addAll(ligne);
        }
        scroll.setContent(offres);
    }

    @FXML
    private void checkcategorie(MouseEvent event) {
    }

    @FXML
    private void checkoffre(MouseEvent event) {
    }
    private void acc() throws FileNotFoundException
    {
        show();
    }
}
