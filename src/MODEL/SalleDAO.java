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
public class SalleDAO extends DAO<Salle>{

    public SalleDAO() {
        super();
    }
    
    /**
         * met toutes les salles de la db dans une arraylist
         * 
         * @param list, arraylist vide
         * @return une arraylist de salles
    */
    public void chargement(ArrayList<Salle> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM salle");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Salle(rs.getInt("ID"),rs.getString("NOM"),rs.getInt("CAPACITE"),rs.getInt("ID_SITE")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
    
}


