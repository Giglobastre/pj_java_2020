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
       //ad.ajoutseeance("04/06/2020","kkk", 1, 1, 1, 14, 1);
        //ad.annulerseance(1);
       // ad.validerseance(1);
      //ad.ajoutergrp(1, 1);//seance:groupe
       ad.enlevergrpensei(true, 3, 12); //true =prof false =grp
      // ad.ajouterprof(3, 14);
     //Controlleuredt controle=new Controlleuredt();
      //controle.msg();
     //controle.lance();
        
         
           
}}