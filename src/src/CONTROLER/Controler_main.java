/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;
import MODEL.*;
import VIEW.*;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.GregorianCalendar;
/**
 *
 * @author Kenny-portable
 */
public class Controler_main {
    public static void main(String[] args) {
        Connexion co=new Connexion();
        
        Fenetre_Connexion fco=new Fenetre_Connexion(co);
        
        /*Controlleuredt control=new Controlleuredt();
        control.msg(7);
        control.lanceprof();
        */
       /*Controlleuredt con=new Controlleuredt(7);
        con.msgrecap("26/05/2020","27/05/2020");
        con.lanceprofrecap();*/
}




}




