/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.util.Callback;
import javafx.util.Duration;
import javax.swing.JOptionPane;
import p1.connexion.entities.Forum;
import p1.connexion.services.CommenterCRUD;
import p1.connexion.services.ForumCRUD;
import tray.notification.NotificationType;
import tray.notification.TrayNotification;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class ForumBackFXMLController implements Initializable {

    @FXML
    private TableView<Forum> tableforum_back;
    @FXML
    private TableColumn<Forum, String> col_theme;
    @FXML
    private TableColumn<Forum, String> col_titre;
    @FXML
    private TableColumn<Forum, String> col_contenu;
    @FXML
    private TableColumn<Forum, String> col_date;
    @FXML
    private TableColumn<Forum, String> views;
    @FXML
    private TableColumn<Forum, String> Editcol;
    @FXML
    private ComboBox<String> filtre;
    @FXML
    private Button retour_back;
    @FXML
    private Button stat;
    @FXML
    private Button forum_admin;
      private ObservableList<Forum> ls;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
       
           filtre.getItems().addAll("", "finance", "soft skills", "manangement");
       
    
      ForumCRUD  s = new ForumCRUD();
        new animatefx.animation.ZoomInUp(stat).play();
          new animatefx.animation.ZoomInUp(retour_back).play();
        
        // new animatefx.animation.ZoomInUp(stat).play();
         
         
        
         ObservableList<Forum> ls = s.read();

            
            col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            views.setCellValueFactory(new PropertyValueFactory<>("nviews"));
            Callback<TableColumn<Forum, String>, TableCell<Forum, String>> cellFactory = (param) -> {
                TableCell<Forum, String> cell = new TableCell<Forum, String>() {
                    
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                            setText(null);
                        } else {
                            Button editButton = new Button("+");
                            editButton.setOnAction(event -> {
                                Forum f = getTableView().getItems().get(getIndex());
                               FXMLLoader loader = new FXMLLoader(getClass().getResource("commenterBack.fxml"));
                                try {
                                    Parent root = (Parent) loader.load();
                                    editButton.getScene().setRoot(root);
                                    CommenterBackController CommentaireController = loader.getController();
                                    CommentaireController.setForumId(f.getId());
                                    CommentaireController.showinformation(Integer.toString(f.getId()));

                                } catch (IOException ex) {
                                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                } catch (SQLException ex) {
                                    Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
                                }
                            });

                            setGraphic(editButton);
                            setText(null);

                        }

                    }
                };

                return cell;
            };
            
            Editcol.setCellFactory(cellFactory);
            
            tableforum_back.setItems(ls);
           
            
    }    


    @FXML
  
         private void filtrer2(ActionEvent event) throws SQLException {
        ForumCRUD fo = new ForumCRUD();
        if (filtre.getValue() != "") {
            ObservableList<Forum> ls = fo.filtrer((String) filtre.getValue());
            col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            tableforum_back.setItems(ls);
        } else {
            ObservableList<Forum> ls = fo.read();
            col_titre.setCellValueFactory(new PropertyValueFactory<>("titre"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("contenu"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            tableforum_back.setItems(ls);

        }
    }
   
    
    
    
    
    @FXML
      public void retourBack(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));

        Parent root = loader.load();
        FXMLController fXMLController = loader.getController();
            fXMLController.setLs(new ForumCRUD().read());
            fXMLController.getLs().forEach((forum) -> {
            int count = new CommenterCRUD().countCommentersByForumId(forum.getId());
            int sum = new CommenterCRUD().ratingSum(forum.getId());
            int moy = 0;
            if (count != 0) {
                moy = sum / count;
            }
            
            switch (moy) {
                case 0: case 1:
                    forum.setRatingImage("StarVide.png");
                break;
                
                case 2: case 3: case 4:
                    forum.setRatingImage("demiStar.png");
                break;
                
                default:
                    forum.setRatingImage("Star.png");
                break;

                                    }
        });
        fXMLController.getTableforum().setItems(fXMLController.getLs());
        retour_back.getScene().setRoot(root);
    }
      
    @FXML
          private void displaySelectedBack(javafx.scene.input.MouseEvent event) {
               TrayNotification tray = null;
        if (event.getClickCount() == 2) {
            Forum i = tableforum_back.getSelectionModel().getSelectedItem();
            ForumCRUD si = new ForumCRUD();
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            alert.setHeaderText("Supprimer " + i.getSujet()+ " ?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                si.Supprimer(i);
           // JOptionPane.showMessageDialog(null, "Suppression avec sucess");
      
            ObservableList<Forum> ls = si.read();
             tray = new TrayNotification("Forum", "Forum supprimer avec succces ", NotificationType.SUCCESS);
        tray.showAndDismiss(Duration.seconds(6));
            col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            tableforum_back.setItems(ls);
                            }
            
            
            
            
           
        } else if (event.getClickCount() == 1) {
            Forum c = (Forum) tableforum_back.getSelectionModel().getSelectedItem();
        
        }

    }

    @FXML
    private void afficherStat2(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("stat.fxml"));

        try {
            Parent root = loader.load();
            stat.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void forum_admin(ActionEvent event) {
    }
    public ObservableList<Forum> getLs() {
        return ls;
    }

    public void setLs(ObservableList<Forum> ls) {
        this.ls = ls;
    }
      public TableView<Forum> getTableforum() {
        return tableforum_back;
    }
}
