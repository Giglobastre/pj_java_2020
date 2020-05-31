/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package CONTROLER;
import MODEL.Connexion;
import VIEW.Fenetre_Connexion;
/**
 *
 * @author Kenny-portable
 */
public class Controler_main {
    public static void main(String[] args) {
        //connexion to our service
        Connexion co=new Connexion();
        Fenetre_Connexion fco=new Fenetre_Connexion(co);
    }
}
