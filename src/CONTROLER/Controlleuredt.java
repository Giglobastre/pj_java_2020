package CONTROLER;
import MODEL.*;
import VIEW.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hugo7
 */
public class Controlleuredt {

    private int semaine,mid;
    private ArrayList<CoursAffichage> llisteprof = new ArrayList<>();
    private ArrayList<CoursAffichage> llisteclasse = new ArrayList<>();
    private ArrayList<CoursAffichage> llisteetudiant = new ArrayList<>();
     private ArrayList<CoursAffichage> llisterecap = new ArrayList<>();

    public Controlleuredt() {
         Calendar calendar = new GregorianCalendar();
        Date Time = new Date();
        calendar.setTime(Time);
        System.out.println(Time);
        int wk=calendar.get(Calendar.WEEK_OF_YEAR);
        semaine=wk;
    }

    public void msg(int id) {
        mid=id;
        DAO<Salle> salle = new SalleDAO();
        DAO<Utilisateur> uti = new UtilisateurDAO();
        DAO<Seance> seance = new SeanceDAO();
        DAO<Seance_groupes> groupe = new Seance_groupesDAO();
        DAO<Seance_enseignants> prof = new Seance_enseignantsDAO();
        DAO<Cours> cours = new CoursDAO();
        DAO<Etudiant> etudiant = new EtudiantDAO();
        DAO<Seance_salles> ssalle = new Seance_sallesDAO();
        DAO<Site> site = new SiteDAO();
        DAO<Groupe> grp = new GroupeDAO();
        ArrayList<Salle> listesalle = new ArrayList<>();
        ArrayList<Utilisateur> listeutilisateur = new ArrayList<>();
        ArrayList<Seance> listeseance = new ArrayList<>();
        ArrayList<Seance_groupes> listegroupe = new ArrayList<>();
        ArrayList<Seance_enseignants> listeprof = new ArrayList<>();
        ArrayList<Cours> listecours = new ArrayList<>();
        ArrayList<Etudiant> listeetudiant = new ArrayList<>();
        ArrayList<Seance_salles> listessalles = new ArrayList<>();
        ArrayList<Site> listesite = new ArrayList<>();
        ArrayList<CoursAffichage> fin = new ArrayList<>();
        ArrayList<Groupe> groupetab = new ArrayList<>();

        salle.chargement(listesalle);
        uti.chargement(listeutilisateur);
        seance.chargement(listeseance);
        groupe.chargement(listegroupe);
        prof.chargement(listeprof);
        cours.chargement(listecours);
        etudiant.chargement(listeetudiant);
        ssalle.chargement(listessalles);
        site.chargement(listesite);
        grp.chargement(groupetab);
        CoursAffichage courrr = new CoursAffichage();
        llisteprof = courrr.affichageprof(mid, semaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite, groupetab);
        llisteclasse = courrr.affichageclasse(mid, semaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite, groupetab);
        llisteetudiant = courrr.affichageetudiant(mid, semaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite, groupetab);

    }
    public void msgrecap(int id,String DD,String DF) {
        DAO<Salle> salle = new SalleDAO();
        DAO<Utilisateur> uti = new UtilisateurDAO();
        DAO<Seance> seance = new SeanceDAO();
        DAO<Seance_groupes> groupe = new Seance_groupesDAO();
        DAO<Seance_enseignants> prof = new Seance_enseignantsDAO();
        DAO<Cours> cours = new CoursDAO();
        DAO<Etudiant> etudiant = new EtudiantDAO();
        DAO<Seance_salles> ssalle = new Seance_sallesDAO();
        DAO<Site> site = new SiteDAO();
        DAO<Groupe> grp = new GroupeDAO();
        ArrayList<Salle> listesalle = new ArrayList<>();
        ArrayList<Utilisateur> listeutilisateur = new ArrayList<>();
        ArrayList<Seance> listeseance = new ArrayList<>();
        ArrayList<Seance_groupes> listegroupe = new ArrayList<>();
        ArrayList<Seance_enseignants> listeprof = new ArrayList<>();
        ArrayList<Cours> listecours = new ArrayList<>();
        ArrayList<Etudiant> listeetudiant = new ArrayList<>();
        ArrayList<Seance_salles> listessalles = new ArrayList<>();
        ArrayList<Site> listesite = new ArrayList<>();
        ArrayList<CoursAffichage> fin = new ArrayList<>();
        ArrayList<Groupe> groupetab = new ArrayList<>();

        salle.chargement(listesalle);
        uti.chargement(listeutilisateur);
        seance.chargement(listeseance);
        groupe.chargement(listegroupe);
        prof.chargement(listeprof);
        cours.chargement(listecours);
        etudiant.chargement(listeetudiant);
        ssalle.chargement(listessalles);
        site.chargement(listesite);
        grp.chargement(groupetab);
        CoursAffichage courrr = new CoursAffichage();
        llisterecap = courrr.affichageautre(id, semaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite, groupetab,DD,DF);

    }

    public void lanceetudiant() {
        
        new Edtetudiant(llisteetudiant, semaine,mid);
    }
     public void lanceclasse(int idprof) {
        
        EdtDisplay edt= new EdtDisplay(llisteclasse,semaine,mid,idprof);
        
    }
     public void lanceprof() {
        new Edtprof(llisteprof, semaine,mid);
    }
    public void lanceprofrecap(int idprof) {
        new Recapprof(llisterecap,idprof);
    }
    public void lanceetudiantprof(int idprof) {
        new EdtDisplayprof(llisteclasse,semaine,mid, idprof);
    }

   

    public int getSemaine() {
        return semaine;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }
    
}
