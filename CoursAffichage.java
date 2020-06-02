/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;

import java.util.ArrayList;


public class CoursAffichage {
    private String date;
    private String HD;
    private String salle;
    private String site;
   private String nom;
    private String groupe;
    private  String prof;
    private int capacite;
    private int semaine;

    public CoursAffichage() {
    }

    public CoursAffichage(String date, String HD, String salle, String site,String nom,  String groupe, String prof,int capacite) {
        this.date = date;
        this.HD = HD;
        this.salle = salle;
        this.site = site;
      this.nom=nom;
        this.groupe = groupe;
        this.prof = prof;
        this.capacite=capacite;
     //   semaine=51;
        
    }
    public ArrayList<CoursAffichage> affichageetudiant(int groupe,int semaine, ArrayList<Salle> listesalle, ArrayList<Utilisateur> listeutilisateur, ArrayList<Seance> listeseance, ArrayList<Seance_groupes> listegroupe, ArrayList<Seance_enseignants> listeprof, ArrayList<Cours> listecours, ArrayList<Etudiant> listeetudiant, ArrayList<Seance_salles> listessalles,ArrayList<Site> listesite)
    {
        ArrayList<Integer> id = new ArrayList<>();
        ArrayList<CoursAffichage> affichage = new ArrayList<>();
        for (int i = 0; i < listegroupe.size(); i++) {
            if (listegroupe.get(i).getID_GROUPE() == groupe) {////On cherche les ID des bonnes seances
                id.add(listegroupe.get(i).getID_SEANCE());

            }
        }

        for (int i = 0; i < listeseance.size(); i++) {//parcours toute les eances
            String nom = "";
            String nomsalle = "";
            String nomprof = "";
            int capacite = 0;
            String site="";
            if (listeseance.get(i).getSEMAINE() == semaine) { ///bonne semaine
                for (int j = 0; j < id.size(); j++) { //parcourir pour le nombre de bonne seance
                    if (listeseance.get(i).getID() == id.get(j)) {///////bon TD Bonne semaine Bon seance
                       System.out.println("id seance"+listeseance.get(i).getID());
//System.out.println(listeseance.get(i).getHEURE_DEBUT());
                       // System.out.println("j"+ id.size());
                        //recherche d'autre informations
                        //for(int k=0;k<listeseance.size();k++)//plus d ecours que salle::::::::::::::::::::::::::::::::::::::::::
                        //{
                        for(int m=0;m<listecours.size();m++)
                        {
                        if (listecours.get(m).getiD() == listeseance.get(i).getID_COURS()) {
                            nom = listecours.get(m).getNom();
                            System.out.println(nom);
                        }}
                        //System.out.println(listegroupe.get(i).getID_SEANCE());
                       
                        for (int l = 0; l < listeutilisateur.size(); l++) {
                             
                            
                              //  System.out.println("ll"+listeprof.get(i).getID_ENSEIGANT()+"iduti"+listeutilisateur.get(l).getID());
                            if (listeutilisateur.get(l).getID() == listeprof.get(i).getID_ENSEIGANT()) {
                                nomprof = listeutilisateur.get(l).getNOM();
                                System.out.println(nomprof);
                            }
                        }
                        for(int l=0;l<listecours.size();l++)
                        {
                            if(listecours.get(l).getiD()==listeseance.get(i).getID_COURS())
                            nom = listecours.get(l).getNom();
                        }
                        
                       // System.out.println(nom);
                       
                        for(int e=0;e<listessalles.size();e++)
                        {
                            
                                //System.out.println(listesalle.get(j).getID());
                               // System.out.println(listeseance.get(i).getID_COURS());
                            if (listessalles.get(e).getID_SEANCE() == listeseance.get(i).getID())//bon id salle
                            {
                         
                                for(int t=0;t<listesalle.size();t++)
                                {
                                    if(listesalle.get(t).getID()==listessalles.get(e).getID_SALLE())
                                    {
                                 
                                nomsalle = listesalle.get(t).getNOM();
                                capacite = listesalle.get(t).getCAPACITE();
                                System.out.println(nomsalle);
                                for(int r=0;r<listesite.size();r++)
                                {
                                    if(listesite.get(r).getID()==listesalle.get(t).getID_SITE())
                                        site=listesite.get(r).getNom();
                                }
                                    }
                                }
                                

                            }
                        }
                       
//}
                        System.out.println("kkkkk");
                        affichage.add(new CoursAffichage(listeseance.get(i).getDATE(),listeseance.get(i).getHEURE_DEBUT(), nomsalle,site,nom, "ING3", nomprof,  capacite));
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

    public String getProf() {
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
    
}
