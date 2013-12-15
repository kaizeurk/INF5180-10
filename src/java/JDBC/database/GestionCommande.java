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
    private Commande commande;
    private double montantTotal;
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
    public void passerCommande(Commande _commande)
    // Extrait les valeurs actuelles de nbMaxPrets et dureeMaxPrets
    throws Exception{
        // Initialiser les variables statiques de Membre
      PreparedStatement unEnonceSQL = uneConnection.prepareStatement
      ("INSERT INTO Commande (noCommande , dateCommande, noClient, codeStatut) VALUES(?,?,?,null)");
      unEnonceSQL.setInt(1, _commande.getNocommande());
      unEnonceSQL.setTime(2, (Time) _commande.getDatecommande());
      unEnonceSQL.setInt(3, _commande.getClient().getNoclient());
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
            ("INSERT INTO LigneCommande (noCommande, noArticle, quantite, prixNegocie) VALUES(?,?,?,null)");
            unEnonceSQL.setInt(1, _commande.getNocommande());
            unEnonceSQL.setInt(2, key);
            unEnonceSQL.setInt(3, value);
            up = unEnonceSQL.executeUpdate();
      
            if(up == 0 ){
                  unEnonceSQL.close();
                  throw new Exception("Erreur sur la table Commande");  
            }else{
                unEnonceSQL.close();
            }
        }

      
      ResultSet resultatSelect = unEnonceSQL.executeQuery();
        if (resultatSelect.next ()){
            
            unEnonceSQL.close();
        }else{
            unEnonceSQL.close();
            throw new Exception("table MembreGeneral corrompue");
        }
    }

    /**
     *
     * @param date
     * @return
     * @throws Exception
     */
    public Commande consulterCommande(Date _date, int _noClient, String _motPass )
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
             "       A.DESCRIPTION             DESCRIPTION_ARTICLE,\n" +
             "       A.PRIXUNITAIRE            PRIX_UNTIAIRE,\n" +
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
             "    AND C.DATECOMMANDE    = ?\n" +
             "    AND LC.NOCLIENT       = C.NOCLIENT\n" +
             "    AND L.NOCOMMANDE      = C.NOCOMMANDE\n" +
             "    AND A.NOARTICLE       = L.NOARTICLE\n" +
             "    AND LV.NOCOMMANDE (+) = L.NOCOMMANDE \n" +
             "    AND LV.NOARTICLE  (+) = L.NOARTICLE \n" +
             "ORDER BY LC.NOCLIENT, A.NOARTICLE;");
            unEnonceSQL.setInt    (1,_noClient);
            unEnonceSQL.setString (2,_motPass);
            unEnonceSQL.setDate   (3,_date);
            ResultSet resultatSelect = unEnonceSQL.executeQuery();
            return c;
    }
    
    public Commande consulterCommande(int _noCommande, int _noClient, String _motPass )
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
            return c;
    }
    
   public void toString(ResultSet resultatSelect) throws SQLException{
       double sommeTotal = 0.0;
       int quantiteTotal = 0;
       while (resultatSelect.next ()){
            int    lenoCommande      = resultatSelect.getInt    ("NOCOMMANDE");
            int    lenoClient        = resultatSelect.getInt    ("NOMCLIENT");
            String statut            = resultatSelect.getString ("STATUT_COMMANDE");
            int    noArticle         = resultatSelect.getInt    ("NOARTICLE");
            String desArt            = resultatSelect.getString ("DESCRIPTION_ARTICLE");
            double prixU             = resultatSelect.getDouble ("PRIX_UNTIAIRE");
            double prixUAPayer       = resultatSelect.getDouble ("PRIX_UNTAIRE_A_PAYER");
            int    quantiteCommande  = resultatSelect.getInt    ("QUANTITE_COMMANDE");
            int    quantiteLivree    = resultatSelect.getInt    ("QUANTITELIVREE");
                   sommeTotal        = sommeTotal + (prixUAPayer*quantiteCommande);
                   quantiteTotal     = quantiteTotal + quantiteCommande;

            System.out.println ("noCommande:" + lenoCommande);
           //System.out.println ("dateCommande:" + laDate);
            System.out.println ("noClient:" + lenoClient);
       }
   }   
}

