/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.service;

import devit.workit.entities.Reclamation;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Wael Belhadj
 */
public interface IServiceReclamation {
     public void addrecla(Reclamation r);
    public List<Reclamation> AfficherRecla() throws SQLException;
     public boolean deleteRecruteur(Reclamation r) ;
}
