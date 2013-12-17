/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;
import JDBC.database.GestionCommande;
import JDBC.model.Commande;
import java.util.Scanner;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


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

    /**
     * 
     * Methode main
     *  
     */
    public static void main(String[] args) throws Exception{
        
        char choix;
        int numeroClient = 0;
        String pwd = "";
        int cpteurCommande;
        Connection uneConnection;
        JDBCconnection uneInstance = new JDBCconnection("dg791281", "SBHfyMkA");
        
        uneConnection = uneInstance.getInstance();
        GestionCommande gestionCommande = new GestionCommande(uneConnection);
        Scanner clavier = new Scanner(System.in);
        
        do {
            afficherMenuOption();
            choix =  clavier.next().charAt(0);
            while (choix < '1' || choix > '3'){
                System.out.println("\n\t\tErreur!!! La valeur entrée ne correspond à aucune option valide");
                afficherMenuOption();
                choix = clavier.next().charAt(0);
            }
            
            switch (choix){
                case ('1') :
                    
                    cpteurCommande = gestionCommande.recupererNbreCommandes(uneConnection);
                    gestionCommande.authentifierClient(numeroClient, pwd, uneConnection);
                    Commande uneCommande = new Commande (cpteurCommande++, new Date(), numeroClient, null);
                    gestionCommande.ajoutArticles(uneCommande, uneConnection);
                    gestionCommande.passerCommande(uneCommande);
                    break;
                
                case ('2') :
                    
                    gestionCommande.authentifierClient(numeroClient, pwd, uneConnection); 
                    System.out.print("\n\tEntrez le numero de la commande : ");
                    int noCommande = clavier.nextInt();
                    ResultSet resultat = gestionCommande.consulterCommande(noCommande, numeroClient, pwd);
                    gestionCommande.toString(resultat);          
            }
            
         } while(choix != '3');
    }
}
