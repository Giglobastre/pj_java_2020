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
public class CoursDAO extends DAO<Cours> {

    public CoursDAO() {
        super();
    }
    public Cours find(int id)
    {
     Cours cours = new Cours();      

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM cours WHERE ID="+id);
        ResultSet rs=stmt.executeQuery();
        
      if(rs.first())
        cours = new Cours(id,rs.getString("NOM"));

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return cours;
  }
    
    public void chargement(ArrayList<Cours> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM cours");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Cours(rs.getInt("ID"),rs.getString("NOM")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}
