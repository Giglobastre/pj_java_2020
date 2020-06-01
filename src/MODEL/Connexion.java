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
import projetjava.DAO;


public class Connexion {

    int m_IDgroupe,m_IDutil;
    private Connection m_co;
            
    public Connexion(){
        try {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            // db parameters - ptest is the name of the database
        String url = "jdbc:mariadb://localhost:3306/java2020";
        String user = "root";
        String password = "";
        // create a connection to the database
        m_co = DriverManager.getConnection(url, user, password);
        }catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }
    
    public boolean verif(String identifiant, String pwd){
        boolean testCo=false;
        final String sep="\\.";
        String prenomNom[]=identifiant.split(sep,2);
        String prenom=prenomNom[0];
        String nom=prenomNom[1];
        try {
        PreparedStatement stmt = m_co.prepareStatement("SELECT PASSWD FROM utilisateur WHERE NOM=? AND PRENOM=?");
        stmt.setString(1,prenom);
        stmt.setString(2,nom);
        ResultSet rs=stmt.executeQuery(); 
        while(rs.next()){
            if(rs.getString("PASSWD").equals(pwd)){
                testCo=true;
            }
        }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  testCo;
    }
    
    public int getM_IDgroupe() {
        return m_IDgroupe;
    }

    public int getM_IDutil() {
        return m_IDutil;
    }
}