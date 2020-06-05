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
import java.util.ArrayList;
/**
 *
 * @author Kenny-fixe
 */
public class Pop_ajoutSeance extends JFrame{
    Admin m_adm;
    
    final private   int         window_Width = 500;
    final private   int         window_Height = 400;
    
    private         JPanel      panel;
    
    private         JTextField  tfDate;
    private         JTextField  tfHD;
    private         JTextField  tfEtat;
    private         JTextField  tfIdc;
    private         JTextField  tfIdt;
    private         JTextField  tfIdp;
    private         JTextField  tfIdg;
    private         JTextField  tfIds;
    
    private         JLabel      jlDate;
    private         JLabel      jlHD;
    private         JLabel      jlEtat;
    private         JLabel      jlIdc;
    private         JLabel      jlIdt;
    private         JLabel      jlIdp;
    private         JLabel      jlIdg;
    private         JLabel      jlIds;
    private         JLabel      msg;
    
    private         JButton     valider;
    private         JButton     quitter;
    
    public Pop_ajoutSeance(Admin adm){
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
        
        jlDate  =   new JLabel("Date : '/'");
        jlHD    =   new JLabel("Heure debut : ':'");
        jlEtat  =   new JLabel("Etat");
        jlIdc   =   new JLabel("Id cours");
        jlIdt   =   new JLabel("Id type");
        jlIdp   =   new JLabel("Id prof : / si plusieurs");
        jlIdg   =   new JLabel("Id groupe : / si plusieurs");
        jlIds   =   new JLabel("Id salle : / si plusieurs");
        msg     =   new JLabel("Ajouter une seance");
        
        tfDate  =   new JTextField(15);;
        tfHD    =   new JTextField(15);;
        tfEtat  =   new JTextField(15);;
        tfIdc   =   new JTextField(15);;
        tfIdt   =   new JTextField(15);;
        tfIdp   =   new JTextField(15);;
        tfIdg   =   new JTextField(15);;
        tfIds   =   new JTextField(15);;
        
        
        valider=new JButton("Valider");
        quitter=new JButton("Quitter");
        
        valider.addActionListener(new validerListener());
        quitter.addActionListener(new quitterListener());
        
        panel = new JPanel();
        panel.setLayout(new GridLayout(10, 2));
        
        panel.add(msg);
        panel.add(new JPanel());
        
        panel.add(jlDate);
        panel.add(tfDate);
        
        panel.add(jlHD);
        panel.add(tfHD);
        
        panel.add(jlEtat);
        panel.add(tfEtat);
        
        panel.add(jlIdc);
        panel.add(tfIdc);
        
        panel.add(jlIdt);
        panel.add(tfIdt);
        
        panel.add(jlIdp);
        panel.add(tfIdp);
        
        panel.add(jlIdg);
        panel.add(tfIdg);
        
        panel.add(jlIds);
        panel.add(tfIds);
        
        panel.add(quitter);
        panel.add(valider);
        return panel;
    }
        /*tfDate = new JTextField(15);;
        tfHD = new JTextField(15);;
        tfEtat = new JTextField(15);;
        tfIdc = new JTextField(15);;
        tfIdt = new JTextField(15);;
        tfIdp = new JTextField(15);;
        tfIdg = new JTextField(15);;
        tfIds = new JTextField(15);;*/
    //String date, String hd, int etat, int idcours, int idtype, ArrayList<Integer> idprof, ArrayList<Integer> idgroupe,ArrayList<Integer> idsalle
    private class validerListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String tmp=new String();
            //sep arraylist
            ArrayList<Integer> idp=new ArrayList<>();
            for(int i=0;i<tfIdp.getText().length();i++){
                if(tfIdp.getText().charAt(i)!='/'){
                    tmp+=tfIdp.getText().charAt(i);
                }else if(tfIdp.getText().charAt(i)=='/'){
                    idp.add(Integer.parseInt(tmp));
                    tmp=null;
                }
            }
            tmp=null;
                       
            ArrayList<Integer> idg=new ArrayList<>();
            for(int i=0;i<tfIdg.getText().length();i++){
                if(tfIdg.getText().charAt(i)!='/'){
                    tmp+=tfIdg.getText().charAt(i);
                }else if(tfIdg.getText().charAt(i)=='/'){
                    idg.add(Integer.parseInt(tmp));
                    tmp=null;
                }
            }
            tmp=null;
            
            ArrayList<Integer> ids=new ArrayList<>();
            for(int i=0;i<tfIds.getText().length();i++){
                if(tfIds.getText().charAt(i)!='/'){
                    tmp+=tfIds.getText().charAt(i);
                }else if(tfIds.getText().charAt(i)=='/'){
                    ids.add(Integer.parseInt(tmp));
                    tmp=null;
                }
            }
             
            //idCours = id de la seance
            int res=m_adm.ajoutseeance(tfDate.getText(), 
                                      tfHD.getText(),
                                      Integer.parseInt(tfEtat.getText()),
                                      Integer.parseInt(tfIdc.getText()),
                                      Integer.parseInt(tfIdt.getText()),
                                      idp,idg,ids);
            
            if (res==20){
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Affectation reussie", "Reussite", JOptionPane.ERROR_MESSAGE);
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
