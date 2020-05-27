/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package projetjava;
import java.sql.Connection;
/**
 *
 * @author hugo7
 */
public class ProjetJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
         DAO<Cours> coursDao = new CoursDAO();
    for(int i = 1; i < 5; i++){
      Cours cours = coursDao.find(i);
      System.out.println("Cours N°" +cours.getiD()+cours.getNom());
    }
    }
    
}
