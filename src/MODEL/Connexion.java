/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Connexion {

    int m_IDgroupe,m_IDutil, type;
    private Connection m_co;
            
    public Connexion(){
        try {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            // db parameters - ptest is the name of the database
        String url = "jdbc:mariadb://localhost:3306/pj_java2020";
        String user = "root";
        String password = "";
        // create a connection to the database
        m_co = DriverManager.getConnection(url, user, password);
        }catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    /**
         * verifie si les parametres entrés pour Nom.Prenom et mdp correspondent dans la bdd
         * 
         * @param identifiant, Nom.Prenom saisi
         * @param pwd, mot de passe entré par l'utilisateur
         * @return boolean qui definit si le mdp correspond au nom prenom
    */
    public boolean verif(String identifiant, String pwd){
        
        boolean testCo=false;
        
        if (identifiant.indexOf('.')!=-1){
            final String sep="\\.";
            String prenomNom[]=identifiant.split(sep,2);
            String prenom=prenomNom[0];
            String nom=prenomNom[1];
            try {
            PreparedStatement stmt = m_co.prepareStatement("SELECT PASSWD,DROIT FROM utilisateur WHERE NOM=? AND PRENOM=?");
            stmt.setString(1,prenom);
            stmt.setString(2,nom);
            ResultSet rs=stmt.executeQuery(); 
            while(rs.next()){
                if(rs.getString("PASSWD").equals(pwd)){
                    type=rs.getInt("DROIT");
                    testCo=true;
                }
            }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return  testCo;
    }
    
    /**
         * retourne l'id du nom prenom saisi
         * 
         * @param nomprenom, nom prenom saisi
         * @return id correspondant
    */
    public int getidco(String nomprenom){
        int id=0;
        final String sep="\\.";
        String prenomNom[]=nomprenom.split(sep,2);
        String prenom=prenomNom[0];
        String nom=prenomNom[1];
        try {
        PreparedStatement stmt = m_co.prepareStatement("SELECT ID FROM utilisateur WHERE NOM=? AND PRENOM=?");
        stmt.setString(1,prenom);
        stmt.setString(2,nom);
        ResultSet rs=stmt.executeQuery(); 
        while(rs.next()){
            id=rs.getInt("ID");
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  id;
    }
    
    public int getM_IDgroupe() {
        return m_IDgroupe;
    }

    public int getM_IDutil() {
        return m_IDutil;
    }

    public int getType() {
        return type;
    }
    
}