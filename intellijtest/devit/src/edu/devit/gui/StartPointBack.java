package edu.devit.gui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class StartPointBack extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        try {

            Parent root = FXMLLoader.load(getClass().getResource("Back.fxml"));
            Scene scene = new Scene (root, 300, 250); //root heya les acteurs mte3na
            File f = new File("src/edu/devit/stylesheets/style.css");
            scene.getStylesheets().add("file:///" + f.getAbsolutePath().replace("\\", "/"));


            primaryStage.setTitle("devit");

            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    }

