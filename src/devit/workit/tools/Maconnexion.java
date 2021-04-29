/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wael Belhadj
 */
public class Maconnexion {
     final static String Url = "jdbc:mysql://127.0.0.1:3306/sprint1";
    final static String LOGIN= "root";
    final static String PWD = "";
    static Maconnexion instance = null;
    private Connection cnx;
    
    private Maconnexion(){
        try {
            cnx = DriverManager.getConnection(Url,LOGIN,PWD);
            System.out.println("connection etablie");
        } catch (SQLException ex) {
            Logger.getLogger(Maconnexion.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("connection error");
        }
        
    }
    
    public static Maconnexion getInstance()
    {
        if(instance==null)
            instance = new Maconnexion();
        
        return instance;
    }
    
    public Connection getConnection()
    {
        return cnx;
    }
    
    
}
