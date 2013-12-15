/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;
import java.util.Scanner;
import java.sql.Connection;
import java.sql.PreparedStatement;


/**
 *
 * @author onclephil
 */
public class Main {
    
    public static void afficherMenuOption() {
        System.out.println("\t\t1 - Passer une commande ");
        System.out.println("\t\t2 - Consulter les commandes ");
        System.out.println("\t\t3 - Quitter ");
        
        System.out.print("\n\t\tVeuillez choisir une option : ");
    }


    public static void main(String[] args){
        
        char choix;
        Connection uneConnection;
        JDBCconnection uneInstance = new JDBCconnection("dg791281", "SBHfyMkA");
        uneConnection = uneInstance.getInstance();
        //PreparedStatement unEnonceSQL = uneConnection.prepareStatement
        //("SELECT * FROM CLIENT");
        
        //String note;
        Scanner clavier = new Scanner(System.in);
        
        do {
            afficherMenuOption();
            choix =  clavier.next().charAt(0);
            while (choix < '1' || choix > '3') {
                System.out.println("\n\t\tErreur!!! La valeur entrée ne correspond à aucune option valide");
                afficherMenuOption();
                choix =  clavier.next().charAt(0);
            }
            
            
            
         } while(choix != '3');
    
    
    }
}
