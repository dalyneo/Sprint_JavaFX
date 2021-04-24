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
public class staticEntity {
    private static int id ;
     private static String nom ;
      private static String description ;
       private static int views ;
       private static String image ;

    public static void setImage(String image) {
        staticEntity.image = image;
    }

    public static String getImage() {
        return image;
    }

    public static String getNom() {
        return nom;
    }

    public static String getDescription() {
        return description;
    }

    public static int getViews() {
        return views;
    }

    public static void setNom(String nom) {
        staticEntity.nom = nom;
    }

    public static void setDescription(String description) {
        staticEntity.description = description;
    }

    public static void setViews(int views) {
        staticEntity.views = views;
    }

    public staticEntity() {
    }

    public static int getId() {
        return id;
    }

    public static void setId(int id) {
        staticEntity.id = id;
    }
    
}
