/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.JFrame;
import javax.swing.*;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author Kenny-fixe
 */
public class Fenetre_Admin extends JFrame{
    Admin adm=new Admin();
    
    final private   int         window_Width = 800;
    final private   int         window_Height = 600;
    
    private         JPanel      panel;
    
    private         JLabel      msg;
    
    private         JButton     affEnseignantSeance;
    private         JButton     affGrpSeance;
    private         JButton     affSalle;
    private         JButton     modifCours;
    private         JButton     DepSeance;
    private         JButton     addSeance;
    private         JButton     addEnseignant;
    private         JButton     addGroupe;
    private         JButton     annulSeance;
    private         JButton     validSeance;
    private         JButton     delGrp_Enseignant_Cours;
    private         JButton     graphe;
    private         JButton     Quitter;
    
    public Fenetre_Admin() {

        this.setSize(window_Width, window_Height); 

        this.setTitle("User Interface");

        this.setUndecorated(true);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan;
        pan = buildPanelInterface();
        this.setContentPane(pan);

        this.setVisible(true);
    }
    
    private JPanel buildPanelInterface() {
        msg=new JLabel("Administration");
        
        affEnseignantSeance=new JButton("Affecter un enseignant");
        affGrpSeance=new JButton("Affecter un groupe");
        affSalle=new JButton("Affecter une salle");
        modifCours=new JButton("Modifier un cours");
        DepSeance=new JButton("Deplacer une seance");
        addSeance=new JButton("Ajouter une seance");
        addEnseignant=new JButton("Ajouter un enseignant");
        addGroupe=new JButton("Ajouter un groupe");
        annulSeance=new JButton("Annuler une seance");
        validSeance=new JButton("Valider une seance");
        delGrp_Enseignant_Cours=new JButton("sup grp ou enseignant d'un cours");
        Quitter=new JButton("QUITTER");
        graphe=new JButton("Graphe");
        
        affEnseignantSeance.addActionListener(new affEnseignantSeance_Listener());
        affGrpSeance.addActionListener(new affGrpSeance_Listener());
        affSalle.addActionListener(new affSalle_Listener());
        modifCours.addActionListener(new modifCours_Listener());
        DepSeance.addActionListener(new DepSeance_Listener());
        addSeance.addActionListener(new addSeance_Listener());
        annulSeance.addActionListener(new annulSeance_Listener());
        validSeance.addActionListener(new validSeance_Listener());
        delGrp_Enseignant_Cours.addActionListener(new delGrp_Enseignant_Cours_Listener());
        Quitter.addActionListener(new Quitter_Listener());
        graphe.addActionListener(new Graphe_Listener());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 4));
        
        panel.add(msg, BorderLayout.CENTER);
        panel.add(new JPanel());
        panel.add(new JPanel());
        panel.add(graphe, BorderLayout.CENTER);
        panel.add(affEnseignantSeance, BorderLayout.CENTER);
        panel.add(affGrpSeance, BorderLayout.CENTER);
        panel.add(affSalle, BorderLayout.CENTER);
        panel.add(modifCours, BorderLayout.CENTER);
        panel.add(DepSeance, BorderLayout.CENTER);
        panel.add(addSeance, BorderLayout.CENTER);
        panel.add(annulSeance, BorderLayout.CENTER);
        panel.add(validSeance, BorderLayout.CENTER);
        panel.add(delGrp_Enseignant_Cours, BorderLayout.CENTER);
        panel.add(new JPanel());
        panel.add(new JPanel());
        panel.add(Quitter, BorderLayout.CENTER);
        return panel;
    }
    
    /**
         * button listener generant un popup pour entrer les données pour affecter un enseignant a une seance
    */
    private class affEnseignantSeance_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_affEnseignant PaffE=new Pop_affEnseignant(adm);
        }
    }
    /**
         * button listener generant un popup pour tracer le graphe
    */
    private class Graphe_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Graphes etd = new Graphes("Eleves par TD",adm);
            etd.pack();
            RefineryUtilities.centerFrameOnScreen(etd);
            etd.setVisible(true);
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour affecter un groupe a une seance
    */
    private class affGrpSeance_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_affGroupe afg=new Pop_affGroupe(adm);
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour affecter une seance a une salle
    */
    private class affSalle_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_addSalle as=new Pop_addSalle(adm);
        }
    }
    /**
         * button listener pour quitter
    */
    private class Quitter_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour modifier un cours
    */
    private class modifCours_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour deplacer une seance
    */
    private class DepSeance_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_deplaceSeance ds=new Pop_deplaceSeance(adm);
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour ajouter une seance
    */
    private class addSeance_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_ajoutSeance as=new Pop_ajoutSeance(adm);
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour annuler une seance
    */
    private class annulSeance_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_annulerSeance vs=new Pop_annulerSeance(adm);
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour valider une seance
    */
    private class validSeance_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_valideSeance vs=new Pop_valideSeance(adm);
        }
    }
    /**
         * button listener generant un popup pour entrer les données pour supprimer un enseignant ou un groupe d'une seance
    */
    private class delGrp_Enseignant_Cours_Listener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            Pop_enlevergrpensei f=new Pop_enlevergrpensei(adm);
        }
    }
    
}
