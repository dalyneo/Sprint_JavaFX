/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.entities;

/**
 *
 * @author Nadia
 */
public class Evenement {

    int id;
    String nom;
    String date;
    String description;

    String email;
    
    
    Categorie idcategorie_id;

    public Evenement() {
    }
    
     public Evenement( String nom, String description, String date, String email, Categorie idcategorie_id) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.email = email;
        this.idcategorie_id = idcategorie_id;
    }

    public Evenement(int id, String nom, String description, String date, String email, Categorie idcategorie_id) {
        this.nom = nom;
        this.description = description;
        this.date = date;
        this.email = email;
        this.idcategorie_id = idcategorie_id;
    }

    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public String getEmail() {
        return email;
    }

    public Categorie getIdcategorie_id() {
        return idcategorie_id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {

        this.nom = nom;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdcategorie_id(Categorie idcategorie_id) {
        this.idcategorie_id = idcategorie_id;
    }

    @Override
    public String toString() {
        return "Event{" + "nom=" + nom + ", description=" + description + ", date=" + date + ", email=" + email + ", idcategorie_id=" + idcategorie_id + '}';
    }

}
