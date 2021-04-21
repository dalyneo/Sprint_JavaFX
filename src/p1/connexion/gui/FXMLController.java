/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
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
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.util.Callback;
import javafx.util.Duration;

import javax.swing.JOptionPane;
import p1.connexion.entities.Forum;
import p1.connexion.services.CurseFilterService;
import p1.connexion.services.ForumCRUD;
import p1.connexion.tools.MyConnection;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class FXMLController implements Initializable {


    public TableColumn<Forum, String > views;
    @FXML
    private TableView<Forum> tableforum;
    @FXML
    private TableColumn<Forum, String> col_theme;
    @FXML
    private TableColumn<Forum, String> col_titre;
    @FXML
    private TableColumn<Forum, String> col_contenu;
    @FXML
    private TableColumn<Forum, LocalDateTime> col_date;
    @FXML
    private TextField txftitre;
    @FXML
    private TextField txfcontenu;
    @FXML
    private ComboBox<String> txftheme;
    @FXML
    private Button btnajouter;
    
    ForumCRUD s;
    @FXML
    private TableColumn  Editcol;
    @FXML
    private ComboBox<String> filtre;
    @FXML
    private Button stat;
    @FXML
    private Button btntrier;
    @FXML
    private TextField btnrecherche;
    ObservableList<Forum> list = FXCollections.observableArrayList();
    @FXML
    private Button btnmodifier;
    @FXML
    private Button forum_admin;
    @FXML
    private TableColumn<Forum, ImageView> ratingForum;
    
    private ObservableList<Forum> ls;
   
    


    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         txftheme.getItems().addAll("finance", "soft skills", "manangement");
           filtre.getItems().addAll("", "finance", "soft skills", "manangement");
       
    
        s = new ForumCRUD();
         new animatefx.animation.ZoomInUp(btnajouter).play();
         new animatefx.animation.ZoomInUp(btnmodifier).play();
         new animatefx.animation.ZoomInUp(btntrier).play();
         new animatefx.animation.ZoomInUp(stat).play();
         
         
        
         // ls = s.read();

            
            col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            ratingForum.setCellValueFactory(new PropertyValueFactory<>("ratingImg"));

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
                               FXMLLoader loader = new FXMLLoader(getClass().getResource("commenterFXML.fxml"));
                                try {
                                    Parent root = (Parent) loader.load();
                                    editButton.getScene().setRoot(root);
                                    CommenterFXMLController CommentaireController = loader.getController();
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
            
            //tableforum.setItems(ls);
           
            
            
    }
    
        @FXML
    public void forum_admin(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("forumBackFXML.fxml"));

        Parent root = loader.load();
        forum_admin.getScene().setRoot(root);
    }
    
    
    @FXML
    private void ajouterforum(ActionEvent event) {
        
       
        Forum f = new Forum(CurseFilterService.cleanText(txftitre.getText()), CurseFilterService.cleanText(txfcontenu.getText()), txftheme.getValue());
        ForumCRUD s = new ForumCRUD();

        s.addPerson2(f);
        JOptionPane.showMessageDialog(null, "Ajouter avec sucess");
        
        
         ls = s.read();
        col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            col_date.setCellValueFactory(new PropertyValueFactory<>("date"));
            tableforum.setItems(ls);

    }
    
    @FXML
    private void displaySelected(javafx.scene.input.MouseEvent event) {
        if (event.getClickCount() == 2) {
           
        Forum i = tableforum.getSelectionModel().getSelectedItem();
            ForumCRUD si = new ForumCRUD();
            
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                            alert.setTitle("Confirmation Dialog");
                            alert.setHeaderText("Supprimer " + i.getSujet()+ " ?");

                            Optional<ButtonType> result = alert.showAndWait();
                            if (result.get() == ButtonType.OK){
                                si.Supprimer(i);
                                JOptionPane.showMessageDialog(null, "Suppression avec sucess");
                                ls = si.read();
            col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            tableforum.setItems(ls);
                            }
            
            
            
            
            
            
      
            
        } else if (event.getClickCount() == 1) {
            Forum c = (Forum) tableforum.getSelectionModel().getSelectedItem();
            if (c != null) {

                txftitre.setText(c.getSujet());
                txfcontenu.setText(c.getProbleme());
                txftheme.setValue(c.getTheme());
            }
        }

    }
    
    @FXML
    private void modifierforum(ActionEvent event) throws SQLException {
        Forum c = (Forum) tableforum.getSelectionModel().getSelectedItem();

        ForumCRUD fo = new ForumCRUD();
        Forum h = new Forum(c.getId(), txftitre.getText(), txfcontenu.getText(), txftheme.getValue());
        System.out.println(h.getId());
        System.out.println(txftitre.getText());
        fo.Modifier(h);

        ls = fo.read();
        // col_idF.setCellValueFactory(new PropertyValueFactory<>("idF"));
        col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
        col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
        tableforum.setItems(ls);
    }
    
    
    @FXML
      private void filtrer(ActionEvent event) throws SQLException {
        ForumCRUD fo = new ForumCRUD();
        if (filtre.getValue() != "") {
            ls = fo.filtrer((String) filtre.getValue());
            col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            tableforum.setItems(ls);
        } else {
            ls = fo.read();
            col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
            col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
            col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));
            tableforum.setItems(ls);

        }
    }
   
    
    



    public TableView<Forum> getTableforum() {
        return tableforum;
    }

    public TableColumn<Forum, String> getCol_theme() {
        return col_theme;
    }

    public TableColumn<Forum, String> getCol_titre() {
        return col_titre;
    }

    public TableColumn<Forum, String> getCol_contenu() {
        return col_contenu;
    }

    public TableColumn<Forum, LocalDateTime> getCol_date() {
        return col_date;
    }

    public TextField getTxftitre() {
        return txftitre;
    }

    public TextField getTxfcontenu() {
        return txfcontenu;
    }

    public ComboBox<String> getTxftheme() {
        return txftheme;
    }

    public Button getBtnajouter() {
        return btnajouter;
    }

    public ForumCRUD getS() {
        return s;
    }

    @FXML
    private void afficherStat(ActionEvent event) {
         FXMLLoader loader = new FXMLLoader(getClass().getResource("stat.fxml"));

        try {
            Parent root = loader.load();
            stat.getScene().setRoot(root);
        } catch (IOException ex) {
            Logger.getLogger(FXMLController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void Trier(ActionEvent event) throws SQLException {
        trierTheme();
    }
     public void trierTheme() throws SQLException {
        ObservableList<Forum> reslist = FXCollections.observableArrayList();

        // col_idF.setCellValueFactory(new PropertyValueFactory<>("idF"));
       
        col_titre.setCellValueFactory(new PropertyValueFactory<>("sujet"));
        col_contenu.setCellValueFactory(new PropertyValueFactory<>("probleme"));
        col_theme.setCellValueFactory(new PropertyValueFactory<>("theme"));

        ForumCRUD fo = new ForumCRUD();

        List old = fo.getTrierParTheme();
        reslist.addAll(old);
        tableforum.setItems(reslist);
        tableforum.refresh();

        

    }

 
   @FXML    
     public void recherche(){
         
//         List<Forum> aux = new ArrayList<>();
//         
//         ls.forEach(item -> {
//             if(item.getSujet().toLowerCase().contains(btnrecherche.getText().toLowerCase()))
//                 aux.add(item);
//                 tableforum.setItems(FXCollections.observableArrayList(aux));
//                 });
         
    
         
         
         
         
         
   ForumCRUD fo = new ForumCRUD();
    List<Forum>results = new ArrayList<>();
    results = fo.read();
     
     FilteredList<Forum> filteredData = new FilteredList<>(list , b -> true);
    
       
     
     
		Forum e = new Forum();
		// 2. Set the filter Predicate whenever the filter changes.
		btnrecherche.textProperty().addListener((observable, oldValue, newValue) -> {
			filteredData.setPredicate(forum -> {
				// If filter text is empty, display all persons.
								
				if (newValue == null || newValue.isEmpty()) {
					return true;
				}
				
				// Compare first name and last name of every person with filter text.
				String lowerCaseFilter = newValue.toLowerCase();
				
				if (forum.getTheme().toLowerCase().indexOf(lowerCaseFilter) != -1 ) {
					return true; // Filter matches first name.
				} else if (forum.getSujet().toLowerCase().indexOf(lowerCaseFilter) != -1) {
					return true; // Filter matches last name.
				}
				else if (String.valueOf(e.getSujet()).indexOf(lowerCaseFilter)!=-1)
				     return true;
				     else  
				    	 return false; // Does not match.
			});
		});
		
		// 3. Wrap the FilteredList in a SortedList. 
		SortedList<Forum> sortedData = new SortedList<>(filteredData);
		
		// 4. Bind the SortedList comparator to the TableView comparator.
		// 	  Otherwise, sorting the TableView would have no effect.
		sortedData.comparatorProperty().bind(tableforum.comparatorProperty());
		
		// 5. Add sorted (and filtered) data to the table.
		tableforum.setItems(sortedData);
               
        
    }

    public ObservableList<Forum> getLs() {
        return ls;
    }

    public void setLs(ObservableList<Forum> ls) {
        this.ls = ls;
    }
     
     
     
    

    }    
    

