/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package p1.connexion.tests;

import p1.connexion.entities.Forum;
import p1.connexion.services.ForumCRUD;
import p1.connexion.tools.MyConnection;

/**
 *
 * @author HP-PC
 */
public class MainClass {
    public static void main(String[] args) {
      //  MyConnection mc = new MyConnection();
      ForumCRUD pc = new ForumCRUD ();
      Forum p =new Forum("nadia","abd","koukou");
      pc.addPerson2(p);
       // System.out.println(pc.getForum());
      
      
      
    }
    
}
