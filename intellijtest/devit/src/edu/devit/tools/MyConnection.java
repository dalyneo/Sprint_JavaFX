package edu.devit.tools;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MyConnection {
    public  String url = "jdbc:mysql://localhost:3306/sprint1";
    public String user ="root";
    public String pwd = "";
    public static MyConnection instance;

     Connection cnx;

    private MyConnection(){ //private bech maach najem naayetlouu lbara
        try {
            cnx = DriverManager.getConnection(url, user, pwd);
            System.out.println("Connexion établie!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public Connection getCnx() {
        return cnx;
    }

    public static MyConnection getInstance() {
        if(instance == null){
            instance = new MyConnection();
        }
        return instance;
    }
    }

