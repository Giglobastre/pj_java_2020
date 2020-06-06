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
public class Cours {
    private int iD;
    private String nom;
    

    public Cours(int iD, String nom) {
        this.iD = iD;
        this.nom = nom;
    }

    public Cours() {
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getiD() {
        return iD;
    }

    public void setiD(int iD) {
        this.iD = iD;
    }
    
    
}
