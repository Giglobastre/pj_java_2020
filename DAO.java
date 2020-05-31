/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;


/**
 *
 * @author hugo7
 */
public abstract class DAO<T>{
    
    protected Connection connect=null;
    //private final Statement stmt;
    private ResultSet rset;
    private ResultSetMetaData rsetMeta;
    
    public DAO(){
            try {
                try {
                    Class.forName("org.mariadb.jdbc.Driver");
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
                }
                // db parameters - ptest is the name of the database
                String url = "jdbc:mariadb://localhost/pj_java2020";
                String user = "root";
                String password = "";
                // create a connection to the database
                connect = DriverManager.getConnection(url, user, password);
            }catch (SQLException err) {
                System.out.println(err.getMessage());
            } 
    }
      // public abstract T find(int id);
       public abstract void chargement(ArrayList<T> list);
}
