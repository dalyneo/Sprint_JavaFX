/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.entities;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Set;

/**
 *
 * @author HP-PC
 */
public class Forum implements Comparator<Forum> {
    private int id;
    private String sujet;
    private String probleme;
    private LocalDateTime date;
    private String theme;
    private String views = "1,2,3,";
    private int nviews;

    public int getNviews() {
        return views.split(",").length;
    }



    public Forum() {
        date=LocalDateTime.now();
    }

    public Forum(int id, String sujet, String probleme, String theme) {
        this.id = id;
        this.sujet = sujet;
        this.probleme = probleme;
     date=LocalDateTime.now();
     this.theme = theme;
    }

    public Forum(String sujet, String probleme, String theme) {
        this.sujet = sujet;
        this.probleme = probleme;
        this.theme = theme;
        date=LocalDateTime.now();
    }

    public String getViews() {
        return views;
    }

    public void setViews(String views) {
        this.views = views;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSujet() {
        return sujet;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
   

    public void setSujet(String sujet) {
        this.sujet = sujet;
    }

    public String getProbleme() {
        return probleme;
    }

    public void setProbleme(String probleme) {
        this.probleme = probleme;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "Forum{" + "id=" + id + ", sujet=" + sujet + ", probleme=" + probleme + ", date=" + date + ", theme=" + theme + '}';
    }

   @Override
    public int compare(Forum o1, Forum o2) {
        return o1.getTheme().compareTo(o2.getTheme());
    
    }

   
    
    
    
    
}
