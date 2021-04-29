/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.workit.sms;

import com.teknikindustries.bulksms.SMS;
import java.net.URLEncoder;

import com.twilio.Twilio; 
import com.twilio.converter.Promoter; 
import com.twilio.rest.api.v2010.account.Message; 
import com.twilio.type.PhoneNumber;


/**
 *
 * @author Nadia
 */
public class SmsClass {
    
    
      public static final String ACCOUNT_SID = "AC9ad6df7c31f94ce7702ac69094e9c0dd"; 
    public static final String AUTH_TOKEN = "596fcdb68f60ea8e85b5151cfbc68bf4";
    
    
    
    
    public static void main(String[] args) {
        
        
        
        System.out.println("preparing to send sms");

  
    
      
              SMS send = new SMS();
        send.SendSMS("nadd", "Syrine2003", "coucou", "+21656239162", "https://bulksms.vsms.net/eapi/submission/send_sms/2/2.0");
        
        System.out.println("sms is sent");
    }
  
    
}
