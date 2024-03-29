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
public class Pop_affEnseignant extends JFrame{
    Admin m_adm;
    
    final private   int         window_Width = 500;
    final private   int         window_Height = 400;
    
    private         JPanel      panel;
    private         JPanel      panEnseignant;
    private         JPanel      panCours;
    private         JPanel      panLabelEnseignant;
    private         JPanel      panLabelCours;
    private         JPanel      panBoutton;
    
    private         JTextField  idEnseignant;
    private         JTextField  idCours;
    
    private         JLabel      entrezEnseignant;
    private         JLabel      entrezCours;
    private         JLabel      msg;
    
    private         JButton     valider;
    private         JButton     quitter;
    
    public Pop_affEnseignant(Admin adm){
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
    
    private JPanel buildPanelInterface() {
        
        entrezEnseignant=new JLabel("Entrez l'id du cours");
        entrezCours=new JLabel("Entrez l'id de l'enseignant");
        msg=new JLabel("Affecter un enseignant a un cours");
        
        idEnseignant = new JTextField(15);
        idCours = new JTextField(15);
        
        valider=new JButton("Valider");
        quitter=new JButton("Quitter");
        
        valider.addActionListener(new validerListener());
        quitter.addActionListener(new quitterListener());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        panel.add(msg);
        panel.add(new JPanel());
        panel.add(entrezEnseignant);
        panel.add(idEnseignant);
        panel.add(entrezCours);
        panel.add(idCours);
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
            int res=m_adm.ajouterprof(Integer.parseInt(idEnseignant.getText()), Integer.parseInt(idCours.getText()));
            if (res==0){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "L'enseignant est déja affecté", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if (res==1){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null,  "Enseignant déja en cours","Echec", JOptionPane.ERROR_MESSAGE);
            }else if (res==2){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Enseignant n'existe pas", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if (res==3){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Seance n'existe pas", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if (res==10){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Affectation reussie", "Reussite", JOptionPane.ERROR_MESSAGE);
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
