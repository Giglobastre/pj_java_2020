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
public class Seance_salles {
    private int ID_SEANCE;
    private int ID_SALLE;

    public Seance_salles() {
    }

    public Seance_salles(int ID_SEANCE, int ID_SALLE) {
        this.ID_SEANCE = ID_SEANCE;
        this.ID_SALLE = ID_SALLE;
    }

    public int getID_SALLE() {
        return ID_SALLE;
    }

    public int getID_SEANCE() {
        return ID_SEANCE;
    }
    
    
}
