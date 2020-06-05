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
public class Pop_valideSeance extends JFrame{
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
    
    public Pop_valideSeance(Admin adm){
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
        
        entrezEnseignant=new JLabel("Entrez l'id du cours a valider");
        //entrezCours=new JLabel("Entrez l'id de l'enseignant");
        //msg=new JLabel("Affecter un enseignant a un cours");
        
        //idEnseignant = new JTextField(15);
        idCours = new JTextField(15);
        
        valider=new JButton("Valider");
        quitter=new JButton("Quitter");
        
        valider.addActionListener(new validerListener());
        quitter.addActionListener(new quitterListener());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(3, 2));
        
        panel.add(msg);
        panel.add(new JPanel());
        panel.add(entrezCours);
        panel.add(idCours);
        panel.add(quitter);
        panel.add(valider);
        return panel;
    }
    private class validerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //idCours = id de la seance
            int res=m_adm.validerseance(Integer.parseInt(idCours.getText()));
            if (res==0){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Cours non trouvé", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if (res==1){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Cours validé", "Reussite", JOptionPane.ERROR_MESSAGE);
            }
        }
    }
    private class quitterListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}
