/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.service;

import devit.workit.entities.Recruteur;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wael Belhadj
 */
public interface IServiceRecruteur {
     public void addrec(Recruteur r);
    public List<Recruteur> AfficherRecruteur() throws SQLException;
    public boolean updateRecruteur(Recruteur r) throws SQLException;
     public boolean deleteRecruteur(Recruteur r) ;
      public Recruteur rechercherRec(String nom);
    
    
}
