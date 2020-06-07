/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author hugo7
 */
public class GroupeDAO extends DAO<Groupe>{

    public GroupeDAO() {
        super();
    }
    
    
public void chargement(ArrayList<Groupe> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM groupe");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Groupe(rs.getInt("ID"),rs.getString("NOM")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
    
}
