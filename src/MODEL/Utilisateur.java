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
public class Utilisateur {
    private int ID;
    private String MAIL;
    private String PASSWD;
    private String NOM;
    private String PRENOM;
    private String DROIT;

    public Utilisateur() {
    }

    public Utilisateur(int ID, String MAIL, String PASSWD, String NOM, String PRENOM, String DROIT) {
        this.ID = ID;
        this.MAIL = MAIL;
        this.PASSWD = PASSWD;
        this.NOM = NOM;
        this.PRENOM = PRENOM;
        this.DROIT = DROIT;
    }

    public int getID() {
        return ID;
    }

    public String getNOM() {
        return NOM;
    }
    
    
}
