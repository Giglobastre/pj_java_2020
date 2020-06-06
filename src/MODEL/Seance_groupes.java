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
public class Seance_groupes {
    private int ID_SEANCE;
   
    private int ID_GROUPE;

    public Seance_groupes() {
    }

    public Seance_groupes(int ID_SEANCE, int ID_GROUPE) {
        this.ID_SEANCE = ID_SEANCE;
        this.ID_GROUPE = ID_GROUPE;
    }

    
    

    public int getID_GROUPE() {
        return ID_GROUPE;
    }

    public int getID_SEANCE() {
        return ID_SEANCE;
    }

    
    
    
    
}
