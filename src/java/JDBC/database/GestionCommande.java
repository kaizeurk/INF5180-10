/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC.database;
import JDBC.model.Commande;
import java.sql.*;
import java.util.*;
import java.sql.Date;

/**
 *
 * @author kaizeurk
 */
public class GestionCommande{
    private Connection uneConnection;
    // Constructeur pour connexion passee par le createur
    public GestionCommande(Connection laConnection){
        this.uneConnection = laConnection;
    }
    
    public void setConnection(Connection laConnection){
        this.uneConnection = laConnection;
    }
    
    /**
     * 
     * @param _commande
     * @throws Exception 
     */
    public void passerCommande(Commande _commande) throws Exception{
        
      PreparedStatement unEnonceSQL = uneConnection.prepareStatement
      ("INSERT INTO Commande (noCommande , dateCommande, noClient, codeStatut) VALUES(?, ?, ?, null)");
      unEnonceSQL.setInt(1, _commande.getNocommande());
      unEnonceSQL.setTime(2, (Time) _commande.getDatecommande());
      unEnonceSQL.setInt(3, _commande.getClient());
      int up = unEnonceSQL.executeUpdate();
      
      if(up == 0){
            unEnonceSQL.close();
            throw new Exception("Erreur sur la table Commande");  
      }else{
          unEnonceSQL.close();
      }
      
      for (Iterator<Map> it = _commande.getArticleList().entrySet().iterator(); it.hasNext();) {
            Map.Entry entry = (Map.Entry) it.next();
            int key = (Integer) entry.getKey();
            int value = (Integer) entry.getValue();
            unEnonceSQL = uneConnection.prepareStatement
            ("INSERT INTO LigneCommande (noCommande, noArticle, quantite, prixNegocie) VALUES(?, ?, ?, null)");
            unEnonceSQL.setInt(1, _commande.getNocommande());
            unEnonceSQL.setInt(2, key);
            unEnonceSQL.setInt(3, value);
            up = unEnonceSQL.executeUpdate();
            
            if(up == 0){
                  unEnonceSQL.close();
                  throw new Exception("Erreur sur la table Commande");  
            } else {
                unEnonceSQL.close();
            }
        }
    }
    
    public ResultSet consulterCommande(int _noCommande, int _noClient, String _motPass )
        throws Exception {
            Commande c = null;
            PreparedStatement unEnonceSQL = uneConnection.prepareStatement
            ("WITH LIVREE AS \n" +
            "  (SELECT D.NOCOMMANDE,\n" +
            "          SUM(D.QUANTITELIVREE) QUANTITELIVREE,\n" +
            "          D.NOARTICLE\n" +
            "  FROM LIVRAISON LI,\n" +
            "       DETAILLIVRAISON D\n" +
            "  WHERE LI.NOLIVRAISON = D.NOLIVRAISON\n" +
            "  GROUP BY D.NOCOMMANDE,D.NOARTICLE )\n" +
                    
            "SELECT LC.NOCLIENT,\n" +
            "       LC.NOMCLIENT,\n" +
            "       L.NOCOMMANDE,\n" +
            "      (SELECT S.DESSTATUT \n" +
            "        FROM STATUT S\n" +
            "        WHERE C.CODESTATUT = S.CODESTATUT)STATUT_COMMANDE,\n" +
            "       A.NOARTICLE ,\n" +
            "       A.DESCRIPTION              DESCRIPTION_ARTICLE,\n" +
            "       A.PRIXUNITAIRE             PRIX_UNTIAIRE,\n" +
            "       (CASE  \n" +
            "        WHEN L.PRIXNEGOCIE > 0.0 THEN L.PRIXNEGOCIE\n" +
            "        ELSE A.PRIXUNITAIRE \n" +
            "        END )                    PRIX_UNTAIRE_A_PAYER,\n" +
            "        L.QUANTITE               QUANTITE_COMMANDE,\n" +
            "        NVL(LV.QUANTITELIVREE,0) QUANTITELIVREE\n" +
            "FROM COMMANDE C,\n" +
            "     CLIENT LC,\n" +
            "     LIGNECOMMANDE L,\n" +
            "     ARTICLE A,\n" +
            "     LIVREE LV\n" +
            "WHERE LC.NOCLIENT         = ?\n" +
            "    AND LC.MOTDEPASSE     = ?\n" +
            "    AND C.NOCOMMANDE      = ?\n" +
            "    AND LC.NOCLIENT       = C.NOCLIENT\n" +
            "    AND L.NOCOMMANDE      = C.NOCOMMANDE\n" +
            "    AND A.NOARTICLE       = L.NOARTICLE\n" +
            "    AND LV.NOCOMMANDE (+) = L.NOCOMMANDE \n" +
            "    AND LV.NOARTICLE  (+) = L.NOARTICLE \n" +
            "ORDER BY LC.NOCLIENT, A.NOARTICLE;");
            unEnonceSQL.setInt    (1,_noClient);
            unEnonceSQL.setString (2,_motPass);
            unEnonceSQL.setInt    (3,_noCommande);
            ResultSet resultatSelect = unEnonceSQL.executeQuery();
            return resultatSelect;
   }
    
