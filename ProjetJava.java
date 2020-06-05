/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;
import java.sql.Connection;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Calendar;import java.time.LocalDate;

/**
 *
 * @author hugo7
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     
        Admin ad=new Admin();
       ad.connexion();
       ArrayList<Integer> listegroupe = new ArrayList<>();
       ArrayList<Integer> listeprof = new ArrayList<>();
       ArrayList<Integer> listesalle = new ArrayList<>();
       //ArrayList<Integer> listegroupe = new ArrayList<>();
            listegroupe.add(3);
       //listegroupe.add(1);
   //  System.out.println(ad.testcapacite0(listegroupe, 1));
       listeprof.add(14);
       listeprof.add(7);
       listesalle.add(3);
       listesalle.add(2);
      //System.out.println( ad.testcapacite0(listegroupe, listesalle));
       //System.out.println(ad.verifarrayidsalle(listesalle));
       //System.out.println(ad.testcapacite(1, listegroupe));
      //ad.ajoutseeance("26/05/2020","15:30", 1, 2, 1, listeprof, listegroupe,listesalle);
      //int k=ad.chercheid();
      //.System.out.println(k);
       
       
         //ad.ajoutesalle(33, 3);
         //ad.deplacerceance("26/05/2020","10:15", 1);
        //ad.annulerseance(1);
       // ad.validerseance(1);
      // System.out.println(ad.testcapacite(1, listegroupe));
//ad.ajoutergrp(1, 3);
      // System.out.println(ad.testdispogrp( 3,"27/05/2020", "10:15"));
          // System.out.println("lrr");
    //  ad.ajoutergrp(1, 3);//seance:groupe
//ad.enlevergrpensei(false, 1, 3); //true =prof false =grp
       //ad.ajouterprof(3, 14);
     Controlleuredt controle=new Controlleuredt();
      controle.msg();
     controle.lance();
        
         
           
}}