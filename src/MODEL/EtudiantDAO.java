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
public class EtudiantDAO extends DAO<Etudiant> {

    public EtudiantDAO() {
        super();
    }
    
    /**
         * met tout les etudiants de la db dans une arraylist
         * 
         * @param list, arraylist vide
         * @return une arraylist d'etudiants
    */
    public void chargement(ArrayList<Etudiant> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM etudiant");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Etudiant(rs.getInt("ID_UTILISATEUR"),rs.getInt("NUMERO"),rs.getInt("ID_GROUPE")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}