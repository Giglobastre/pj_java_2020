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
public class Pop_enlevergrpensei extends JFrame{
Admin m_adm;
    
    final private   int         window_Width = 500;
    final private   int         window_Height = 400;
    
    private         JPanel      panel;
    private         JPanel      panEnseignant;
    private         JPanel      panCours;
    private         JPanel      panLabelEnseignant;
    private         JPanel      panLabelCours;
    private         JPanel      panBoutton;
    
    private         JTextField  idSeance;
    private         JTextField  idGE;
    
    private         JLabel      entrezSeance;
    private         JLabel      entrezGE;
    private         JLabel      msg;
    
    private         JCheckBox   cb;
    
    private         JButton     valider;
    private         JButton     quitter;
    
    public Pop_enlevergrpensei(Admin adm){
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
        
        entrezSeance=new JLabel("Entrez l'id de la seance");
        entrezGE=new JLabel("Entrez l'id de l'enseignant/groupe");
        msg=new JLabel("Supprimer enseignant ou groupe d'une seance");
        
        idSeance = new JTextField(15);
        idGE = new JTextField(15);
        
        valider=new JButton("Valider");
        quitter=new JButton("Quitter");
        
        cb=new JCheckBox("Groupe");
        cb.setSelected(false);
        
        valider.addActionListener(new validerListener());
        quitter.addActionListener(new quitterListener());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));
        
        panel.add(msg);
        panel.add(cb);
        panel.add(entrezSeance);
        panel.add(idSeance);
        panel.add(entrezGE);
        panel.add(idGE);
        panel.add(quitter);
        panel.add(valider);
        return panel;
    }
    private class validerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            //idCours = id de la seance
            int res=m_adm.enlevergrpensei(!cb.isSelected(),Integer.parseInt(idSeance.getText()), Integer.parseInt(idGE.getText()));
            System.out.println(!cb.isSelected());
            if(res==0){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Seance non trouvée", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if(res==1){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Groupe ou ensiegnant non affecté a cette seance", "Echec", JOptionPane.ERROR_MESSAGE);
            }else if(res==2){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Reussite", "Reussit", JOptionPane.ERROR_MESSAGE);
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