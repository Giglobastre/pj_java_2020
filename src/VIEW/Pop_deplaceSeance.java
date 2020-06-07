/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**
 *
 * @author Kenny-fixe
 */
public class Pop_deplaceSeance extends JFrame{
Admin m_adm;
    
    final private   int         window_Width = 500;
    final private   int         window_Height = 400;
    
    private         JPanel      panel;
    private         JPanel      panEnseignant;
    private         JPanel      panCours;
    private         JPanel      panLabelEnseignant;
    private         JPanel      panLabelCours;
    private         JPanel      panBoutton;
    private         JPanel      panCb;
    
    private         JTextField  idSeance;
    private         JTextField  idGE;
    private         JTextField  cb;
    
    private         JLabel      entrezSeance;
    private         JLabel      entrezGE;
    private         JLabel      entrezcb;
    private         JLabel      msg;
    
    private         JButton     valider;
    private         JButton     quitter;
    
    public Pop_deplaceSeance(Admin adm){
        m_adm=adm;
        
        this.setSize(window_Width, window_Height); 

        this.setTitle("Admin Interface");

        this.setUndecorated(true);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel pan;
        pan = buildPanelInterface();
        this.setContentPane(pan);

        this.setVisible(true);   
    }
    
    /**
         * cree le jpanel
         * @return le jpanel
    */
    private JPanel buildPanelInterface() {
        
        entrezSeance=new JLabel("Entrez l'id de la seance");
        entrezGE=new JLabel("Entrez la date : '/' ");
        entrezcb=new JLabel("Entrez l'heure de debut : ':' ");
        msg=new JLabel("Deplacer une seance");
        
        idSeance = new JTextField(15);
        idGE = new JTextField(15);
        cb = new JTextField(15);
        
        valider=new JButton("Valider");
        quitter=new JButton("Quitter");
        
        valider.addActionListener(new validerListener());
        quitter.addActionListener(new quitterListener());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(5, 2));
        
        panel.add(msg);
        panel.add(new JPanel());
        panel.add(entrezSeance);
        panel.add(idSeance);
        panel.add(entrezGE);
        panel.add(idGE);
        panel.add(entrezcb);
        panel.add(cb);
        panel.add(quitter);
        panel.add(valider);
        return panel;
    }
    /**
         * button listener  pour valider l'action
    */
    private class validerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //idCours = id de la seance
            int res=m_adm.deplacerceance(idGE.getText(),cb.getText(),Integer.parseInt(idSeance.getText()));
            if(res==0){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Seance non trouvée", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if(res==1){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Un groupe a deja cours", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if(res==2){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Reussite", "Reussite", JOptionPane.ERROR_MESSAGE);
            }
            else if(res==12){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Hoaire non comforme", "Echec", JOptionPane.ERROR_MESSAGE);
            }
            else if(res==4){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Prof a deja cours", "Echec", JOptionPane.ERROR_MESSAGE);
            }
            else if(res==6){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "La classe est pas dispo", "Echec", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    /**
         * button listener  pour quitter
    */
    private class quitterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}