/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

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

    public Admin() {
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

    public int enlevergrpensei(boolean bol, int idseance, int id) {
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
                {
                 System.out.println("l'enseignang n'est pas affcter a cette sence de cours");
                    return 1;}
                if (i == 0) {
                    System.out.println("seance pas trouver");
                    return 0;
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
                        return 1;
                    }
                }
                if (i == 0) {
                    System.out.println("seance pas trouver");
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 2;
    }

    public int validerseance(int idseance) {
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
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int annulerseance(int idseance) {
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
                return 0;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 1;
    }

    public int ajoutergrp(int idseance, int idgroupe) {
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
                        return 10;

                    }
                    if (i == 3) {
                        System.out.println("Le groupe est deja affcter");
                        return 0;
                    }
                    if (j == 1) {
                        System.out.println("Le groupe a deja cours");
                        return 1;
                    }

                } else {
                    System.out.println("td exsite pas");
                    return 2;
                }
            } else {
                System.out.println("La seance existe pas");
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 4;
    }

    public int ajouterprof(int idseance, int idprof) {
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
                        return 10;
                    }
                    if (i == 3) {
                        System.out.println("Le prof est deja affcter");
                        return 0;
                    }
                    if (j == 1) {
                        System.out.println("Le prof a deja cours");
                        return 1;
                    }

                } else {
                    System.out.println("le prof exsite pas");
                    return 2;
                }
            } else {
                System.out.println("La seance existe pas");
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 4;
    }

    public int ajoutseeance(String date, String hd, int etat, int idcours, int idtype, ArrayList<Integer> idprof, ArrayList<Integer> idgroupe, ArrayList<Integer> idsalle) {
        if ((verifarrayidprof(idprof) == true) && (verifarrayidgrp(idgroupe) == true) && (verifarrayidsalle(idsalle) == true)) {
            try {
                int ids=0;
                int condition = 0;
                final String SEPARATEUR = "/";
                String conte = date;
                int semaine = 51;
                String mots[] = conte.split(SEPARATEUR);
                int jour = Integer.parseInt(mots[0]);
                int mois = Integer.parseInt(mots[1]);
                int annee = Integer.parseInt(mots[2]);
                LocalDate localDate = LocalDate.of(annee, mois, jour);
                java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
                if ((dayOfWeek.equals(localDate.getDayOfWeek().SATURDAY) || dayOfWeek.equals(localDate.getDayOfWeek().SUNDAY)) || ((hd.equals("08:30") == false) && (hd.equals("10:15") == false) && (hd.equals("12:00") == false) && (hd.equals("13:45") == false) && (hd.equals("15:30") == false) && (hd.equals("17:15") == false) && (hd.equals("19:00") == false))) {
                    System.out.println("pas possible");
                    return 6;
                } else {

                    for (int i = 0; i < idprof.size(); i++) {
                        if (testdispoprof(idprof.get((i)), date, hd) == false) {
                            condition = 1;
                        }

                    }
                    for (int i = 0; i < idgroupe.size(); i++) {
                        if (testdispogrp(idgroupe.get((i)), date, hd) == false) {
                            //System.out.println(testdispogrp(idgroupe.get((i)), date, hd));

                            condition = 2;
                        }
                    }
                    for (int i = 0; i < idsalle.size(); i++) {
                        if (disposalle(idsalle.get(i), date, hd) == false) {
                            condition = 3;
                        }
                    }
                    if (testcapacite0(idgroupe, idsalle) == true) {
                        if (condition != 1 && condition != 2 && condition != 3) {
                            PreparedStatement stmt = connect.prepareStatement("INSERT INTO seance (SEMAINE,DATE,HEURE_DEBUT,HEURE_FIN,ETAT,ID_COURS,ID_TYPE) VALUES(?,?,?,?,?,?,?)");
                            stmt.setInt(1, semaine);
                            stmt.setString(2, date);
                            stmt.setString(3, hd);
                            stmt.setString(4, "10:11");
                            stmt.setInt(5, etat);
                            stmt.setInt(6, idcours);
                            stmt.setInt(7, idtype);//test capacite validité
                            ResultSet rs = stmt.executeQuery();
                            ids=chercheid();
                                for (int i = 0; i < idprof.size(); i++) {
                                    ajouterprof(ids, idprof.get(i));
                                }
                                for (int i = 0; i < idgroupe.size(); i++) {
                                    ajoutergrp0(ids, idgroupe.get(i));
                                }
                                for (int i = 0; i < idsalle.size(); i++) {
                                    ajoutesalle(ids, idsalle.get(i));
                                }
                                //ajoutesalle(rs1.getInt("ID"), idsalle);
                            
                            //ajouterprof()
                            System.out.println("add");
                            return 20;
                        }
                        if (condition == 1) {
                            System.out.println("Un prof n'est pas disponible");
                            return 0;
                        }
                        if (condition == 3) {
                            System.out.println("Salle pas disponible");
                            return 3;
                        }
                        if (condition == 2) {
                            System.out.println("Un groupe n'est pas disponible");
                            return 2;
                        }
                    } else {
                        System.out.println("salle trop petite");
                        return 4;
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("valeur non reconnue");
            return 5;
        }
        return 20;
    }
    
    public int ajoutesalle(int idseance, int idsalle) {
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
                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM salle WHERE ID=?");
                stmt11.setInt(1, idsalle);

                ResultSet rs11 = stmt11.executeQuery();
                while (rs11.next()) {   //regarde si le td existe avec la variabel test
                    test++;
                }
                if (test > 0) {//si groupe existe 
                    PreparedStatement stmt1 = connect.prepareStatement("SELECT * FROM seance_salle WHERE ID_SEANCE=?");
                    stmt1.setInt(1, idseance);
                    //stmt1.setInt(2,idgroupe);
                    ResultSet rs1 = stmt1.executeQuery();

                    while (rs1.next()) {

                        System.out.println("ff");
                        if (rs1.getInt("ID_SALLE") == idsalle) {//Si groupe deja affecter a cette seance
                            i = 3;
                            val = 1;
                            //  System.out.println("mmmmm");
                        }
                    } //si groupe pas attribue a cette seance.
                    System.out.println("kk");
                    if (val == 0) {
                        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_salle WHERE ID_SALLE=" + idsalle);
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
                        PreparedStatement stmt2 = connect.prepareStatement("INSERT INTO seance_salle (ID_SEANCE,ID_SALLE) VALUES(?,?)");
                        stmt2.setInt(1, idseance);
                        stmt2.setInt(2, idsalle);
                        ResultSet rs2 = stmt2.executeQuery();
                        System.out.println("add");
                        return 10;

                    }
                    if (i == 3) {
                        System.out.println("La salle est deja affcter");
                        return 0;
                    }
                    if (j == 1) {
                        System.out.println("La salle est pas dispo");
                        return 1;
                    }

                } else {
                    System.out.println("salle exsite pas");
                    return 2;
                }
            } else {
                System.out.println("La seance existe pas");
                return 3;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 4;
    }
    
    public int deplacerceance(String date, String hd, int idseance) {
        try {
            int i = 0;
            int val = 0;
            int j = 0;
            int jj = 0;
            final String SEPARATEUR = "/";
            String conte = date;
            int semaine = 51;
            String mots[] = conte.split(SEPARATEUR);
            int jour = Integer.parseInt(mots[0]);
            int mois = Integer.parseInt(mots[1]);
            int annee = Integer.parseInt(mots[2]);
            LocalDate localDate = LocalDate.of(annee, mois, jour);
            java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
            System.out.println(dayOfWeek);
            if ((dayOfWeek.equals(localDate.getDayOfWeek().SATURDAY) || dayOfWeek.equals(localDate.getDayOfWeek().SUNDAY)) || ((hd.equals("08:30") == false) && (hd.equals("10:15") == false) && (hd.equals("12:00") == false) && (hd.equals("13:45") == false) && (hd.equals("15:30") == false) && (hd.equals("17:15") == false) && (hd.equals("19:00") == false))) {
                System.out.println("pas possible");
                return 12;
            } else {
                PreparedStatement stmt0 = connect.prepareStatement("SELECT * FROM seance WHERE ID=?");//on cherche les valeur de la seance
                stmt0.setInt(1, idseance);

                ResultSet rs0 = stmt0.executeQuery();
                while (rs0.next()) {
                    i = 1;
                    System.out.println(date + hd); ////seance existe

                }
                if (i == 1) {
                    PreparedStatement stmt12 = connect.prepareStatement("SELECT * FROM seance_enseignant WHERE ID_SEANCE=?");//on cherche les valeur de la seance
                    stmt12.setInt(1, idseance);

                    ResultSet rs12 = stmt12.executeQuery();
                    while (rs12.next()) {

                        System.out.println(rs12.getInt("ID_ENSEIGNANT")); ////seance existe
                        PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_enseignant WHERE ID_ENSEIGNANT=" + rs12.getInt("ID_ENSEIGNANT"));
                        ResultSet rs = stmt.executeQuery();
                        while (rs.next()) {
                            System.out.println(rs.getString("ID_SEANCE"));
                            PreparedStatement stmt3 = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + rs.getInt("ID_SEANCE"));
                            ResultSet rs3 = stmt3.executeQuery();
                            while (rs3.next()) {
                                System.out.println(rs3.getString("DATE") + rs3.getString("HEURE_DEBUT"));
                                if (rs3.getString("DATE").equals(date) && rs3.getString("HEURE_DEBUT").equals(hd)) {//Si le td a deja cours
                                    j = 1;
                                } else {
                                    val = 3;
                                }
                            }
                        }
                    }
                    
                    
                    PreparedStatement stmt1211 = connect.prepareStatement("SELECT * FROM seance_salle WHERE ID_SEANCE=?");//on cherche les valeur de la seance
                    stmt1211.setInt(1, idseance);

                    ResultSet rs1211 = stmt1211.executeQuery();
                    while (rs1211.next()) {

                        System.out.println(rs1211.getInt("ID_SALLE")); ////seance existe
                        PreparedStatement stmt1 = connect.prepareStatement("SELECT * FROM seance_salle WHERE ID_SALLE=" + rs1211.getInt("ID_SALLE"));
                        ResultSet rs1 = stmt1.executeQuery();
                        while (rs1.next()) {
                            System.out.println(rs1.getString("ID_SEANCE"));
                            PreparedStatement stmt31 = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + rs1.getInt("ID_SEANCE"));
                            ResultSet rs31 = stmt31.executeQuery();
                            while (rs31.next()) {
                                System.out.println(rs31.getString("DATE") + rs31.getString("HEURE_DEBUT"));
                                if (rs31.getString("DATE").equals(date) && rs31.getString("HEURE_DEBUT").equals(hd)) {//Si le td a deja cours
                                    return 6;
                                } else {
                                    val = 3;
                                }
                            }
                        }
                    }
                    
                    
                   
                       
                    PreparedStatement stmt121 = connect.prepareStatement("SELECT * FROM seance_groupes WHERE ID_SEANCE=?");//on cherche les valeur de la seance
                    stmt121.setInt(1, idseance);

                    ResultSet rs121 = stmt121.executeQuery();
                    while (rs121.next()) {

                        System.out.println(rs121.getInt("ID_GROUPE")); ////seance existe
                        PreparedStatement stmt1 = connect.prepareStatement("SELECT * FROM seance_groupes WHERE ID_GROUPE=" + rs121.getInt("ID_GROUPE"));
                        ResultSet rs1 = stmt1.executeQuery();
                        while (rs1.next()) {
                            System.out.println(rs1.getString("ID_SEANCE"));
                            PreparedStatement stmt31 = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + rs1.getInt("ID_SEANCE"));
                            ResultSet rs31 = stmt31.executeQuery();
                            while (rs31.next()) {
                                System.out.println("fff" + rs31.getString("DATE") + rs31.getString("HEURE_DEBUT"));
                                if (rs31.getString("DATE").equals(date) && rs31.getString("HEURE_DEBUT").equals(hd)) {//Si le td a deja cours
                                    jj = 1;
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
                    if ((val == 3 || val == 0) && (j != 1) && (jj != 1)) {
                        System.out.println("add");
                        
                       PreparedStatement stmt2111 = connect.prepareStatement("UPDATE  seance SET DATE=?,HEURE_DEBUT=?  WHERE ID=?");
                         stmt2111.setString(1, date);
                          stmt2111.setString(2, hd);
                          stmt2111.setInt(3, idseance);
                       ResultSet r2111 = stmt2111.executeQuery();

                        System.out.println("add");
                        return 2;
                    }
                    if (j == 1) {
                        System.out.println("Le prof a deja cours");
                        return 4;
                    }
                    if (jj == 1) {
                        System.out.println("Le groupe a deja cours");
                        return 1;
                    }
                } else {
                    
                    System.out.println("La seance existe pas");
                    return 0;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
    
    // -------------------------------------------------------------------------------------------
    
    public boolean testcapacite0(ArrayList<Integer> idgrp, ArrayList<Integer> idsalle) {
        try {
            int cap = 0;
            int max = 0;
            for (int i = 0; i < idsalle.size(); i++) {
                PreparedStatement stmt2 = connect.prepareStatement("SELECT * FROM salle WHERE ID=?");
                stmt2.setInt(1, idsalle.get(i));
                //stmt1.setInt(2,idgroupe);
                ResultSet rs2 = stmt2.executeQuery();
                while (rs2.next()) {
                    max = max + rs2.getInt("CAPACITE");
                }

                System.out.println("max " + max);
                System.out.println("taiile idgrp" + idgrp.size());
            }
            for (int t = 0; t < idgrp.size(); t++) {
                System.out.println(idgrp.get(t));

                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM groupe WHERE ID=?");
                stmt11.setInt(1, idgrp.get(t));
                //stmt1.setInt(2,idgroupe);
                ResultSet rs11 = stmt11.executeQuery();
                {
                    while (rs11.next()) {
                        System.out.println("kkkmm" + rs11.getInt("NOMBRE"));
                        cap = cap + rs11.getInt("NOMBRE");

                    }
                }

                System.out.println("cap" + cap);

            }
            if (max < cap) {
                return false;
            } else {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean testdispoprof(int idprof, String date, String hd) {
        try {

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
                        return false;
                    }
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean testdispogrp(int idgroupe, String date, String hd) {
        try {

            PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_groupes WHERE ID_GROUPE=" + idgroupe);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {

                //  System.out.println("mmmmm");
                //System.out.println(rs.getInt("ID_SEANCE")+"g");
                PreparedStatement stmt12 = connect.prepareStatement("SELECT * FROM seance WHERE ID=" + rs.getInt("ID_SEANCE"));
                ResultSet rs12 = stmt12.executeQuery();
                while (rs12.next()) {
                    //i=1;
                    System.out.println("kk" + rs12.getString("DATE") + rs12.getString("HEURE_DEBUT"));
                    if (rs12.getString("DATE").equals(date) && rs12.getString("HEURE_DEBUT").equals(hd)) {//Si le td a deja cours
                        return false;
                    }
                }
            }

            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public void ajoutergrp0(int idseance, int idgroupe) {
        String date = "";
        String hd = "";
        ArrayList<Integer> listgrp = new ArrayList();
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
                    ResultSet rs1 = stmt1.executeQuery();////cherche groupe affcter a la seance

                    while (rs1.next()) {

                        System.out.println("ff");
                        listgrp.add(rs1.getInt("ID_GROUPE"));
                        if (rs1.getInt("ID_GROUPE") == idgroupe) {//Si groupe deja affecter a cette seance
                            i = 3;
                            val = 1;
                            //  System.out.println("mmmmm");
                        }
                    }
                    listgrp.add(idgroupe);//si groupe pas attribue a cette seance.
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

                    if (val == 1) {
                        System.out.println("peut pas");
                        i = 3;
                    }
                    if ((val == 3 || val == 0) && (j != 1)) {

                        // System.out.println(testcapacite(idseance, listgrp));
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
     
    public boolean disposalle(int idsalle, String date, String hd) {
        try {
            PreparedStatement stmt = connect.prepareStatement("SELECT * FROM seance_salle WHERE ID_SALLE=" + idsalle);
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
                       return false;
                    } 
                }
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean verifarrayidgrp(ArrayList<Integer> idgrp) {
        int test = 0;

        try {
            for (int i = 0; i < idgrp.size(); i++) {
                test=0;
                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM groupe WHERE ID=?");
                stmt11.setInt(1, idgrp.get(i));
                ResultSet rs11 = stmt11.executeQuery();
                while (rs11.next()) {   //regarde si le td existe avec la variabel test
                    test++;
                }

                if(test==0)
                return false;
            }

                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean verifarrayidprof(ArrayList<Integer> idprof) {
        int test = 0;

        try {
            for (int i = 0; i < idprof.size(); i++) {
                test=0;
                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM enseignant WHERE ID_UTILISATEUR=?");
                stmt11.setInt(1, idprof.get(i));
                ResultSet rs11 = stmt11.executeQuery();
                while (rs11.next()) {   //regarde si le td existe avec la variabel test
                    test++;
                }

                if(test==0)
                return false;
            }

                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public boolean verifarrayidsalle(ArrayList<Integer> idsalle) {
        int test = 0;

        try {
            for (int i = 0; i < idsalle.size(); i++) {
                test=0;
                PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM salle WHERE ID=?");
                stmt11.setInt(1, idsalle.get(i));
                ResultSet rs11 = stmt11.executeQuery();
                while (rs11.next()) {   //regarde si le td existe avec la variabel test
                    test++;
                }

                if(test==0)
                return false;
            }

                return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return true;
    }
    
    public int chercheid() {
        int nombre = 0;
        try {

            PreparedStatement stmt11 = connect.prepareStatement("SELECT * FROM seance");
            ResultSet rs11 = stmt11.executeQuery();
            while (rs11.next()) {   //regarde si le td existe avec la variabel test

                if(rs11.getInt("ID")>nombre)
                    nombre=rs11.getInt("ID");


            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
return nombre;
    }

    public Connection getConnect() {
        return connect;
    }
    
    

}
