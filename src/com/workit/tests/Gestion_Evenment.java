/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workit.tests;

import com.workit.entities.Cat;
import com.workit.entities.Evenement;
import com.workit.services.CategorieCrud;
import com.workit.services.EvenementCrud;

/**
 *
 * @author Nadia
 */
public class Gestion_Evenment {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //MyConnection mc = new MyConnection(); 
    
    //Categorie c3 = new Categorie(6,"Embauche");
    EvenementCrud ec = new EvenementCrud();
    //Evenement e1 = new Evenement("na","coucou","2021-04-08","mail",c3);
    //Evenement e2 = new Evenement ("cc","dd","2021-03-06","mail@nadia",c3);
    CategorieCrud cc = new CategorieCrud();
    Cat c1 = new Cat("tunis");
    //Categorie c2 = new Categorie(9,"salma");
    
    
   
    //ec.addEvent(e1);
    //ec.addEvent(e2);
    //ec.DeleteEvent(42);
    //ec.UpdateEvent(e2);
    //ec.RechercheEvenement("cc");
    //cc.addCategorie(c);
    //cc.addCategorie2(c1);
    //cc.DeleteCategorie(10);
    //System.out.println(c1.getId());
    
    //cc.UpdateCategorie(c1);
    //cc.RechercheCategorie("Embauche");
    
    
    System.out.println(ec.showEvent());
    //System.out.println(cc.showCategorie());
        
    }
    
}
