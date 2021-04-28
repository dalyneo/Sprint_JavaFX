/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.services;

import devit.workit.entities.Certificat;

import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author walid belhadj
 */
public interface IServiceCertificat {
      public void AjouterCertificat(Certificat c);
       public List<Certificat> AfficherCertificat() throws SQLException;
        public int SupprimerCertificat(int idd);
         public boolean ModifierCertificat(Certificat c) throws SQLException;
    
}
