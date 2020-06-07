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
import java.util.Scanner;

/**
 *
 * @author hugo7
 */
public class Recapprof extends JFrame {

    private JPanel[] tabpanel = new JPanel[80];
    private JLabel[] nomjours = new JLabel[6];
    private JLabel[] heure = new JLabel[14];
    private JButton[] semaine = new JButton[52];
    private JLabel[] espace = new JLabel[100];
    private int varr = 0;
    private int varr1 = 0;
    private int groupe;
    ArrayList<CoursAffichage> listee;

    public Recapprof(ArrayList<CoursAffichage> liste) {
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        int hauteur = (int) tailleEcran.getHeight();
        int largeur = (int) tailleEcran.getWidth();
        listee=liste;
        setTitle("What do you want to do ");
        setLayout(new GridLayout(20, 4));
        setSize(largeur, hauteur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        buildPanel();
        buildcours(listee);

        for (int i = 0; i < 80; i++) {
            add(tabpanel[i]);
        }

        setVisible(true);
    }

    private void buildPanel() {
        JFrame frame = new JFrame();
        JLabel txt = new JLabel("COURS");
        JLabel txt1 = new JLabel("DATE");
        JLabel txt2 = new JLabel("GROUPE");
        JLabel txt3 = new JLabel("SALLE");

        /* for (int i = 0; i < 100; i++) {
         if (i < 52) {
         String nom;
         nom = Integer.toString(i);
         semaine[i] = new JButton(nom);

         }
         espace[i] = new JLabel(" ");
         }*/
        for (int i = 0; i < 80; i++) {

            tabpanel[i] = new JPanel();
            if (i > 7) {
                tabpanel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            }

            if (i == 8) {
                tabpanel[i].add(txt);
            }
            if (i == 9) {
                tabpanel[i].add(txt1);
            }
            if (i == 10) {
                tabpanel[i].add(txt2);
            }
            if (i == 11) {
                tabpanel[i].add(txt3);
            }
           
        }
        
        setVisible(true);

        frame.setVisible(true);
    }

    /*private void buildcours(ArrayList<CoursAffichage> liste) {
        
     for(int i=0;i<liste.size();i++)
     {
     afficours(liste.get(i).getHD(), liste.get(i).getDate(),liste.get(i).getNom(),liste.get(i).getProf(),liste.get(i).getSalle(),liste.get(i).getCapacite(),liste.get(i).getSite(),liste.get(i).getGroupetab());
     }
 
     }*/
    
    private void buildcours(ArrayList<CoursAffichage> liste) {
     
     for(int i=0;i<liste.size();i++)
     {
            afficours(liste.get(i).getHD(), liste.get(i).getDate(),liste.get(i).getNom(),liste.get(i).getProf(),liste.get(i).getSalletab(),liste.get(i).getCapacite(),liste.get(i).getSite(),liste.get(i).getGroupetab(),i);
     }
 
 }
    
   private void afficours(String HD, String Date, String cours, ArrayList<String> nomprof, ArrayList<String> salle, int capacite,String site,ArrayList<String> nomgrp,int i) {
        JLabel gcours= new JLabel(cours);
        JLabel gdate= new JLabel(Date+" "+HD);
        JLabel ggroupe= new JLabel(nomgrp.get(i));
        JLabel gsalle= new JLabel(salle.get(i));
       
       tabpanel[12+4*i].add(gcours);
       tabpanel[12+4*i].setBackground(new Color(0,240,0));
       
       tabpanel[13+4*i].add(gdate);
        tabpanel[13+4*i].setBackground(new Color(0,240,0));
       tabpanel[14+4*i].add(ggroupe);
        tabpanel[14+4*i].setBackground(new Color(0,240,0));
        tabpanel[15+4*i].add(gsalle);
        tabpanel[15+4*i].setBackground(new Color(0,240,0));
       //tabpanel[15+4*i].add(gcours);

       
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
            
           Controlleuredt controle=new Controlleuredt();
           //controle.setSemaine(valsemaine+1);
           controle.msg();
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
            Controlleuredt controle = new Controlleuredt();
            //controle.setSemaine(valsemaine-1);
            controle.msg();
            controle.lanceclasse();

            dispose();
            //System.out.println("semaine"+controle.getSemaine());
            //CoursAffichage courrr=new CoursAffichage();
            // listee=courrr.affichageetudiant(1, valsemaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite);
            //new ProjetJava();
        }

    }
}
