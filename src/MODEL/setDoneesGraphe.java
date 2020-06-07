/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kenny-fixe
 */
public class setDoneesGraphe {
    
    private Connection m_co;
    private Admin admin;
    
    public setDoneesGraphe(Admin adm){
        admin=adm;
    }

    /**
         * cherche le nombre d'etudiants dans un td 
         * 
         * @param id, id du td duquel on dois trouver le nb d'etudiant
         * @return une nb d'etudiant dans le td
    */
    public int getTD(int id){
        int nb=0;
        try {
            PreparedStatement stmt = admin.getConnect().prepareStatement("SELECT COUNT(ID_GROUPE)FROM  etudiant WHERE ID_GROUPE=" + id);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                nb=rs.getInt("COUNT(ID_GROUPE)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nb;
    }
}
