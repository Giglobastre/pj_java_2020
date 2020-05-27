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


public class Connexion {

    /**
     * Attributs prives : connexion JDBC, statement, ordre requete et resultat
     * requete
     */
    private final Connection conn;
    private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    /**
     * ArrayList public 
     */
    
    /**
     * Constructeur avec 3 paramètres : nom, login et password de la BDD locale
     *
     * @param nameDatabase
     * @param loginDatabase
     * @param passwordDatabase
     * @throws java.sql.SQLException
     * @throws java.lang.ClassNotFoundException
     */
    public Connexion(String nameDatabase, String loginDatabase, String passwordDatabase) throws SQLException, ClassNotFoundException{
        // chargement driver "com.mysql.jdbc.Driver"
        Class.forName("com.mysql.jdbc.Driver");

        String urlDatabase = "jdbc:mysql://localhost:3308/pj_java2020";

        //création d'une connexion JDBC à la base 
        conn = DriverManager.getConnection(urlDatabase, loginDatabase, passwordDatabase);

        // création d'un ordre SQL (statement)
        stmt = conn.createStatement();
    }


    /**
     * Méthode qui ajoute la table en parametre dans son ArrayList
     *
     * @param table
     
    public void ajouterTable(String table) {
        tables.add(table);
    }*/

}