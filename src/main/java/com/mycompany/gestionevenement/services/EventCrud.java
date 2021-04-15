/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.services;
import com.mycompany.gestionevenement.entities.Categorie;
import com.mycompany.gestionevenement.entities.Evenement;
import com.mycompany.gestionevenement.tools.MyConnection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


/**
 *
 * @author Nadia
 */
public class EventCrud {
    
    public void addEvent(Evenement e ){
        
        String requete = "INSERT INTO evenement (nom,date,description,email,idcategorie_id) VALUES ('"+ e.getNom() +"','"+ e.getDate() +"','"+ e.getDescription()+"','"+ e.getEmail() +"','"+ e.getIdcategorie_id().getId() +"' )" ; 
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Evenement ajoute!");
        } catch (SQLException ex) {
           System.out.println(ex.getMessage());
        }
        
    }
    
    
        public List<Evenement> showEvent() {

        List<Evenement> listC = new ArrayList();
        String requete = "SELECT * FROM evenement";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Evenement e = new Evenement();
                e.setId(rs.getInt(1));
                e.setNom(rs.getString("nom"));
                e.setDate(rs.getString("date"));
                e.setDescription(rs.getString("description"));
                e.setEmail(rs.getString("email"));
                
                listC.add(e);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listC;

    }



 public void DeleteEvent(int id) {

        String requete = "DELETE FROM evenement  WHERE id='" + id + "'";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Evenement supprime!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
 
  public void UpdateEvent(Evenement e){
        
        String requete = "UPDATE evenement SET nom=?, date=?, description=?, email=? "+" WHERE id = " + e.getId();
        
        try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            
            pst.setString(1, e.getNom());
            pst.setString(2, e.getDate());
            pst.setString(3, e.getDescription());
            pst.setString(4, e.getEmail());
            
            pst.executeUpdate();
            
            System.out.println("Evenement modifie!");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
  
  
  
  public List<Evenement> RechercheEvenement(String nom) {
       
         
         
         List<Evenement> listE = new ArrayList<>();
         
        try {
            
            Evenement e = new Evenement();
            
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            
            String requete = "SELECT * FROM categorie WHERE nom = '"+nom+"%'";
            
            System.out.println("Evenement trouve!");
            
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                
                e.setId(rs.getInt(1));
                e.setNom(rs.getString("nom"));
                
                listE.add(e);

            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listE;

    }
 
 
}
