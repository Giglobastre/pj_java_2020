/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;
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
public class SeanceDAO extends DAO<Seance>{

    public SeanceDAO() {
        super();
    }
    
    
    public void chargement(ArrayList<Seance> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       
       list.add( new Seance(rs.getInt("ID"),rs.getInt("SEMAINE"),rs.getString("DATE"),rs.getString("HEURE_DEBUT"),rs.getString("HEURE_FIN"),rs.getInt("ETAT"),rs.getInt("ID_COURS"),rs.getInt("ID_TYPE")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}