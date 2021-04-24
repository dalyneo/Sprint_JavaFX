/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.services;

import devit.workit.entites.Offre;
import devit.workit.entites.Postuler;
import devit.workit.tools.MyConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author ASUS
 */
public class PostulerCRUD {
     private Connection c = MyConnection.getInstance().getCnx();
    public ObservableList<Postuler> ShowPostuler() throws SQLException {
        ObservableList<Postuler> list = FXCollections.observableArrayList();
        String requete = "SELECT * FROM `postuler` ";
        try {
            PreparedStatement ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                list.add(new Postuler(rs.getInt("ID"),rs.getInt("offre_id"), rs.getInt("recruteur_id"), rs.getString("accepte")));

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return list;

    }
    public boolean Supprimer(int t) throws SQLException {

        String requete = "DELETE FROM postuler WHERE recruteur_id="+t;
        try {

            PreparedStatement pst =  MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.execute(requete);
             return true ;
        } catch (SQLException ex) {
          //  System.out.println(ex.getMessage());
             return false ;
        }

    }
    public int returnOffre(int id){
               int nb = 0 ;
        String requete = "SELECT * FROM postuler WHERE offre_id="+id;
        try {
             PreparedStatement ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = ps.executeQuery(requete);
            while(rs.next()) {
                nb++ ;
            }
        } catch (SQLException ex) {
        }
        return nb;
    } 
     public int returnvalid(int idrec , int idoff){
         int nb = 0 ;
        String requete = "SELECT * FROM postuler where offre_id='"+idoff+"' AND recruteur_id='"+idrec+"'";
        
        try {
             PreparedStatement ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = ps.executeQuery(requete);
            while(rs.next()) {
                nb = 1 ;
            }
        } catch (SQLException ex) {
        }
        return nb;
    } 
     public int returnRec(int id){
               int nb = 0 ;
        String requete = "SELECT * FROM postuler WHERE recruteur_id="+id;
        try {
             PreparedStatement ps = MyConnection.getInstance().getCnx().prepareStatement(requete);
            ResultSet rs = ps.executeQuery(requete);
            while(rs.next()) {
                nb = rs.getInt("recruteur_id");
            }
        } catch (SQLException ex) {
        }
        return nb;
    } 
    public void addPost(Postuler p) throws SQLException{
        try {
            String requete = "INSERT INTO postuler (offre_id,recruteur_id)"
                    + "VALUES (?,?)";
            PreparedStatement pst =
                    MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setInt(1, p.getOffre_id());
            pst.setInt(2, p.getRecruteur_id());
            pst.executeUpdate();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
}
