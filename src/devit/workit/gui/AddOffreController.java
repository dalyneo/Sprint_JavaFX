/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.gui;

import com.jfoenix.controls.JFXTextArea;
import devit.workit.entites.AlertDialog;
import devit.workit.entites.Categorie;
import devit.workit.entites.Offre;
import devit.workit.entites.SessionWorkit;
import static devit.workit.gui.CategorieAccueilController.saveToFileImageNormal;
import devit.workit.services.CategorieCRUD;
import devit.workit.services.OffreCRUD;
import devit.workit.tools.MyConnection;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static java.util.Collections.list;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.embed.swing.SwingFXUtils;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import javax.imageio.ImageIO;
import org.apache.commons.lang3.RandomStringUtils;

/**
 * FXML Controller class
 *
 * @author ASUS
 */
public class AddOffreController implements Initializable {

    private ImageView treturn;
    @FXML
    private TextField tnom;
    @FXML
    private TextField temail;
    @FXML
    private TextField ttitle;
    @FXML
    private JFXTextArea tdesc;
    @FXML
    private ComboBox<String> tcombo;
    @FXML
    private ImageView imgButton;
 ObservableList<String> list = FXCollections.observableArrayList();
    @FXML
    private Button categorie;
    @FXML
    private Button offre;
    @FXML
    private Button addoffre;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         try { 
             Connection con = MyConnection.getInstance().getCnx();
             Statement ste = con.createStatement();
        ResultSet rs=ste.executeQuery("select nom from categorie");
        while (rs.next())
        {
        list.add(rs.getString("nom"));
        }
        tcombo.setItems(list);
        } catch(SQLException e) {}
        // TODO
    }    


    @FXML
    private void addimage(MouseEvent event) {
         FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter extFilterJPG = new FileChooser.ExtensionFilter("JPG files (*.jpg)", "*.JPG");
        FileChooser.ExtensionFilter extFilterPNG = new FileChooser.ExtensionFilter("PNG files (*.png)", "*.PNG");
        fc.getExtensionFilters().addAll(extFilterJPG, extFilterPNG);
        File selectedFile = fc.showOpenDialog(null);
        try {
            BufferedImage bufferedImage = ImageIO.read(selectedFile);
            Image image = SwingFXUtils.toFXImage(bufferedImage, null);
            imgButton.setImage(image);
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
  public static String saveToFileImageNormal(Image image)throws SQLException  {

        String ext = "jpg";
        File dir = new File("C:/Users/ASUS/Desktop/Sprint_web/public/picture");
        File dir1 = new File("C:/Users/ASUS/Desktop/codenameone/Sprint_java/src/picture");
        String name = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
       // String name1 = String.format("%s.%s", RandomStringUtils.randomAlphanumeric(8), ext);
        File outputFile = new File(dir, name);
        File outputFile1 = new File(dir1, name);
        BufferedImage bImage = SwingFXUtils.fromFXImage(image, null);
        BufferedImage bImage1 = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bImage, "png", outputFile);
               ImageIO.write(bImage1, "png", outputFile1);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return name;
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
    private void ajouter(MouseEvent event) throws SQLException, IOException {
         OffreCRUD off = new OffreCRUD();
            Offre o = new Offre();
            String tNom = tnom.getText();
            
            String email = temail.getText();
            String title = ttitle.getText();
            String Desc = tdesc.getText();
            String cat = (String) tcombo.getValue();
          
           Connection con = MyConnection.getInstance().getCnx();
           Statement ste = con.createStatement();
           ResultSet rs=ste.executeQuery("SELECT `id` FROM `categorie` WHERE `nom`='"+cat+"'");
             if(rs.next()){
                      o.setIdcategoriy_id(rs.getInt(1));
             }
                         boolean test = false ;
                          if (tnom.getText().equals("") || temail.getText().equals("") || ttitle.getText().equals("") || tdesc.getText().equals("") || cat.equals("") || addoffre.getText().equals("")) {
                AlertDialog.showNotification("Error !", "Verifier les champs", AlertDialog.image_cross);
                 } else {     
                               Image image1=null;
             image1 = imgButton.getImage();
             String photo = null;
             photo = saveToFileImageNormal(image1);
                               o.setNom(tNom);
           o.setEmail(email);
           o.setLogo(photo);
           o.setTitle(title);
           o.setDescription(Desc);
           o.setIdrecruteur_id(SessionWorkit.getId());
           o.setAbn(0);
                test = off.AddOffre(o);
                 AlertDialog.showNotification("Offre", "Offre a été ajouter", AlertDialog.image_checked);
                          }
    }

    
}
