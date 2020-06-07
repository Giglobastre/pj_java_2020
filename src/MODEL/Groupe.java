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
public class Groupe {
private int ID;
private String NOM;
    public Groupe() {
    }

    public Groupe(int ID, String NOM) {
        this.ID = ID;
        this.NOM = NOM;
    }

    public int getID() {
        return ID;
    }

    public String getNOM() {
        return NOM;
    }
    
}
