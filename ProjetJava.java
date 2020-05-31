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
         DAO<Salle> salle= new SalleDAO();
         DAO<Utilisateur> uti = new UtilisateurDAO();
         DAO<Seance> seance = new SeanceDAO();
         DAO<Seance_groupes> groupe = new Seance_groupesDAO();
         DAO<Seance_enseignants> prof = new Seance_enseignantsDAO();
         DAO<Cours> cours = new CoursDAO();
         DAO<Etudiant> etudiant = new EtudiantDAO();
         DAO<Seance_salles> ssalle = new Seance_sallesDAO();
         
         ArrayList<Salle> listesalle = new ArrayList<>();
         ArrayList<Utilisateur> listeutilisateur = new ArrayList<>();
         ArrayList<Seance> listeseance = new ArrayList<>();
         ArrayList<Seance_groupes> listegroupe = new ArrayList<>();
         ArrayList<Seance_enseignants> listeprof = new ArrayList<>();
         ArrayList<Cours> listecours = new ArrayList<>();
         ArrayList<Etudiant> listeetudiant = new ArrayList<>();
         ArrayList<Seance_salles> listessalles = new ArrayList<>();
         
         GregorianCalendar cal=new GregorianCalendar(2020,04,31);
         //Cours cours =new Cours(1,"k");
         //Etudiant etu=new Etudiant();
         salle.chargement(listesalle);
         uti.chargement(listeutilisateur);
         seance.chargement(listeseance);
         groupe.chargement(listegroupe);
         prof.chargement(listeprof);
         cours.chargement(listecours);
         etudiant.chargement(listeetudiant);
         ssalle.chargement(listessalles);
         int grp=1;
    
         
         final String SEPARATEUR = "/";
            String conte = "30/05/2020";
 
        String mots[] = conte.split(SEPARATEUR);
 
        for (int i = 0; i < mots.length; i++) {
            System.out.println(mots[i]);
        }
        int jour=Integer.parseInt(mots[0]);
        int mois=Integer.parseInt(mots[1]);
        int annee=Integer.parseInt(mots[2]);
        
         LocalDate localDate = LocalDate.of(annee, mois, jour);
     
    //Getting the day of week for a given date
    java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
    System.out.println(localDate + " was a " + dayOfWeek);
    LocalDate firstWorkingDay;

    for(int i = 0; i <listecours.size(); i++){
      
      System.out.println("Cours N°" +listecours.get(i).getNom());
    }
    
    EdtDisplay h=new EdtDisplay(grp,listesalle, listeutilisateur, listeseance, listegroupe,  listeprof, listecours, listeetudiant,listessalles);
}
}