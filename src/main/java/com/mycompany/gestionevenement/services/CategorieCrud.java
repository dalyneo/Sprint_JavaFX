/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.services;

import com.mycompany.gestionevenement.entities.Categorie;
import com.mycompany.gestionevenement.tools.MyConnection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Nadia
 */
public class CategorieCrud {

    public void addCategorie(Categorie c) {

        String requete = "INSERT INTO categorie (nom) VALUES ('" + c.getNom() + "' )";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Categorie ajoute!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }

    public void addCategorie2(Categorie c) {

        String requete = "INSERT INTO categorie (nom ) " + " VALUES (?)";
        try {
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.executeUpdate();
            System.out.println("Categorie ajoute!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public List<Categorie> showCategorie() {

        List<Categorie> listC = new ArrayList();
        String requete = "SELECT * FROM categorie";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while (rs.next()) {
                Categorie c = new Categorie();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString("nom"));
                listC.add(c);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return listC;

    }

    public void DeleteCategorie(int id) {

        String requete = "DELETE FROM categorie  WHERE id='" + id + "'";
        try {
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("categorie supprime!");

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }

    }
    
    public void UpdateCategorie(Categorie c){
        
        String requete = "UPDATE categorie SET nom=?"+" WHERE id = " + c.getId();
        
        try {
            
            PreparedStatement pst = MyConnection.getInstance().getCnx().prepareStatement(requete);
            pst.setString(1, c.getNom());
            pst.executeUpdate();
            System.out.println("categorie modifie!");
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    
    
     public List<Categorie> RechercheCategorie(String nom) {
       
         
         
         List<Categorie> listC = new ArrayList<>();
         String requete;
         requete = "SELECT * FROM categorie  WHERE nom = ' "+ nom +" ' ";
         
        try {

            Statement st = MyConnection.getInstance().getCnx().createStatement();
            System.out.println("Categorie trouve!");
            ResultSet rs = st.executeQuery(requete);
            
            while (rs.next()) {
                
                Categorie c = new Categorie();
                c.setId(rs.getInt(1));
                c.setNom(rs.getString("nom"));
                
                listC.add(c);

            }
            
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return listC;

    }
     
     
}
