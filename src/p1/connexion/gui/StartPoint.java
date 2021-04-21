/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import p1.connexion.services.CommenterCRUD;
import p1.connexion.services.ForumCRUD;

/**
 *
 * @author HP-PC
 */
public class StartPoint extends Application {

    public static void main(String[] args) {
        launch(args);
    }

   
    public void start(Stage primaryStage) {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));
        Parent root = null;
        try {
            root = loader.load();
           
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
        Scene scene = new Scene(root,1800,800);
        scene.getStylesheets().add("style.css");
        primaryStage.setTitle("ESPRIT work ");
        primaryStage.setScene(scene);
        primaryStage.show();

        } catch (IOException e) {
            System.out.println(e);
        }
        
               


        
    
    
}
}