/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VIEW;

import MODEL.Connexion;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

/**
 *
 * @author Kenny-fixe
 */
public class Fenetre_Connexion extends JFrame{
    //classe connexion perso, pas celle de sql
    private Connexion m_co_db=new Connexion();
    
    final private int window_Width = 500;
    final private int window_Height = 400;

    private JPanel panelMessage;
    private JPanel panelID;
    private JPanel panelPassword;
    private JPanel panelLogin;
    private JPanel panelCreateLog;
    private JPanel panel;
    private JPanel paneltext;
    private JPanel panel_text;
    private JPanel panel_return;
    private JPanel panel_close;

    private JLabel Username;
    private JLabel passwordco;
    private JLabel welcome;
    private JTextField ID;
    private JTextField password;
    private JButton login;
    private JButton createLog;
    private JButton close_button;

public Fenetre_Connexion(Connexion co) {
        m_co_db=co;
    
        // JFrame window= new JFrame(); // INUTILE TU ES DEJA DANS UNE FRAME VU QUE TA CLASSE EXTENDS JFRAME
        this.setSize(window_Width, window_Height); // ON PARLE CETTE Objet

        //set a title to the window 
        this.setTitle("User Interface"); //TJRS THIS

        //borderless
        this.setUndecorated(true);
        
        //exit when the window is closed 
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // THIS

        //set the type of layout 
        // this.setLayout(new GridLayout(3,3)); LA FRAME A PAS DE LAYOUT, ELLE POSSEDE JUSTE LE PANEL
        JPanel pan;
        pan = buildPanelInterface1(); // ON RECUPERE LE PANEL 
        this.setContentPane(pan); // ON AJOUTE LE PANEL A LA FRAME

        // window.add(panel);
        //display the window 
        this.setVisible(true);

    }

    //first window (connexion window)
    private JPanel buildPanelInterface1() {

        welcome = new JLabel("welcome !");
        Username = new JLabel("Nom.Prenom");
        passwordco = new JLabel("password");

        //font
        welcome.setFont(new Font("TimesRoman", Font.BOLD, 18));
        Username.setFont(new Font("TimesRoman", Font.BOLD, 18));
        passwordco.setFont(new Font("TimesRoman", Font.BOLD, 18));
        
        //create two text field of 15 characters
        ID = new JTextField(15);
        password = new JTextField(15);
        

        //create two buttons 
        login = new JButton("Login");
        createLog = new JButton("Sign up");
        close_button = new JButton("Close");

        //Color lightblue=new Color(0,153,153,1);
        
        // Add an action listener to the button.
        login.addActionListener(new connectButtonListener());
        close_button.addActionListener(new close_function());

        //fond de l'ecran
        panel = new JPanel();
        panel.setLayout(new GridLayout(4, 3)); // C EST LE PANEL QUI A UN LAYOUT. LA FRAME POSSEDE JUSTE LE PANEL 

//create  blocs panels 
        panelMessage = new JPanel();
        paneltext = new JPanel();
        panel_text = new JPanel();
        panelID = new JPanel();
        panelPassword = new JPanel();
        panelLogin = new JPanel();
        panel_close = new JPanel();

        //add everything to panel
        panelMessage.add(welcome, BorderLayout.CENTER);
        paneltext.add(Username);
        panel_text.add(passwordco);
        panelID.add(ID);
        panelPassword.add(password, BorderLayout.CENTER);
        panelLogin.add(login, BorderLayout.CENTER);
        panel_close.add(close_button);

        
        panel.add(new JPanel());
        //panel.add(panelMessage);*
        panel.add(welcome,BorderLayout.CENTER);
        panel.add(new JPanel());
        panel.add(paneltext, BorderLayout.CENTER);
        panel.add(panelID, BorderLayout.CENTER);
        panel.add(new JPanel());
        panel.add(panel_text, BorderLayout.CENTER);
        panel.add(panelPassword, BorderLayout.CENTER);
        panel.add(new JPanel());
        panel.add(panelLogin, BorderLayout.CENTER);
        panel.add(new JPanel());
        //panel.add(new JPanel());
        panel.add(panel_close, BorderLayout.CENTER);

        
         //COLORS
        login.setBackground(Color.darkGray);
        close_button.setBackground(Color.darkGray);
        //panel.setBackground(Color.white);
        //ID.setBorder(new LineBorder(Color.black,1));
        //password.setBorder(new LineBorder(Color.black,1));
        
        login.setForeground(Color.white);
        close_button.setForeground(Color.white);
        
        return panel;

    }
    
    private class connectButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e) {
            if(m_co_db.verif(ID.getText(), password.getText())){
                //si connexion a marché
                //si etudiant ou prof interface edt, si admin vers inteface admin
                dispose();
            }else if(!m_co_db.verif(ID.getText(), password.getText())){
                //Message d'erreur
                JOptionPane jop = new JOptionPane();
                jop.showMessageDialog(null, "Mauvais identifiant ou mot de passe", "Erreur de connection", JOptionPane.ERROR_MESSAGE);
                dispose();
                Fenetre_Connexion fco=new Fenetre_Connexion(m_co_db);
            }
        }
    }
    private class close_function implements ActionListener
    {
         @Override
        public void actionPerformed(ActionEvent e) {
            dispose();
        }
    }
}