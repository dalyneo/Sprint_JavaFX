/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.email;

/**
 *
 * @author Nadia
 */
public class JavaMail {
    
    public static void main(String[] args) throws Exception {
        
       JavaMailUtil.sendMail("noreplay.espritwork@gmail.com");
        
    }
    
}