   public void toString(ResultSet resultatSelect) throws SQLException{
       double sommeTotale = 0.0;
       int quantiteTotale = 0;
       
       int lenoCommande = resultatSelect.getInt("NOCOMMANDE");
       String nomClient = resultatSelect.getString("NOMCLIENT");
       
       System.out.println ("No Commande : " + lenoCommande);
       System.out.println ("Nom Client : " + nomClient);
       
       
       while (resultatSelect.next()){
            String statut            = resultatSelect.getString ("STATUT_COMMANDE");
            int    noArticle         = resultatSelect.getInt    ("NOARTICLE");
            String desArt            = resultatSelect.getString ("DESCRIPTION_ARTICLE");
            double prixU             = resultatSelect.getDouble ("PRIX_UNTIAIRE");
            double prixUAPayer       = resultatSelect.getDouble ("PRIX_UNTAIRE_A_PAYER");
            int    quantiteCommande  = resultatSelect.getInt    ("QUANTITE_COMMANDE");
            int    quantiteLivree    = resultatSelect.getInt    ("QUANTITELIVREE");
            sommeTotale        += (prixUAPayer * quantiteCommande);
            quantiteTotale     += quantiteCommande;
            
            System.out.println ("NO ARTICLE \tDESCRIPTION \t\tPRIX UNITAIRE \tQTE COMMANDEE \tPRIX A PAYER \tQTE LIVREE");
            System.out.println (noArticle + "\t" + desArt + "\t\t" + prixU + "\t" + quantiteCommande + "\t" + prixUAPayer + "\t" + quantiteLivree);
            
       }
       
       System.out.println ("\n\t\t\t\t\tQuantite totale : " + quantiteTotale);
       System.out.println ("\t\t\t\t\tMontant total :   " + sommeTotale);
   }
   
   public boolean clientExiste(int _noClient, String _motPass, Connection uneConnection) throws SQLException{
        PreparedStatement unEnonceSQL = uneConnection.prepareStatement
        ("SELECT noClient, motDePasse FROM CLIENT WHERE noClient = ? and motDePasse = ?");
       
        unEnonceSQL.setInt (1,_noClient);
        unEnonceSQL.setString (2,_motPass);
        ResultSet resultatSelect = unEnonceSQL.executeQuery();
        if(resultatSelect.getInt("noClient") != _noClient || !resultatSelect.getString("motDePasse").equals(_motPass)){
            unEnonceSQL.close();
            return false;
        }
       
        unEnonceSQL.close();
        return true;
    }   
    
    public void authentifierClient(int numeroClient, String pwd, Connection uneConnection) throws SQLException{
        
        Scanner clavier = new Scanner(System.in);
        
        System.out.print("\n\t\tVeuillez entrer votre numero client : ");
        numeroClient = clavier.nextInt();
        System.out.print("\n\t\tVeuillez entrer votre mot de passe : ");
        pwd = clavier.next();
        if (!clientExiste(numeroClient, pwd, uneConnection)){
            throw new SQLException("Erreur sur la table Client; indentifiant ou mot de passe incorrect !");  
        }
    }
    
    public int recupererNbreCommandes(Connection uneConnection) throws SQLException{
        PreparedStatement unEnonceSQL = uneConnection.prepareStatement
        ("SELECT COUNT (noCommande) FROM COMMANDE");
       
        ResultSet resultatSelect = unEnonceSQL.executeQuery();
        if(!resultatSelect.next()){
            unEnonceSQL.close();
            return 0;
        }
       
        unEnonceSQL.close();
        return resultatSelect.getInt("noCommande");
    }
    
    public void ajoutArticles(Commande uneCommande, Connection uneConnection) throws SQLException{
        
        char choix = 'o';
        int noArticle;
        int qte;
        Scanner clavier = new Scanner(System.in);
        
        while (choix == 'o'){
            System.out.print("\n\tEntrez le numero d'article : ");
            noArticle = clavier.nextInt();
            PreparedStatement unEnonceSQL = uneConnection.prepareStatement
            ("SELECT A.description, A.prixUnitaire FROM Article A WHERE A.noArticle = ?");
            unEnonceSQL.setInt(1, noArticle);
            ResultSet resultatSelect = unEnonceSQL.executeQuery();
            unEnonceSQL.close();
            System.out.print("\n\tDescription : " + resultatSelect.getString("description"));
            System.out.print("\n\tPrix unitaire : " + resultatSelect.getDouble("prixUnitaire"));
          
            System.out.print("\n\tEntrez la quantite : ");
            qte = clavier.nextInt();
            uneCommande.ajouterArticle(noArticle, qte);
            System.out.print("\n\tCommander un autre article ('o' ou 'n') ? ");
            choix = clavier.next().charAt(0);
      }
    }
   
}

