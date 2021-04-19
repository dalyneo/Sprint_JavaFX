/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import p1.connexion.services.ForumCRUD;

/**
 * FXML Controller class
 *
 * @author HP-PC
 */
public class StatController implements Initializable {

    @FXML
    private PieChart piechart;
    @FXML
    private Button btnretour;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
         ForumCRUD s = new ForumCRUD();
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("soft skills: " + s.calcul_soft(), s.calcul_soft()),
                new PieChart.Data("finance: " + s.calcul_finance(), s.calcul_finance()),
                new PieChart.Data("manangement: " + s.calcul_manangement(), s.calcul_manangement())
        );
        piechart.setData(pieChartData);
    }

    @FXML
    public void retour(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("FXML.fxml"));

        Parent root = loader.load();
        btnretour.getScene().setRoot(root);
    }
    
    
}
