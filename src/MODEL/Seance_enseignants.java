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
public class Seance_enseignants {
    
    private int ID_SEANCE;
    private int ID_ENSEIGANT;

    public Seance_enseignants() {
    }

    public Seance_enseignants(int ID_SEANCE, int ID_ENSEIGANT) {
        this.ID_SEANCE = ID_SEANCE;
        this.ID_ENSEIGANT = ID_ENSEIGANT;
    }

    public int getID_ENSEIGANT() {
        return ID_ENSEIGANT;
    }

    public int getID_SEANCE() {
        return ID_SEANCE;
    }
    
    
}
