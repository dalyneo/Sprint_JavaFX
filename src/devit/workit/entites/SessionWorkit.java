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
public class SessionWorkit {
     private static int id ;
     private static String nom ;
     private static String prenom ;
     private static String mail ;
     private static String type ; 
     private static String mdp ;

    public SessionWorkit() {
    }

    public static void setId(int id) {
        SessionWorkit.id = id;
    }

    public static void setNom(String nom) {
        SessionWorkit.nom = nom;
    }

    public static void setPrenom(String prenom) {
        SessionWorkit.prenom = prenom;
    }

    public static void setMail(String mail) {
        SessionWorkit.mail = mail;
    }

    public static void setType(String type) {
        SessionWorkit.type = type;
    }

    public static void setMdp(String mdp) {
        SessionWorkit.mdp = mdp;
    }

    public static int getId() {
        return id;
    }

    public static String getNom() {
        return nom;
    }

    public static String getPrenom() {
        return prenom;
    }

    public static String getMail() {
        return mail;
    }

    public static String getType() {
        return type;
    }

    public static String getMdp() {
        return mdp;
    }
    
     
    
}
