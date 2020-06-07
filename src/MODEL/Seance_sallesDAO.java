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
/**
 *
 * @author hugo7
 */
public class Seance_sallesDAO extends DAO<Seance_salles>{

    public Seance_sallesDAO() {
    }
    public void chargement(ArrayList<Seance_salles> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_salle");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Seance_salles(rs.getInt("ID_SEANCE"),rs.getInt("ID_SALLE")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
    
}



