/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.util.ArrayList;
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
public class SiteDAO extends DAO<Site> {

    public SiteDAO() {
        super();
    }

    public void chargement(ArrayList<Site> list)
    {

    try {
        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM site");
        ResultSet rs=stmt.executeQuery();
        
      while(rs.next())
      {
       list.add( new Site(rs.getInt("ID"),rs.getString("NOM")));
      }

    } catch (SQLException e) {
      e.printStackTrace();
    }
    
  }
}