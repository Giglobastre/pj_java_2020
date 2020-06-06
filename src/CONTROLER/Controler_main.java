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
        //Fenetre_Connexion fco=new Fenetre_Connexion(co);
        //Controlleuredt control=new Controlleuredt();
        //control.msg();
        //control.lanceclasse();
          
Calendar calendar = new GregorianCalendar();

LocalDate localDate = LocalDate.now();
//calendar.setTime(trialTime);     
LocalDate date = LocalDate.of(2020, 06,05);
    if ( date.isBefore(localDate) ) {
      System.out.println("Week number:" + 
    calendar.get(Calendar.WEEK_OF_YEAR));
}




}



}
