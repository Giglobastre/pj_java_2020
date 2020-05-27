/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.HeadlessException;
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

    public EdtDisplay() {
        tabpanel = new JPanel[63];

        setLayout(new GridLayout(9, 7));

        setTitle("What do you want to do ");
        setSize(800, 1000);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        buildPanel();
        buildheure(tabpanel);
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

    private void buildheure(JPanel[] tabpanel) {
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
        tabpanel[15].setBackground(new Color(112, 213, 254));

    }

    public static void main(String[] args) {
        new EdtDisplay();
    }

}
