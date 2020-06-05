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
public class Etudiant {
    private  int ID_UTILISATEUR;
    private int numero;
    private int ID_GROUPE;

    public Etudiant() {
    }

    public int getID_GROUPE() {
        return ID_GROUPE;
    }

    public int getNumero() {
        return numero;
    }

    public Etudiant(int ID_UTILISATEUR, int numero, int ID_GROUPE) {
        this.ID_UTILISATEUR = ID_UTILISATEUR;
        this.numero = numero;
        this.ID_GROUPE = ID_GROUPE;
    }
    
    
}
