/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;

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
import java.util.ArrayList;
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
    private int groupe;
   private ArrayList<Salle> listesalle = new ArrayList<>();
         private  ArrayList<Utilisateur> listeutilisateur = new ArrayList<>();
         private  ArrayList<Seance> listeseance = new ArrayList<>();
         private  ArrayList<Seance_groupes> listegroupe = new ArrayList<>();
       private    ArrayList<Seance_enseignants> listeprof = new ArrayList<>();
       private    ArrayList<Cours> listecours = new ArrayList<>();
       private    ArrayList<Etudiant> listeetudiant = new ArrayList<>();
       private    ArrayList<Seance_salles> listessalles = new ArrayList<>();
       
    public EdtDisplay(int groupe,ArrayList<Salle> listesalle,ArrayList<Utilisateur> listeutilisateur,ArrayList<Seance> listeseance,ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof,ArrayList<Cours> listecours,ArrayList<Etudiant> listeetudiant,ArrayList<Seance_salles> listessalles) {
        tabpanel = new JPanel[63];

        setLayout(new GridLayout(9, 7));

        setTitle("What do you want to do ");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        buildheure();
        buildcours(groupe,listesalle, listeutilisateur, listeseance, listegroupe,  listeprof, listecours, listeetudiant,listessalles);
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
        for (int i = 0; i < 100; i++) {
            if (i < 52) {
                String nom;
                nom = Integer.toString(i);
                semaine[i] = new JButton(nom);

            }
            espace[i] = new JLabel(" ");
        }

        int j = 0;
        int s=0;
        for (int i = 0; i < 63; i++) {

            tabpanel[i] = new JPanel();
            if (i > 7) {
                tabpanel[i].setBorder(BorderFactory.createLineBorder(Color.black));
            }
            if (i < 7) {
                tabpanel[i].setBackground(new Color(167, 213, 254));
            }
            if (i>7&&i<14) {
                tabpanel[i].setLayout(new GridBagLayout());
                GridBagConstraints c = new GridBagConstraints();
                c.gridx = 0;
                c.gridy = 0;

                c.fill = GridBagConstraints.BOTH;
                c.weightx = 0.25;
                tabpanel[i].add(semaine[s], c);
                s++;

                c.fill = GridBagConstraints.HORIZONTAL;
                c.weightx = 0.25;
                c.gridx = 1;
                c.gridy = 0;
                tabpanel[i].add(semaine[s], c);
                s++;

                c.fill = GridBagConstraints.BOTH;
                c.weightx = 0.25;
                c.gridx = 2;
                c.gridy = 0;
                tabpanel[i].add(semaine[s], c);
                s++;

                c.fill = GridBagConstraints.BOTH;
                c.weightx = 0.25;
                c.gridx = 3;
                c.gridy = 0;
                tabpanel[i].add(semaine[s], c);
                s++;

                c.fill = GridBagConstraints.BOTH;
                c.weightx = 1;
                c.gridx = 2;
                c.gridy = 2;
                tabpanel[i].add(nomjours[j], c);
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
private void buildcours(int groupe,ArrayList<Salle> listesalle,ArrayList<Utilisateur> listeutilisateur,ArrayList<Seance> listeseance,ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof,ArrayList<Cours> listecours,ArrayList<Etudiant> listeetudiant,ArrayList<Seance_salles> listessalles) 
{
        ArrayList<Integer> id = new ArrayList<>();
    for(int i=0;i<listegroupe.size();i++)
        {
            if(listegroupe.get(i).getID_GROUPE()==groupe)
            {
                id.add(listegroupe.get(i).getID_SEANCE());
                        
            }
        }
    
for(int i=0;i<listeseance.size();i++)
{
    String nom="";
    String nomsalle="";
    String nomprof="";
    int capacite=0;
    if(listeseance.get(i).getSEMAINE()==51)
    {
    for( int j=0;j<id.size();j++)
    {
        if(listeseance.get(i).getID()==id.get(j))
            {///////bon TD Bonne semaine Bon seance
        //System.out.println(listeseance.get(i).getHEURE_DEBUT());
            //recherche d'autre informations
            //for(int k=0;k<listeseance.size();k++)//plus d ecours que salle::::::::::::::::::::::::::::::::::::::::::
            //{
                if(listecours.get(j).getiD()==listeseance.get(i).getID_COURS())
                {
                    nom=listecours.get(j).getNom();
                    System.out.println(nom);
                }
                System.out.println(listegroupe.get(i).getID_SEANCE());
                    //System.out.println("ll");
                    for(int l=0;l<listeutilisateur.size();l++)
                    {
                        if(listeutilisateur.get(l).getID()==listeprof.get(j).getID_ENSEIGANT())
                        {
                           nomprof=listeutilisateur.get(l).getNOM();
                             System.out.println(nomprof);
                        }
                    }
                     nom=listecours.get(j).getNom();
                    System.out.println(nom);
                
                
                if(j<listesalle.size())
                {
                
                if(listesalle.get(j).getID()==listeseance.get(i).getID_COURS());
                {
                     nomsalle=listesalle.get(j).getNOM();
                  capacite=listesalle.get(j).getCAPACITE();
                    System.out.println(nomsalle);
                   
                   
                }
                } 
            //}
        afficours(listeseance.get(i).getHEURE_DEBUT(),nom,nomprof,nomsalle,capacite);
    }
        }
    } 
   //if((listeseance.get(id.get(i)).getSEMAINE())==51)
       //System.out.println("ff");
}
}

private void afficours(String HD,String cours,String nomprof,String salle,int capacité)
{
    JLabel[] nomjours = new JLabel[6];
    for(int i=0;i<6;i++)
    {
        nomjours[i] = new JLabel("");
    }
    JLabel nom=new JLabel(cours);
    JLabel prof=new JLabel(nomprof+" "+salle);
     JLabel prof2=new JLabel("ING3");
    
    if(HD.equals("10:00"))
    {    tabpanel[16].setLayout(new GridLayout(3, 1));
    
     nom.setHorizontalAlignment(SwingConstants.CENTER);
        tabpanel[16].add(nom);
        
    prof.setHorizontalAlignment(SwingConstants.CENTER);
        tabpanel[16].add(prof);
        
       prof2.setHorizontalAlignment(SwingConstants.CENTER);
        tabpanel[16].add(prof2);
        tabpanel[16].setBackground(Color.red);
        

    }
}
    

}

