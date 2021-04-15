/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gestionevenement.email;

import java.net.PasswordAuthentication;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import java.lang.Exception;
import javax.mail.Session;
import javax.mail.Transport;
//import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;



/**
 *
 * @author Nadia
 */



public class JavaMailUtil {

    public static void sendMail(String recepient) throws Exception {
        
        System.out.println("preparing to send email");
        Properties prop = new Properties();
        
        prop.put("mail.smtp.auth", "true");
        prop.put("mail.smtp.starttls.enable", "true");
        prop.put("mail.smtp.host", "smtp.gmail.com");
        prop.put("mail.smtp.port", "587");
        
        String MyEmail = "noreplay.espritwork@gmail.com" ;
        String password = "esprit12";
       
       Session session = Session.getInstance(prop, new Authenticator() {
            @Override
            protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
                //return super.getPasswordAuthentication(); //To change body of generated methods, choose Tools | Templates.
                return new javax.mail.PasswordAuthentication(MyEmail, password);
            }
           
       });
        
        Message msg = prepareMessage(session , MyEmail , recepient);
        
        Transport.send(msg);
        
        System.out.println("message sent successfully");
        
    }

    private static Message prepareMessage(Session session , String MyEmail , String recepient) {
        
        try {
            Message msg = new MimeMessage(session);
            msg.setFrom(new InternetAddress(MyEmail));
            msg.setRecipient(Message.RecipientType.TO, new InternetAddress(recepient));
            msg.setSubject("first email");
            msg.setText("hey there . ");
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
       return null; 
    }
	
    
}
