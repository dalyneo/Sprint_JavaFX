/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.cronjob;

import java.sql.Date;
import java.util.TimerTask;

/**
 *
 * @author Nadia
 */
public class MyTask extends TimerTask {

 
    @Override
    public void run(){
        System.out.println(new Date());
        
    }
    
    
}
