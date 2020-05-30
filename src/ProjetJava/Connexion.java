/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;

/*
 * 
 * Librairies importées
 */
import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import projetjava.DAO;


public class Connexion {

    int m_IDgroupe,m_IDutil;
            
    public Connexion(){
        try {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            // db parameters - ptest is the name of the database
            String url = "jdbc:mariadb://localhost/java2020";
            String user = "root";
            String password = "";
            // create a connection to the database
        Connection connect = DriverManager.getConnection(url, user, password);
        }catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public int getM_IDgroupe() {
        return m_IDgroupe;
    }

    public int getM_IDutil() {
        return m_IDutil;
    }
    
    

}