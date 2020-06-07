/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author hugo7
 */
public class CoursAffichage {

    private String date;
    private String HD;
    private String salle;
    private String site;
    private String nom;
    private String groupe;
    private ArrayList< String> prof;
    private ArrayList< String> salletab;
    private ArrayList< String> groupetab;
    private int capacite;
    private int semaine;

    public CoursAffichage() {
    }
    public CoursAffichage(String date, String HD, ArrayList<String> salletab, String site, String nom, String groupe, ArrayList<String> prof, int capacite, ArrayList<String> groupetab) {
        this.date = date;
        this.HD = HD;
        this.salletab = salletab;
        this.site = site;
        this.nom = nom;
        this.groupe = groupe;
        this.prof = prof;
        this.capacite = capacite;
        this.groupetab = groupetab;
     //   semaine=51;

    }

    public CoursAffichage(String date, String HD, String salle, String site, String nom, String groupe, ArrayList<String> prof, int capacite, ArrayList<String> groupetab) {
        this.date = date;
        this.HD = HD;
        this.salle = salle;
        this.site = site;
        this.nom = nom;
        this.groupe = groupe;
        this.prof = prof;
        this.capacite = capacite;
        this.groupetab = groupetab;
     //   semaine=51;

    }

    /**
         * remplis une arraylist d'etudiants
         * 
         * @param groupe, id du groupe
         * @param semaine, semaine que l'on affiche
         * @param listesalle, liste des salles 
         * @param listeutilisateurs, liste des utilisateurs
         * @param listeseandce, liste des seances
         * @param listegroupe, liste des groupes
         * @param listeprof, liste des profs
         * @param listecours, liste des cours
         * @param listeetudiant, liste d'etudiants
         * @param listessalles, liste des salles
         * @param listesite, liste des sites
         * @param groupetab, liste des groupes
         * @return une arraylist d'etudiants
    */
    public ArrayList<CoursAffichage> affichageetudiant(int groupe, int semaine, ArrayList<Salle> listesalle, ArrayList<Utilisateur> listeutilisateur, ArrayList<Seance> listeseance, ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof, ArrayList<Cours> listecours, ArrayList<Etudiant> listeetudiant, ArrayList<Seance_salles> listessalles, ArrayList<Site> listesite, ArrayList<Groupe> groupetab) {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> nomproftab = new ArrayList<>();
        ArrayList<String> nomgrptab = new ArrayList<>();
        ArrayList<String> nomsalletab = new ArrayList<>();
        ArrayList<CoursAffichage> affichage = new ArrayList<>();
        for (int i = 0; i < listegroupe.size(); i++) {
            if (listegroupe.get(i).getID_GROUPE() == groupe) {////On cherche les ID des bonnes seances
                id.add(listegroupe.get(i).getID_SEANCE());
                System.out.println(listegroupe.get(i).getID_SEANCE());
            }
        }
        for (int i = 0; i < listeseance.size(); i++) {//parcours toute les eances
            String nom = "";
            String nomsalle = "";
            String nomprof = "";
            int capacite = 0;
            String nomgrp = "";
            String site = "";
            //nomproftab.clear();
            if (listeseance.get(i).getSEMAINE() == semaine) {
                ///bonne semaine
                for (int j = 0; j < id.size(); j++) { //parcourir pour le nombre de bonne seance
                    if (listeseance.get(i).getID() == id.get(j)) {///////bon TD Bonne semaine Bon seance
                        System.out.println("id seance" + listeseance.get(i).getID());
//System.out.println(listeseance.get(i).getHEURE_DEBUT());
                        // System.out.println("j"+ id.size());
                        //recherche d'autre informations
                        //for(int k=0;k<listeseance.size();k++)//plus d ecours que salle::::::::::::::::::::::::::::::::::::::::::
                        //
                        capacite = 0;
                        for (int m = 0; m < listecours.size(); m++) {
                            if (listecours.get(m).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(m).getNom();
                                System.out.println(nom);
                            }
                        }
                        //System.out.println(listegroupe.get(i).getID_SEANCE());

                        /*for (int l = 0; l < listeutilisateur.size(); l++) {
                             
                            
                         System.out.println("ll"+listeprof.get(i).getID_ENSEIGANT()+"iduti"+listeutilisateur.get(l).getID());
                         if (listeutilisateur.get(l).getID() == listeprof.get(i).getID_ENSEIGANT()) {
                         nomprof = listeutilisateur.get(l).getNOM();
                         // nomproftab.add(listeutilisateur.get(l).getNOM());
                         System.out.println(nomprof);
                         }
                         }*/
                        for (int l = 0; l < listeprof.size(); l++) {
                            if (listeprof.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < listeutilisateur.size(); v++) {
                                    if (listeutilisateur.get(v).getID() == listeprof.get(l).getID_ENSEIGANT()) {
                                        nomprof = nomprof + listeutilisateur.get(v).getNOM() + " ";

                                        //System.out.println(nomprof);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listegroupe.size(); l++) {
                            if (listegroupe.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < groupetab.size(); v++) {
                                    if (groupetab.get(v).getID() == listegroupe.get(l).getID_GROUPE()) {
                                        nomgrp = nomgrp + groupetab.get(v).getNOM() + " ";

                                        System.out.println(nomgrp);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listecours.size(); l++) {
                            if (listecours.get(l).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(l).getNom();
                            }
                        }

                       // System.out.println(nom);
                        for (int e = 0; e < listessalles.size(); e++) {

                                //System.out.println(listesalle.get(j).getID());
                            // System.out.println(listeseance.get(i).getID_COURS());
                            if (listessalles.get(e).getID_SEANCE() == listeseance.get(i).getID())//bon id salle
                            {

                                for (int t = 0; t < listesalle.size(); t++) {
                                    if (listesalle.get(t).getID() == listessalles.get(e).getID_SALLE()) {
                                        nomsalle = nomsalle + listesalle.get(t).getNOM() + " ";
                                        //nomsalle = listesalle.get(t).getNOM();
                                        capacite = capacite + listesalle.get(t).getCAPACITE();
                                        System.out.println(nomsalle);
                                        for (int r = 0; r < listesite.size(); r++) {
                                            if (listesite.get(r).getID() == listesalle.get(t).getID_SITE()) {
                                                site = listesite.get(r).getNom();
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //System.out.println(nomproftab.get(0));
                        //System.out.println(nomproftab.get(1));
                        nomproftab.add(nomprof);
                        nomgrptab.add(nomgrp);
                        nomsalletab.add(nomsalle);
                        nomprof = "";
                        nomgrp = "";
                        nomsalle = "";
                        affichage.add(new CoursAffichage(listeseance.get(i).getDATE(), listeseance.get(i).getHEURE_DEBUT(), nomsalletab, site, nom, "ING3", nomproftab, capacite, nomgrptab));
                        capacite = 0;
                    }
                }
            }
            //if((listeseance.get(id.get(i)).getSEMAINE())==51)
            //System.out.println("ff");
        }

        return affichage;
    }

    /**
         * remplis une arraylist dd'enseignant
         * 
         * @param idprof, id de l'enseignant
         * @param semaine, semaine que l'on affiche
         * @param listesalle, liste des salles 
         * @param listeutilisateur, liste des utilisateurs
         * @param listeseance, liste des seances
         * @param listegroupe, liste des groupes
         * @param listeprof, liste des profs
         * @param listecours, liste des cours
         * @param listeetudiant, liste d'etudiants
         * @param listessalles, liste des salles
         * @param listesite, liste des sites
         * @param groupetab, liste des groupes
         * @return une arraylist d'enseignant
    */
    public ArrayList<CoursAffichage> affichageprof(int idprof, int semaine, ArrayList<Salle> listesalle, ArrayList<Utilisateur> listeutilisateur, ArrayList<Seance> listeseance, ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof, ArrayList<Cours> listecours, ArrayList<Etudiant> listeetudiant, ArrayList<Seance_salles> listessalles, ArrayList<Site> listesite, ArrayList<Groupe> groupetab) {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> nomproftab = new ArrayList<>();
        ArrayList<String> nomgrptab = new ArrayList<>();
        ArrayList<String> nomsalletab = new ArrayList<>();
        ArrayList<CoursAffichage> affichage = new ArrayList<>();
        for (int i = 0; i < listeprof.size(); i++) {
            if (listeprof.get(i).getID_ENSEIGANT() == idprof) {////On cherche les ID des bonnes seances
                id.add(listeprof.get(i).getID_SEANCE());
//                System.out.println(listegroupe.get(i).getID_SEANCE());
            }
        }
        for (int i = 0; i < listeseance.size(); i++) {//parcours toute les eances
            String nom = "";
            String nomsalle = "";
            String nomprof = "";
            int capacite = 0;
            String nomgrp = "";
            String site = "";
            //nomproftab.clear();
            if (listeseance.get(i).getSEMAINE() == semaine) {
                ///bonne semaine
                for (int j = 0; j < id.size(); j++) { //parcourir pour le nombre de bonne seance
                    if (listeseance.get(i).getID() == id.get(j)) {///////bon TD Bonne semaine Bon seance
                        System.out.println("id seance" + listeseance.get(i).getID());
//System.out.println(listeseance.get(i).getHEURE_DEBUT());
                        // System.out.println("j"+ id.size());
                        //recherche d'autre informations
                        //for(int k=0;k<listeseance.size();k++)//plus d ecours que salle::::::::::::::::::::::::::::::::::::::::::
                        //{
                        for (int m = 0; m < listecours.size(); m++) {
                            if (listecours.get(m).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(m).getNom();
                                System.out.println(nom);
                            }
                        }
                        //System.out.println(listegroupe.get(i).getID_SEANCE());

                        /*for (int l = 0; l < listeutilisateur.size(); l++) {
                             
                            
                         System.out.println("ll"+listeprof.get(i).getID_ENSEIGANT()+"iduti"+listeutilisateur.get(l).getID());
                         if (listeutilisateur.get(l).getID() == listeprof.get(i).getID_ENSEIGANT()) {
                         nomprof = listeutilisateur.get(l).getNOM();
                         // nomproftab.add(listeutilisateur.get(l).getNOM());
                         System.out.println(nomprof);
                         }
                         }*/
                        for (int l = 0; l < listeprof.size(); l++) {
                            if (listeprof.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < listeutilisateur.size(); v++) {
                                    if (listeutilisateur.get(v).getID() == listeprof.get(l).getID_ENSEIGANT()) {
                                        nomprof = nomprof + listeutilisateur.get(v).getNOM() + " ";

                                        //System.out.println(nomprof);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listegroupe.size(); l++) {
                            if (listegroupe.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < groupetab.size(); v++) {
                                    if (groupetab.get(v).getID() == listegroupe.get(l).getID_GROUPE()) {
                                        nomgrp = nomgrp + groupetab.get(v).getNOM() + " ";

                                        System.out.println(nomgrp);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listecours.size(); l++) {
                            if (listecours.get(l).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(l).getNom();
                            }
                        }

                       // System.out.println(nom);
                        for (int e = 0; e < listessalles.size(); e++) {

                                //System.out.println(listesalle.get(j).getID());
                            // System.out.println(listeseance.get(i).getID_COURS());
                            if (listessalles.get(e).getID_SEANCE() == listeseance.get(i).getID())//bon id salle
                            {

                                for (int t = 0; t < listesalle.size(); t++) {
                                    if (listesalle.get(t).getID() == listessalles.get(e).getID_SALLE()) {
                                        nomsalle = nomsalle + listesalle.get(t).getNOM() + " ";
                                        //nomsalle = listesalle.get(t).getNOM();
                                        capacite = listesalle.get(t).getCAPACITE();
                                        System.out.println(nomsalle);
                                        for (int r = 0; r < listesite.size(); r++) {
                                            if (listesite.get(r).getID() == listesalle.get(t).getID_SITE()) {
                                                site = listesite.get(r).getNom();
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //System.out.println(nomproftab.get(0));
                        //System.out.println(nomproftab.get(1));
                        nomproftab.add(nomprof);
                        nomgrptab.add(nomgrp);
                        nomsalletab.add(nomsalle);
                        nomprof = "";
                        nomgrp = "";
                        nomsalle = "";
                        affichage.add(new CoursAffichage(listeseance.get(i).getDATE(), listeseance.get(i).getHEURE_DEBUT(), nomsalletab, site, nom, "ING3", nomproftab, capacite, nomgrptab));

                    }
                }
            }
            //if((listeseance.get(id.get(i)).getSEMAINE())==51)
            //System.out.println("ff");
        }

        return affichage;
    }

    /**
         * remplis une arraylist de salle
         * 
         * @param idsalle, id de la salle
         * @param semaine, semaine que l'on affiche
         * @param listesalle, liste des salles 
         * @param listeutilisateur, liste des utilisateurs
         * @param listeseance, liste des seances
         * @param listegroupe, liste des groupes
         * @param listeprof, liste des profs
         * @param listecours, liste des cours
         * @param listeetudiant, liste d'etudiants
         * @param listessalles, liste des salles
         * @param listesite, liste des sites
         * @param groupe, liste des groupes
         * @return une arraylist de salles
    */
    public ArrayList<CoursAffichage> affichageclasse(int idsalle, int semaine, ArrayList<Salle> listesalle, ArrayList<Utilisateur> listeutilisateur, ArrayList<Seance> listeseance, ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof, ArrayList<Cours> listecours, ArrayList<Etudiant> listeetudiant, ArrayList<Seance_salles> listessalles, ArrayList<Site> listesite, ArrayList<Groupe> groupe) {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> nomproftab = new ArrayList<>();
        ArrayList<String> nomgrptab = new ArrayList<>();
        ArrayList<CoursAffichage> affichage = new ArrayList<>();
        for (int i = 0; i < listessalles.size(); i++) {
            if (listessalles.get(i).getID_SALLE() == idsalle) {////On cherche les ID des bonnes seances
                id.add(listessalles.get(i).getID_SEANCE());
                //System.out.println(listegroupe.get(i).getID_SEANCE());
            }
        }
        for (int i = 0; i < listeseance.size(); i++) {//parcours toute les eances
            String nom = "";
            String nomsalle = "";
            String nomprof = "";
            int capacite = 0;
            String nomgrp = "";
            String site = "";
            //nomproftab.clear();
            if (listeseance.get(i).getSEMAINE() == semaine) {
                ///bonne semaine
                for (int j = 0; j < id.size(); j++) { //parcourir pour le nombre de bonne seance
                    if (listeseance.get(i).getID() == id.get(j)) {///////bon TD Bonne semaine Bon seance
                        System.out.println("id seance" + listeseance.get(i).getID());
//System.out.println(listeseance.get(i).getHEURE_DEBUT());
                        // System.out.println("j"+ id.size());
                        //recherche d'autre informations
                        //for(int k=0;k<listeseance.size();k++)//plus d ecours que salle::::::::::::::::::::::::::::::::::::::::::
                        //{
                        for (int m = 0; m < listecours.size(); m++) {
                            if (listecours.get(m).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(m).getNom();
                                System.out.println(nom);
                            }
                        }
                        //System.out.println(listegroupe.get(i).getID_SEANCE());

                        /*for (int l = 0; l < listeutilisateur.size(); l++) {
                             
                            
                         System.out.println("ll"+listeprof.get(i).getID_ENSEIGANT()+"iduti"+listeutilisateur.get(l).getID());
                         if (listeutilisateur.get(l).getID() == listeprof.get(i).getID_ENSEIGANT()) {
                         nomprof = listeutilisateur.get(l).getNOM();
                         // nomproftab.add(listeutilisateur.get(l).getNOM());
                         System.out.println(nomprof);
                         }
                         }*/
                        for (int l = 0; l < listeprof.size(); l++) {
                            if (listeprof.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < listeutilisateur.size(); v++) {
                                    if (listeutilisateur.get(v).getID() == listeprof.get(l).getID_ENSEIGANT()) {
                                        nomprof = nomprof + listeutilisateur.get(v).getNOM() + " ";

                                        //System.out.println(nomprof);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listegroupe.size(); l++) {
                            if (listegroupe.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < groupe.size(); v++) {
                                    if (groupe.get(v).getID() == listegroupe.get(l).getID_GROUPE()) {
                                        nomgrp = nomgrp + groupe.get(v).getNOM() + " ";

                                        System.out.println(nomgrp);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listecours.size(); l++) {
                            if (listecours.get(l).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(l).getNom();
                            }
                        }

                       // System.out.println(nom);
                        for (int e = 0; e < listessalles.size(); e++) {

                                //System.out.println(listesalle.get(j).getID());
                            // System.out.println(listeseance.get(i).getID_COURS());
                            if (listessalles.get(e).getID_SEANCE() == listeseance.get(i).getID())//bon id salle
                            {

                                for (int t = 0; t < listesalle.size(); t++) {
                                    if (listesalle.get(t).getID() == listessalles.get(e).getID_SALLE()) {

                                        nomsalle = listesalle.get(t).getNOM();
                                        capacite = listesalle.get(t).getCAPACITE();
                                        System.out.println(nomsalle);
                                        for (int r = 0; r < listesite.size(); r++) {
                                            if (listesite.get(r).getID() == listesalle.get(t).getID_SITE()) {
                                                site = listesite.get(r).getNom();
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //System.out.println(nomproftab.get(0));
                        //System.out.println(nomproftab.get(1));
                        nomproftab.add(nomprof);
                        nomgrptab.add(nomgrp);
                        nomprof = "";
                        nomgrp = "";
                        affichage.add(new CoursAffichage(listeseance.get(i).getDATE(), listeseance.get(i).getHEURE_DEBUT(), nomsalle, site, nom, "ING3", nomproftab, capacite, nomgrptab));

                    }
                }
            }
            //if((listeseance.get(id.get(i)).getSEMAINE())==51)
            //System.out.println("ff");
        }

        return affichage;
    }

    /**
         * remplis une arraylist des seances déja finie
         * 
         * @param idprof, id de l'enseignant
         * @param semaine, semaine que l'on affiche
         * @param listesalle, liste des salles 
         * @param listeutilisateur, liste des utilisateurs
         * @param listeseance, liste des seances
         * @param listegroupe, liste des groupes
         * @param listeprof, liste des profs
         * @param listecours, liste des cours
         * @param listeetudiant, liste d'etudiants
         * @param listessalles, liste des salles
         * @param listesite, liste des sites
         * @param groupe, liste des groupes
         * @return une arraylist de salles
    */
    public ArrayList<CoursAffichage> affichageautre(int idprof, int semaine, ArrayList<Salle> listesalle, ArrayList<Utilisateur> listeutilisateur, ArrayList<Seance> listeseance, ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof, ArrayList<Cours> listecours, ArrayList<Etudiant> listeetudiant, ArrayList<Seance_salles> listessalles, ArrayList<Site> listesite, ArrayList<Groupe> groupe, String DD, String DF) {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<String> nomproftab = new ArrayList<>();
        ArrayList<String> nomgrptab = new ArrayList<>();
        ArrayList<String> nomsalletab= new ArrayList<>();
        LocalDate predate = LocalDate.of(2020, 05, 27);
        ArrayList<CoursAffichage> affichage = new ArrayList<>();

        final String SEPARATEUR = "/";

        String mots[] = DD.split(SEPARATEUR);
        int jour = Integer.parseInt(mots[0]);
        int mois = Integer.parseInt(mots[1]);
        int annee = Integer.parseInt(mots[2]);
        LocalDate Dd = LocalDate.of(annee, mois, jour);

        final String SEPARATEURe = "/";

        String motse[] = DF.split(SEPARATEURe);
        int joure = Integer.parseInt(motse[0]);
        int moise = Integer.parseInt(motse[1]);
        int anneee = Integer.parseInt(motse[2]);
        LocalDate Df = LocalDate.of(anneee, moise, joure);

        for (int i = 0; i < listeprof.size(); i++) {
            if (listeprof.get(i).getID_ENSEIGANT() == idprof) {
////On cherche les ID des bonnes seances
                for (int k = 0; k < listeseance.size(); k++) {
                    if (listeseance.get(k).getID() == listeprof.get(i).getID_SEANCE()) {
                        final String eSEPARATEUR = "/";
                        String dateseance = listeseance.get(k).getDATE();
                        String emots[] = dateseance.split(eSEPARATEUR);
                        int ejour = Integer.parseInt(emots[0]);
                        int emois = Integer.parseInt(emots[1]);
                        int eannee = Integer.parseInt(emots[2]);
                        LocalDate localDate = LocalDate.of(eannee, emois, ejour);
                        if ((localDate.isBefore(Df) || localDate.isEqual(Df)) && (localDate.isAfter(Dd) || localDate.isEqual(Dd))) {
                            id.add(listeprof.get(i).getID_SEANCE());
                           
                        }
                    }
                }
            }
        }
        for (int i = 0; i < listeseance.size(); i++) {//parcours toute les eances
            String nom = "";
            String nomsalle = "";
            String nomprof = "";
            int capacite = 0;
            String nomgrp = "";
            String site = "";
            //nomproftab.clear();
            if (listeseance.get(i).getSEMAINE() == semaine) {
                ///bonne semaine
                for (int j = 0; j < id.size(); j++) { //parcourir pour le nombre de bonne seance
                    if (listeseance.get(i).getID() == id.get(j)) {///////bon TD Bonne semaine Bon seance
                        System.out.println("id seance" + listeseance.get(i).getID());
//System.out.println(listeseance.get(i).getHEURE_DEBUT());
                        // System.out.println("j"+ id.size());
                        //recherche d'autre informations
                        //for(int k=0;k<listeseance.size();k++)//plus d ecours que salle::::::::::::::::::::::::::::::::::::::::::
                        //{
                        for (int m = 0; m < listecours.size(); m++) {
                            if (listecours.get(m).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(m).getNom();
                                System.out.println(nom);
                            }
                        }
                        //System.out.println(listegroupe.get(i).getID_SEANCE());

                        /*for (int l = 0; l < listeutilisateur.size(); l++) {
                             
                            
                         System.out.println("ll"+listeprof.get(i).getID_ENSEIGANT()+"iduti"+listeutilisateur.get(l).getID());
                         if (listeutilisateur.get(l).getID() == listeprof.get(i).getID_ENSEIGANT()) {
                         nomprof = listeutilisateur.get(l).getNOM();
                         // nomproftab.add(listeutilisateur.get(l).getNOM());
                         System.out.println(nomprof);
                         }
                         }*/
                        for (int l = 0; l < listeprof.size(); l++) {
                            if (listeprof.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < listeutilisateur.size(); v++) {
                                    if (listeutilisateur.get(v).getID() == listeprof.get(l).getID_ENSEIGANT()) {
                                        nomprof = nomprof + listeutilisateur.get(v).getNOM() + " ";

                                        //System.out.println(nomprof);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listegroupe.size(); l++) {
                            if (listegroupe.get(l).getID_SEANCE() == id.get(j)) {
                                for (int v = 0; v < groupe.size(); v++) {
                                    if (groupe.get(v).getID() == listegroupe.get(l).getID_GROUPE()) {
                                        nomgrp = nomgrp + groupe.get(v).getNOM() + " ";

                                        System.out.println(nomgrp);
                                    }
                                }
                            }
                        }
                        for (int l = 0; l < listecours.size(); l++) {
                            if (listecours.get(l).getiD() == listeseance.get(i).getID_COURS()) {
                                nom = listecours.get(l).getNom();
                            }
                        }

                       // System.out.println(nom);
                        for (int e = 0; e < listessalles.size(); e++) {

                                //System.out.println(listesalle.get(j).getID());
                            // System.out.println(listeseance.get(i).getID_COURS());
                            if (listessalles.get(e).getID_SEANCE() == listeseance.get(i).getID())//bon id salle
                            {

                                for (int t = 0; t < listesalle.size(); t++) {
                                    if (listesalle.get(t).getID() == listessalles.get(e).getID_SALLE()) {
                                        nomsalle = nomsalle + listesalle.get(t).getNOM() + " ";
                                        //nomsalle = listesalle.get(t).getNOM();
                                        capacite = listesalle.get(t).getCAPACITE();
                                        System.out.println(nomsalle);
                                        for (int r = 0; r < listesite.size(); r++) {
                                            if (listesite.get(r).getID() == listesalle.get(t).getID_SITE()) {
                                                site = listesite.get(r).getNom();
                                            }
                                        }
                                    }
                                }

                            }
                        }
                        //System.out.println(nomproftab.get(0));
                        //System.out.println(nomproftab.get(1));
                        nomproftab.add(nomprof);
                        nomgrptab.add(nomgrp);
                        nomsalletab.add(nomsalle);
                        nomprof = "";
                        nomgrp = "";
                        nomsalle="";
                        affichage.add(new CoursAffichage(listeseance.get(i).getDATE(),listeseance.get(i).getHEURE_DEBUT(), nomsalletab,site,nom, "ING3", nomproftab,  capacite,nomgrptab));

                    }
                }
            }
            //if((listeseance.get(id.get(i)).getSEMAINE())==51)
            //System.out.println("ff");
        }

        return affichage;
    }

    public String getNom() {
        return nom;
    }

    public String getDate() {
        return date;
    }

    public int getCapacite() {
        return capacite;
    }

    public ArrayList<String> getProf() {
        return prof;
    }

    public String getHD() {
        return HD;
    }

    public String getGroupe() {
        return groupe;
    }

    public String getSalle() {
        return salle;
    }

    public String getSite() {
        return site;
    }

    public void setSemaine(int semaine) {
        this.semaine = semaine;
    }

    public ArrayList<String> getGroupetab() {
        return groupetab;
    }

    public ArrayList<String> getSalletab() {
        return salletab;
    }

}
