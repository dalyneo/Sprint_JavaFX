 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package devit.workit.services;

import devit.workit.entities.Test;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author walid belhadj
 */
public interface IServiceTest {
     public void AjouterTest(Test t);
      public List<Test> AfficherTest() throws SQLException;
      public int SupprimerTest(int idd);
      public boolean ModifierTest(Test t) throws SQLException;
      public Test rechercherTest(String nom);
    
}
