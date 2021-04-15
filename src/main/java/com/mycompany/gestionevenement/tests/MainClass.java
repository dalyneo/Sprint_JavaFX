/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.tests;

import com.mycompany.gestionevenement.entities.Categorie;
import com.mycompany.gestionevenement.entities.Evenement;
import com.mycompany.gestionevenement.services.EventCrud;
import com.mycompany.gestionevenement.tools.MyConnection;
import com.mycompany.gestionevenement.services.CategorieCrud;


/**
 *
 * @author Nadia
 */
public class MainClass {
    
public static void main(String[] args){
    
    //MyConnection mc = new MyConnection(); 
    
    Categorie c3 = new Categorie(6,"Embauche");
    EventCrud ec = new EventCrud();
    //Evenement e1 = new Evenement("nad","vv","2007-03-06","mail",c3);
    Evenement e2 = new Evenement ("cc","dd","2021-03-06","mail@nadia",c3);
    CategorieCrud cc = new CategorieCrud();
    //Categorie c1 = new Categorie("saaaannn");
    //Categorie c2 = new Categorie(9,"salma");
    
    
    
    //ec.addEvent(e1);
    //ec.addEvent(e2);
    //ec.DeleteEvent(42);
    //ec.UpdateEvent(e2);
    //ec.RechercheEvenement("cc");
    //cc.addCategorie(c);
    //cc.addCategorie2(c1);
    //cc.DeleteCategorie(8);
    //cc.UpdateCategorie(c2);
    //cc.RechercheCategorie("Embauche");
    
    
    //System.out.println(ec.showEvent());
    System.out.println(cc.showCategorie());
     
    
}
    
}
