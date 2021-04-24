/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.services;

import devit.workit.entites.SessionWorkit;
import devit.workit.tools.MyConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author ASUS
 */
public class RecruteurCRUD {
    private Connection c = MyConnection.getInstance().getCnx();
    
     public boolean getPwdByUsername(String mail , String pwd) throws SQLException
     {
         try{
            String request="SELECT mdp FROM recruteur where mail='"+mail+"'";         
            Statement s=c.createStatement();
            ResultSet result=s.executeQuery(request);
          while(result.next())
           {
                if(result.getString("mdp").equals(pwd))
             {
              return true;
             }
           }
         
          
         }
        catch (SQLException ex)
        {
         System.out.println(ex);
        }
            return false;
    }
       public boolean userExist(String mail) throws SQLException
     {
                  
         try{
            String request="SELECT mail FROM recruteur where mail='"+mail+"'";         
            Statement s=c.createStatement();
            ResultSet result=s.executeQuery(request);
          while(result.next())
           {
               return true;
           }
          
         }
        catch (SQLException ex)
        {
         System.out.println(ex);
        }
            return false;
    }
    public boolean returnuser(String mail , String mdp)
    {
                 //SessionWorkit session = new SessionWorkit();
         try{
            String request="SELECT * FROM recruteur where mail='"+mail+"' AND mdp='"+mdp+"'";         
            Statement s=c.createStatement();
            ResultSet result=s.executeQuery(request);
          while(result.next())
           {
               SessionWorkit.setId(result.getInt("ID"));
               SessionWorkit.setNom(result.getString("nom"));
               SessionWorkit.setPrenom(result.getString("prenom"));
               SessionWorkit.setMail(result.getString("mail"));
               SessionWorkit.setMdp(result.getString("mdp"));
               SessionWorkit.setType(result.getString("type"));
               return true;
           }
          
         }
        catch (SQLException ex)
        {
         System.out.println(ex);
        }
         return false ;
    }
}
