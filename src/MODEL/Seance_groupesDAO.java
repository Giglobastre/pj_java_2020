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
public class Seance_groupesDAO extends DAO<Seance_groupes>{

    public Seance_groupesDAO() {
        super();
    }
    
    /**
         * met tout les seance_groupes de la db dans une arraylist
         * 
         * @param list, arraylist vide
         * @return une arraylist de seance_groupe
    */
    public void chargement(ArrayList<Seance_groupes> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_groupes");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Seance_groupes(rs.getInt("ID_SEANCE"),rs.getInt("ID_GROUPE")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}
    

