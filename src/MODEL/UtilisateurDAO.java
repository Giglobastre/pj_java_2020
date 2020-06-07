/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author hugo7
 */
public class UtilisateurDAO extends DAO<Utilisateur>{

    public UtilisateurDAO() {
        super();
    }  
    
    /**
         * met tout les utilisateurs de la db dans une arraylist
         * 
         * @param list, arraylist vide
         * @return une arraylist d'utilisateurs
    */
    public void chargement(ArrayList<Utilisateur> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM utilisateur");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Utilisateur(rs.getInt("ID"),rs.getString("EMAIL"),rs.getString("PASSWD"),rs.getString("NOM"),rs.getString("PRENOM"),rs.getString("DROIT")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}

