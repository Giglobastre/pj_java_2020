/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MODEL;

/**
 *
 * @author hugo7
 */
public class Salle {
    private int ID;
    private String NOM;
    private int CAPACITE;
    private int ID_SITE;

    public Salle() {
    }

    public Salle(int ID, String NOM, int CAPACITE, int ID_SITE) {
        this.ID = ID;
        this.NOM = NOM;
        this.CAPACITE = CAPACITE;
        this.ID_SITE = ID_SITE;
    }

    public int getID() {
        return ID;
    }

    public String getNOM() {
        return NOM;
    }

    public int getID_SITE() {
        return ID_SITE;
    }

    public int getCAPACITE() {
        return CAPACITE;
    }
    
    
}
