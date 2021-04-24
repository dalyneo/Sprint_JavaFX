/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.entites;


/**
 *
 * @author ASUS
 */
public class Recruteur {
    private int id;
    private String nom;
    private String prenom;
    private String nomsociete;
    private String adresse;
    private String mail;
    private int numsociete;
    private String mdp;
    private String type;
    private String photo;
    private String competence;
    private int prix;

    public Recruteur() {
    }

    public Recruteur(String mail, String mdp) {
        this.mail = mail;
        this.mdp = mdp;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setNomsociete(String nomsociete) {
        this.nomsociete = nomsociete;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setNumsociete(int numsociete) {
        this.numsociete = numsociete;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public void setCompetence(String competence) {
        this.competence = competence;
    }

    public void setPrix(int prix) {
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNomsociete() {
        return nomsociete;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMail() {
        return mail;
    }

    public int getNumsociete() {
        return numsociete;
    }

    public String getMdp() {
        return mdp;
    }

    public String getType() {
        return type;
    }

    public String getPhoto() {
        return photo;
    }

    public String getCompetence() {
        return competence;
    }

    public int getPrix() {
        return prix;
    }
   
    
}
