 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 *
 * @author Nadia
 */
public class MyConnection {
    
    public String url="jdbc:mysql://127.0.0.1:3306/sprint2";
    public String user="root";
    public String mdp="";
    public static MyConnection instance;
    
    Connection cnx;
    public MyConnection(){
        
        try {
            
            Class.forName("com.mysql.jdbc.Driver");
            cnx = DriverManager.getConnection(url, user, mdp);
            System.out.println("Connexion etablie!");
            
            } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Erreur");
        }
    }
    
    public Connection getCnx(){
        return cnx;
    }

    public static MyConnection getInstance() {
        
        if(instance == null)
        {
            instance = new MyConnection();
        }
        return instance;
        
    }
    
    
    
    
}

