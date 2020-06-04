/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.*;
import java.time.LocalDate;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;

/**
 *
 * @author hugo7
 */
public class Admin {

    protected Connection connect = null;
    //private final Statement stmt;
    //private ResultSet rset;
    //private ResultSetMetaData rsetMeta;

    public void connexion() {
        try {
            try {
                Class.forName("org.mariadb.jdbc.Driver");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            // db parameters - ptest is the name of the database
            String url = "jdbc:mariadb://localhost/pj_java2020";
            String user = "root";
            String password = "";
            // create a connection to the database
            connect = DriverManager.getConnection(url, user, password);
        } catch (SQLException err) {
            System.out.println(err.getMessage());
        }
    }

    public void enlevergrpensei(boolean bol, int idseance, int id) {
        try {
            int i = 0;
            int j=0;
            if (bol == true) {
                PreparedStatement stmt = connect.prepareStatement("SELECT ID_ENSEIGNANT FROM seance_enseignant WHERE ID_SEANCE=" + idseance);
                ResultSet rs = stmt.executeQuery();
                while (rs.next()) {
                    i++;
                    if (rs.getInt("ID_ENSEIGNANT") == id) {

                        PreparedStatement stmt2 = connect.prepareStatement("DELETE FROM seance_enseignant  WHERE ID_SEANCE=? AND ID_ENSEIGNANT=?");
                        stmt2.setInt(1, idseance);
                        stmt2.setInt(2, id);
                        ResultSet rs2 = stmt2.executeQuery();
                        j=1;
                    } 
                }
                if(j==0&&i!=0)
                 System.out.println("l'enseignang n'est pas affcter a cette sence de cours");
                    
                if (i == 0) {
                    System.out.println("seance pas trouver");
                }
            } else {
                PreparedStatement stmt = connect.prepareStatement("SELECT ID_GROUPE FROM seance_groupes WHERE ID_SEANCE=" + idseance);
                ResultSet rs = stmt.executeQuery();
                // PreparedStatement stmt1 = connect.prepareStatement("SELECT ID_COURS FROM seance WHERE ID ="+id);

                while (rs.next()) {
                    i++;
                    if (rs.getInt("ID_GROUPE") == id) {
                        //  System.out.println(idseance);
                        PreparedStatement stmt2 = connect.prepareStatement("DELETE FROM seance_groupes  WHERE ID_SEANCE=? AND ID_GROUPE=?");
                        stmt2.setInt(1, idseance);
                        stmt2.setInt(2, id);
                        ResultSet rs2 = stmt2.executeQuery();
                    } else {
                        System.out.println("le groupe n'est pas affcter a cette sence de cours");
                    }
                }
                if (i == 0) {
                    System.out.println("seance pas trouver");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void validerseance(int idseance) {
        try {
            int i = 0;
            PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + idseance);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                i++;
                System.out.println(rs.getInt("ID"));
                //System.out.println("l'enseignang n'est pas affcter a cette sence de cours");
                PreparedStatement stmt2 = connect.prepareStatement("UPDATE  seance SET ETAT=1  WHERE ID=" + idseance);
                ResultSet rs2 = stmt2.executeQuery();
            }
            if (i == 0) {
                System.out.println("seance pas trouver");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void annulerseance(int idseance) {
        try {
            int i = 0;
            PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + idseance);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                i++;
                System.out.println(rs.getInt("ID"));
                //System.out.println("l'enseignang n'est pas affcter a cette sence de cours");
                PreparedStatement stmt2 = connect.prepareStatement("UPDATE  seance SET ETAT=0  WHERE ID=" + idseance);
                ResultSet rs2 = stmt2.executeQuery();
            }
            if (i == 0) {
                System.out.println("seance pas trouver");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajoutergrp(int idseance, int idgroupe) {
        String date = "";
        String hd = "";
        int val = 0;
        try {
            int i = 0;
            int j = 0;
            int test = 0;
            int bon = 0;
            PreparedStatement stmt0 = connect.prepareStatement("SELECT * FROM seance WHERE ID=?");//on cherche les valeur de la seance
            stmt0.setInt(1, idseance);

            ResultSet rs0 = stmt0.executeQuery();
            while (rs0.next()) {
                i = 1;
                date = rs0.getString("DATE");
                hd = rs0.getString("HEURE_DEBUT");
                System.out.println(date + hd);

            }
            if (i == 1) {
                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM groupe WHERE ID=?");
                stmt11.setInt(1, idgroupe);

                ResultSet rs11 = stmt11.executeQuery();
                while (rs11.next()) {   //regarde si le td existe avec la variabel test
                    test++;
                }
                if (test > 0) {//si groupe existe 
                    PreparedStatement stmt1 = connect.prepareStatement("SELECT * FROM seance_groupes WHERE ID_SEANCE=?");
                    stmt1.setInt(1, idseance);
                    //stmt1.setInt(2,idgroupe);
                    ResultSet rs1 = stmt1.executeQuery();

                    while (rs1.next()) {

                        System.out.println("ff");
                        if (rs1.getInt("ID_GROUPE") == idgroupe) {//Si groupe deja affecter a cette seance
                            i = 3;
                            val = 1;
                            //  System.out.println("mmmmm");
                        }
                    } //si groupe pas attribue a cette seance.
                    System.out.println("kk");
                    if (val == 0) {
                        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_groupes WHERE ID_GROUPE=" + idgroupe);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {

                            //  System.out.println("mmmmm");
                            //System.out.println(rs.getInt("ID_SEANCE")+"g");
                            PreparedStatement stmt12 = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + rs.getInt("ID_SEANCE"));
                            ResultSet rs12 = stmt12.executeQuery();
                            while (rs12.next()) {
                                //i=1;
                                System.out.println(rs12.getString("DATE") + rs12.getString("HEURE_DEBUT"));
                                if (rs12.getString("DATE").equals(date) && rs12.getString("HEURE_DEBUT").equals(hd)) {//Si le td a deja cours
                                    j = 1;
                                } else {
                                    val = 3;
                                }
                            }
                        }
                    }
                    System.out.println(i);
                    System.out.println(val);
                    if (val == 1) {
                        System.out.println("peut pas");
                        i = 3;
                    }
                    if ((val == 3 || val == 0) && (j != 1)) {
                        PreparedStatement stmt2 = connect.prepareStatement("INSERT INTO seance_groupes (ID_SEANCE,ID_GROUPE) VALUES(?,?)");
                        stmt2.setInt(1, idseance);
                        stmt2.setInt(2, idgroupe);
                        ResultSet rs2 = stmt2.executeQuery();
                        System.out.println("add");

                    }
                    if (i == 3) {
                        System.out.println("Le groupe est deja affcter");
                    }
                    if (j == 1) {
                        System.out.println("Le groupe a deja cours");
                    }

                } else {
                    System.out.println("td exsite pas");
                }
            } else {
                System.out.println("La seance existe pas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajouterprof(int idseance, int idprof) {
        String date = "";
        String hd = "";
        int val = 0;
        try {
            int i = 0;
            int j = 0;
            int test = 0;
            int bon = 0;
            PreparedStatement stmt0 = connect.prepareStatement("SELECT * FROM seance WHERE ID=?");//on cherche les valeur de la seance
            stmt0.setInt(1, idseance);

            ResultSet rs0 = stmt0.executeQuery();
            while (rs0.next()) {
                i = 1;
                date = rs0.getString("DATE");
                hd = rs0.getString("HEURE_DEBUT");
                System.out.println(date + hd);

            }
            if (i == 1) {
                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM enseignant WHERE ID_UTILISATEUR=?");
                stmt11.setInt(1, idprof);

                ResultSet rs11 = stmt11.executeQuery();
                while (rs11.next()) {   //regarde si le td existe avec la variabel test
                    test++;
                }
                if (test > 0) {//si groupe existe 
                    PreparedStatement stmt1 = connect.prepareStatement("SELECT * FROM seance_enseignant WHERE ID_SEANCE=?");
                    stmt1.setInt(1, idseance);
                    //stmt1.setInt(2,idgroupe);
                    ResultSet rs1 = stmt1.executeQuery();

                    while (rs1.next()) {

                        System.out.println("ff");
                        if (rs1.getInt("ID_ENSEIGNANT") == idprof) {//Si groupe deja affecter a cette seance
                            i = 3;
                            val = 1;
                            //  System.out.println("mmmmm");
                        }
                    } //si groupe pas attribue a cette seance.
                    System.out.println("kk");
                    if (val == 0) {
                        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_enseignant WHERE ID_ENSEIGNANT=" + idprof);
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {

                            //  System.out.println("mmmmm");
                            //System.out.println(rs.getInt("ID_SEANCE")+"g");
                            PreparedStatement stmt12 = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + rs.getInt("ID_SEANCE"));
                            ResultSet rs12 = stmt12.executeQuery();
                            while (rs12.next()) {
                                //i=1;
                                System.out.println(rs12.getString("DATE") + rs12.getString("HEURE_DEBUT"));
                                if (rs12.getString("DATE").equals(date) && rs12.getString("HEURE_DEBUT").equals(hd)) {//Si le td a deja cours
                                    j = 1;
                                } else {
                                    val = 3;
                                }
                            }
                        }
                    }
                    System.out.println(i);
                    System.out.println(val);
                    if (val == 1) {
                        System.out.println("peut pas");
                        i = 3;
                    }
                    if ((val == 3 || val == 0) && (j != 1)) {
                        PreparedStatement stmt2 = connect.prepareStatement("INSERT INTO seance_enseignant (ID_SEANCE,ID_ENSEIGNANT) VALUES(?,?)");
                        stmt2.setInt(1, idseance);
                        stmt2.setInt(2, idprof);
                        ResultSet rs2 = stmt2.executeQuery();
                        System.out.println("add");

                    }
                    if (i == 3) {
                        System.out.println("Le gprof est deja affcter");
                    }
                    if (j == 1) {
                        System.out.println("Le prof a deja cours");
                    }

                } else {
                    System.out.println("le prof exsite pas");
                }
            } else {
                System.out.println("La seance existe pas");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void ajoutseeance(String date, String hd, int etat, int idcours, int idtype, int idprof, int idgroupe) {
        try {
            final String SEPARATEUR = "/";
            String conte = date;
            int semaine = 51;
            String mots[] = conte.split(SEPARATEUR);
            int jour = Integer.parseInt(mots[0]);
            int mois = Integer.parseInt(mots[1]);
            int annee = Integer.parseInt(mots[2]);
            LocalDate localDate = LocalDate.of(annee, mois, jour);
            java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            if (dayOfWeek.equals(localDate.getDayOfWeek().SATURDAY) || dayOfWeek.equals(localDate.getDayOfWeek().SUNDAY)) {
                System.out.println("pas possible");
            } else {
                PreparedStatement stmt = connect.prepareStatement("INSERT INTO seance (SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE) VALUES(?,?,?,?,?,?,?)");
                stmt.setInt(1, semaine);
                stmt.setString(2, date);
                stmt.setString(3, hd);
                stmt.setString(4, "10:11");
                stmt.setInt(5, etat);
                stmt.setInt(6, idcours);
                stmt.setInt(7, idtype);
                ResultSet rs = stmt.executeQuery();
                PreparedStatement stmt1 = connect.prepareStatement("SELECT* FROM seance WHERE(DATE=? AND HEURE_DEBUT=? AND ID_COURS=?)");
                stmt1.setString(1, date);
                stmt1.setString(2, hd);
                stmt1.setInt(3, idcours);
                ResultSet rs1 = stmt1.executeQuery();
                while (rs1.next()) {
                    ajouterprof(rs1.getInt("ID"), idprof);
                    ajoutergrp(rs1.getInt("ID"), idgroupe);
                }
                //ajouterprof()
                System.out.println("add");

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
