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
public class Site {
    private int ID;
    private String nom;

    public Site() {
    }

    public Site(int ID, String nom) {
        this.ID = ID;
        this.nom = nom;
    }

    public int getID() {
        return ID;
    }

    public String getNom() {
        return nom;
    }
    
}
