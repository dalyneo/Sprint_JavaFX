package edu.devit.gui;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StartPoint extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage Stage) {

        try {

            Parent root = FXMLLoader.load(getClass().getResource("AddFreelancer.fxml"));
            Scene scene = new Scene (root, 300, 250); //root heya les acteurs mte3na
            File f = new File("src/edu/devit/stylesheets/style.css");
            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));


            Stage.setTitle("devit");

            Stage.setScene(scene);
            Stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
