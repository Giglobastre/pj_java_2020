/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;
import MODEL.*;
import CONTROLER.*;
import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Insets;
import javax.swing.*;    // Needed for Swing classes
import java.awt.event.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 *
 * @author hugo7
 */
public class EdtDisplay extends JFrame {

    private JPanel[] tabpanel = new JPanel[63];
    private JLabel[] nomjours = new JLabel[6];
    private JLabel[] heure = new JLabel[14];
    private JButton[] semaine = new JButton[52];
    private JLabel[] espace = new JLabel[100];
    private int varr=0,id;
    private int varr1=0;
    private int groupe;
    private ArrayList<Salle> listesalle = new ArrayList<>();
    private ArrayList<Utilisateur> listeutilisateur = new ArrayList<>();
    private ArrayList<Seance> listeseance = new ArrayList<>();
    private ArrayList<Seance_groupes> listegroupe = new ArrayList<>();
    private ArrayList<Seance_enseignants> listeprof = new ArrayList<>();
    private ArrayList<Cours> listecours = new ArrayList<>();
    private ArrayList<Etudiant> listeetudiant = new ArrayList<>();
    private ArrayList<Seance_salles> listessalles = new ArrayList<>();
    private int valsemaine;
    ArrayList<CoursAffichage> listee;

    public EdtDisplay(ArrayList<CoursAffichage> liste,int semaine, int mid) {
        id=mid;
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
int hauteur = (int)tailleEcran.getHeight();
int largeur = (int)tailleEcran.getWidth();
        listee=liste;
        setTitle("What do you want to do ");
        setLayout(new GridLayout(9, 7));
        setSize(largeur,hauteur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        valsemaine=semaine;
        buildPanel();
        buildheure();
        buildsemaine(valsemaine);
        buildcours(listee);
        for (int i = 0; i < 63; i++) {
            add(tabpanel[i]);
        }

        setVisible(true);
    }

    private void buildPanel() {
        JFrame frame = new JFrame();

        nomjours[0] = new JLabel("Lundi");
        nomjours[1] = new JLabel("Mardi");
        nomjours[2] = new JLabel("Mercredi");
        nomjours[3] = new JLabel("Jeudi");
        nomjours[4] = new JLabel("Vendredi");
        nomjours[5] = new JLabel("Samedi");
       /* for (int i = 0; i < 100; i++) {
            if (i < 52) {
                String nom;
                nom = Integer.toString(i);
                semaine[i] = new JButton(nom);

            }
            espace[i] = new JLabel(" ");
        }*/

        int j = 0;
        int s = 0;
        for (int i = 0; i < 63; i++) {

            tabpanel[i] = new JPanel();
            if (i > 7) {
                tabpanel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            }
            if (i < 7) {
                tabpanel[i].setBackground(new Color(167, 213, 254));
            }
            if (i > 7 && i < 14) {
               
                tabpanel[i].add(nomjours[j]);
                j++;
            }

        }

        setVisible(true);

        frame.setVisible(true);
    }

    private void buildheure() {
        heure[0] = new JLabel("8h30");
        heure[1] = new JLabel("10h00");
        heure[2] = new JLabel("10h15");
        heure[3] = new JLabel("11h45");
        heure[4] = new JLabel("12h00");
        heure[5] = new JLabel("13h30");
        heure[6] = new JLabel("13h45");
        heure[7] = new JLabel("15h15");
        heure[8] = new JLabel("15h30");
        heure[9] = new JLabel("17h00");
        heure[10] = new JLabel("17h15");
        heure[11] = new JLabel("18h45");
        heure[12] = new JLabel("19h00");
        heure[13] = new JLabel("20h30");

        tabpanel[14].setLayout(new GridLayout(2, 1));
        tabpanel[14].add(heure[0]);
        tabpanel[14].add(heure[1]);

        tabpanel[21].setLayout(new GridLayout(2, 1));
        tabpanel[21].add(heure[2]);
        tabpanel[21].add(heure[3]);
        tabpanel[28].setLayout(new GridLayout(2, 1));
        tabpanel[28].add(heure[4]);
        tabpanel[28].add(heure[5]);
        tabpanel[35].setLayout(new GridLayout(2, 1));
        tabpanel[35].add(heure[6]);
        tabpanel[35].add(heure[7]);
        tabpanel[42].setLayout(new GridLayout(2, 1));
        tabpanel[42].add(heure[8]);
        tabpanel[42].add(heure[9]);
        tabpanel[49].setLayout(new GridLayout(2, 1));
        tabpanel[49].add(heure[10]);
        tabpanel[49].add(heure[11]);
        tabpanel[56].setLayout(new GridLayout(2, 1));
        tabpanel[56].add(heure[12]);
        tabpanel[56].add(heure[13]);
        // tabpanel[15].setBackground(new Color(112, 213, 254));

    }
//neeed ID groupe de l'é"tudiant et la semaine a afficher
    
 private void buildcours(ArrayList<CoursAffichage> liste) {
        
     for(int i=0;i<liste.size();i++)
     {
            afficours(liste.get(i).getHD(), liste.get(i).getDate(),liste.get(i).getNom(),liste.get(i).getProf(),liste.get(i).getSalle(),liste.get(i).getCapacite(),liste.get(i).getSite(),liste.get(i).getGroupetab());
     }
 
 }
    
 private void buildsemaine(int semaineg)
 {    JLabel[] tab = new JLabel[10];
 
 for(int i=0;i<10;i++)
 {
     tab[i]= new JLabel("");
 }
 String sem=Integer.toString(semaineg);
 tabpanel[7].setLayout(new GridLayout(2, 3));
 JLabel semainenom = new JLabel("Semaine");
 JLabel numsemaine = new JLabel(sem);
 JButton petit = new JButton("<<");
  JButton grand = new JButton(">>");
  grand.addActionListener(new Grand());
  petit.addActionListener(new Petit());
 numsemaine.setHorizontalAlignment(SwingConstants.CENTER);
    tabpanel[7].add(tab[0]);
    tabpanel[7].add(semainenom);
    tabpanel[7].add(tab[1]);
    tabpanel[7].add(petit);
    tabpanel[7].add(numsemaine);
   tabpanel[7].add(grand);
    
      
 
     
     
 }
 
 private void afficours(String HD, String Date, String cours, ArrayList<String> nomprof, String salle, int capacite,String site,ArrayList<String> nomgrp) {
        final String SEPARATEUR = "/";
        String conte = Date;

        String mots[] = conte.split(SEPARATEUR);

      
        int jour = Integer.parseInt(mots[0]);
        int mois = Integer.parseInt(mots[1]);
        int annee = Integer.parseInt(mots[2]);

        LocalDate localDate = LocalDate.of(annee, mois, jour);

        //Getting the day of week for a given date
        java.time.DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        if (dayOfWeek.equals(localDate.getDayOfWeek().MONDAY)) {
            builaffheure(HD,1,cours,nomprof.get(varr),salle,capacite,site,nomgrp.get(varr1));
        }
        if (dayOfWeek.equals(localDate.getDayOfWeek().TUESDAY)) {
            builaffheure(HD,2,cours,nomprof.get(varr),salle,capacite,site,nomgrp.get(varr1));
        }
        if (dayOfWeek.equals(localDate.getDayOfWeek().WEDNESDAY)) {
            builaffheure(HD,3,cours,nomprof.get(varr),salle,capacite,site,nomgrp.get(varr1));
        }
        if (dayOfWeek.equals(localDate.getDayOfWeek().THURSDAY)) {
            builaffheure(HD,4,cours,nomprof.get(varr),salle,capacite,site,nomgrp.get(varr1));
        }
        if (dayOfWeek.equals(localDate.getDayOfWeek().FRIDAY)) {
            builaffheure(HD,5,cours,nomprof.get(varr),salle,capacite,site,nomgrp.get(varr1));
        }
        if (dayOfWeek.equals(localDate.getDayOfWeek().SATURDAY)) {
            builaffheure(HD,6,cours,nomprof.get(varr),salle,capacite,site,nomgrp.get(varr1));
        }
        varr++;
        varr1++;
    }

    private void builaffheure(String Heure, int jour, String cours, String nomprof, String salle, int capacite,String site, String nomgrp) {
        JLabel nom = new JLabel(cours);
      
        JLabel prof = new JLabel(nomprof );
        JLabel prof2 = new JLabel(site+" "+salle+" "+"("+capacite+")");
        JLabel grp = new JLabel(nomgrp);
        int i=0;
        if(jour==1)
            i=0;
         if(jour==2)
            i=1;
          if(jour==3)
            i=2;
           if(jour==4)
            i=3;
            if(jour==5)
            i=4;
             if(jour==6)
            i=5;
        
            if (Heure.equals("08:30")) {
            tabpanel[15+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[15+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[15+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[15+i].add(prof2);
            
            grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[15+i].add(grp);
            if(cours.equals("Math"))
                   tabpanel[15+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[15+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[15+i].setBackground(new Color(174,212,252));
            
        }
            if (Heure.equals("10:15")) {
            tabpanel[22+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[22+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[22+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[22+i].add(prof2);
           // tabpanel[22+i].setBackground(new Color(252,241,107));
           grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[22+i].add(grp);
            
            if(cours.equals("Math"))
                   tabpanel[22+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[22+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[22+i].setBackground(new Color(174,212,252));
            
        }
            if (Heure.equals("12:00")) {
            tabpanel[29+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[29+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[29+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[29+i].add(prof2);
           
            grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[29+i].add(grp);
            
            if(cours.equals("Math"))
                   tabpanel[29+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[29+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[29+i].setBackground(new Color(174,212,252));
        }
            if (Heure.equals("13:45")) {
            tabpanel[36+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[36+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[36+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[36+i].add(prof2);
            tabpanel[36+i].setBackground(Color.red);
            grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[36+i].add(grp);
            
            
            if(cours.equals("Math"))
                   tabpanel[36+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[36+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[36+i].setBackground(new Color(174,212,252));
        }
       
        if (Heure.equals("15:30")) {
            tabpanel[43+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[43+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[43+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[43+i].add(prof2);
            
            grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[43+i].add(grp);
            
            if(cours.equals("Math"))
                   tabpanel[43+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[43+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[43+i].setBackground(new Color(174,212,252));
        }
        if (Heure.equals("17:15")) {
            tabpanel[50+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[50+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[50+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[50+i].add(prof2);
            //tabpanel[50+i].setBackground(Color.red);
            grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[50+i].add(grp);
            if(cours.equals("Math"))
                   tabpanel[50+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[50+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[50+i].setBackground(new Color(174,212,252));
        }
        if (Heure.equals("19:00")) {
            tabpanel[57+i].setLayout(new GridLayout(4, 1));

            nom.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[57+i].add(nom);

            prof.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[57+i].add(prof);

            prof2.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[57+i].add(prof2);
            //tabpanel[57+i].setBackground(Color.red);
            grp.setHorizontalAlignment(SwingConstants.CENTER);
            tabpanel[57+i].add(grp);
            
            if(cours.equals("Math"))
                   tabpanel[57+i].setBackground(new Color(174,252,186));
            if(cours.equals("Physique"))
                tabpanel[57+i].setBackground(new Color(255,133,107));
            if(cours.equals("Anglais"))
                tabpanel[57+i].setBackground(new Color(174,212,252));
        }
    }
    
private class Grand implements ActionListener {

        /**
         * The actionPerformed method executes when the user clicks on the
         * Calculate button.
         *
         * @param e The event object.
         */
        public void actionPerformed(ActionEvent e) {

           //emaineg=semaineg+1;
            //tabcust.add(new Customer("huh", "ji"));
           /* Source http://week-number.net/programming/week-number-in-java.html */
            Calendar calendar = new GregorianCalendar();
            Date Time = new Date();
            calendar.setTime(Time);
            System.out.println(Time);
            int wk=calendar.get(Calendar.WEEK_OF_YEAR); 
            
           Controlleuredt controle=new Controlleuredt(wk);
           controle.setSemaine(valsemaine+1);
           controle.msg(id);
           controle.lanceclasse();
                   dispose();
           //System.out.println("semaine"+controle.getSemaine());
           //CoursAffichage courrr=new CoursAffichage();
          // listee=courrr.affichageetudiant(1, valsemaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite);
            //new ProjetJava();
        }

    }

private class Petit implements ActionListener {

        /**
         * The actionPerformed method executes when the user clicks on the
         * Calculate button.
         *
         * @param e The event object.
         */
        public void actionPerformed(ActionEvent e) {

           //emaineg=semaineg+1;
            //tabcust.add(new Customer("huh", "ji"));
            /* Source http://week-number.net/programming/week-number-in-java.html */
        Calendar calendar = new GregorianCalendar();
        Date Time = new Date();
        calendar.setTime(Time);
        System.out.println(Time);
        int wk=calendar.get(Calendar.WEEK_OF_YEAR);
           Controlleuredt controle=new Controlleuredt(wk);
           controle.setSemaine(valsemaine-1);
           controle.msg(id);
           controle.lanceclasse();
           
           dispose();
           //System.out.println("semaine"+controle.getSemaine());
           //CoursAffichage courrr=new CoursAffichage();
          // listee=courrr.affichageetudiant(1, valsemaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite);
            //new ProjetJava();
        }

    }
}
