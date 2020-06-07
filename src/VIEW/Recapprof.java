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
    private int varr=0;
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

    public Recapprof()

    {
        Dimension tailleEcran = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
int hauteur = (int)tailleEcran.getHeight();
int largeur = (int)tailleEcran.getWidth();
        //listee=liste;
        setTitle("What do you want to do ");
        setLayout(new GridLayout(20, 4));
        setSize(largeur,hauteur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        for(int i=0;i<80;i++)
            tabpanel[i].setBorder(BorderFactory.createLineBorder(Color.black));
        

        setVisible(true);
    }

    
 /*private void buildcours(ArrayList<CoursAffichage> liste) {
        
     for(int i=0;i<liste.size();i++)
     {
            afficours(liste.get(i).getHD(), liste.get(i).getDate(),liste.get(i).getNom(),liste.get(i).getProf(),liste.get(i).getSalle(),liste.get(i).getCapacite(),liste.get(i).getSite(),liste.get(i).getGroupetab());
     }
 
 }*/
    

 



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
            
          /* Controlleuredt controle=new Controlleuredt();
           controle.setSemaine(valsemaine-1);
           controle.msg();
           controle.lanceclasse();*/
           
           dispose();
           //System.out.println("semaine"+controle.getSemaine());
           //CoursAffichage courrr=new CoursAffichage();
          // listee=courrr.affichageetudiant(1, valsemaine, listesalle, listeutilisateur, listeseance, listegroupe, listeprof, listecours, listeetudiant, listessalles, listesite);
            //new ProjetJava();
        }

    }
}
