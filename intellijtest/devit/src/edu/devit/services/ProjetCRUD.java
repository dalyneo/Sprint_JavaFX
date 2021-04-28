package edu.devit.services;


import edu.devit.entities.Freelancer;
import edu.devit.entities.Projet;
import edu.devit.tools.MyConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProjetCRUD {
    public void addProjet(Projet p) {
        try {
            String requete = "INSERT INTO projet (nom_projet,projet_description,job_type,job_salary,job_time,logo) "
                    + "VALUES ('" + p.getNom_projet() + "','" + p.getProjet_description() + "','" + p.getJob_type() + "','" + p.getJob_salary() + "','" + p.getJob_time() + "','" + p.getLogo() + "')";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            st.executeUpdate(requete);
            System.out.println("Projet ajoutée!");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public List<Projet> getProjets(){
        List<Projet> myList = new ArrayList();
        try {
            String requete = "SELECT * FROM projet";
            Statement st = MyConnection.getInstance().getCnx().createStatement();
            ResultSet rs = st.executeQuery(requete);
            while(rs.next()){
                Projet p = new Projet();
                p.setId(rs.getInt(1));
                p.setUser_id(rs.getInt("user_id"));
                p.setNom_projet(rs.getString("nom_projet"));
                p.setProjet_description(rs.getString("projet_description"));
                p.setJob_type(rs.getString("job_type"));
                p.setJob_salary(rs.getString("job_salary"));
                p.setJob_time(rs.getString("job_time"));
                p.setLogo(rs.getString("logo"));
                myList.add(p);
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return myList;
    }
    public ObservableList<Projet> showProjet(){
        Connection cnx =null;
        Statement st = null;
        ResultSet rs = null;
        ObservableList<Projet> liste = FXCollections.observableArrayList();
        String requette = "SELECT * FROM projet";

        try {
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();
            rs = st.executeQuery(requette);
            Projet projets;
            while (rs.next()){
                projets = new Projet(rs.getInt("id"),rs.getString("nom_projet"), rs.getString("projet_description"),rs.getString("job_type"), rs.getString("job_salary"), rs.getString("job_time"), rs.getString("logo"));
               projets.setUser_id(rs.getInt("user_id"));
                liste.add(projets);
            }


        } catch (SQLException ex) {
            ex.printStackTrace();
        }finally {
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) { /* Ignored */}
            }
            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
        return liste;

    }

    public boolean updateProjet(Projet p){
        Connection cnx =null;
        Statement st = null;
        String requette = "UPDATE Projet SET nom_projet='"+p.getNom_projet()+"',projet_description ='"+p.getProjet_description()+"',job_type='"+p.getJob_type()+"',job_salary='"+p.getJob_salary()+"',job_time ='"+p.getJob_time()+ "',logo ='"+p.getLogo()+ "' WHERE id='"+p.getId()+"'";
        try {
            cnx = MyConnection.getInstance().getCnx();
            st = cnx.createStatement();
            st.executeUpdate(requette);
            return true;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally {

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }}
    public boolean deleteprojet(Projet p){ // naadeha paramétre
        Connection cnx =null;
        Statement st = null;
        String requette = "DELETE FROM projet WHERE id="+p.getId()+"";
        try {
            cnx = MyConnection.instance.getCnx();
            st = cnx.createStatement();
            st.executeUpdate(requette);
            return true;


        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }finally {

            if (st != null) {
                try {
                    st.close();
                } catch (SQLException e) { /* Ignored */}
            }
        }
    }

}
