/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.cronjob;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Nadia
 */
public class CronJobExemple {
    
    
    public static void main(String[] args) {
        
        Timer timer = new Timer();
        TimerTask task = new MyTask();
        timer.schedule(task,0,1000);
    }
}
