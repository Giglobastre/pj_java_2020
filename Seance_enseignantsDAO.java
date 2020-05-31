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
public class Seance_enseignantsDAO extends DAO<Seance_enseignants> {

    public Seance_enseignantsDAO() {
        super();
    }
    
    public void chargement(ArrayList<Seance_enseignants> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_enseignant");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Seance_enseignants(rs.getInt("ID_SEANCE"),rs.getInt("ID_ENSEIGNANT")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
    
}
