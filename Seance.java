/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ProjetJava;

/**
 *
 * @author hugo7
 */
public class Seance {
    private int ID;
    private int SEMAINE;
    private String DATE;
    private String HEURE_DEBUT;
    private String HEURE_FIN;
    private int ETAT;
    private int ID_COURS;
    private int ID_TYPE;

    public Seance() {
    }

    public Seance(int ID, int SEMAINE, String DATE, String HEURE_DEBUT, String HEURE_FIN, int ETAT, int ID_COURS, int ID_TYPE) {
        this.ID = ID;
        this.SEMAINE = SEMAINE;
        this.DATE = DATE;
        this.HEURE_DEBUT = HEURE_DEBUT;
        this.HEURE_FIN = HEURE_FIN;
        this.ETAT = ETAT;
        this.ID_COURS = ID_COURS;
        this.ID_TYPE = ID_TYPE;
    }

    public String getDATE() {
        return DATE;
    }

    public String getHEURE_DEBUT() {
        return HEURE_DEBUT;
    }

    public int getETAT() {
        return ETAT;
    }

    public String getHEURE_FIN() {
        return HEURE_FIN;
    }

    public int getID_COURS() {
        return ID_COURS;
    }

    public int getID() {
        return ID;
    }

    public int getID_TYPE() {
        return ID_TYPE;
    }

    public int getSEMAINE() {
        return SEMAINE;
    }
    
    
}
