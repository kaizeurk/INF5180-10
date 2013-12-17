package JDBC.model;

import java.util.Date;
import java.util.Map;
import java.util.Hashtable;

public class Commande {
    
    private Date datecommande;
    private int nocommande;
    private int noClient;
    private Map articleList;
    private String codeStatut;

    public Commande() {
    }

    public Commande(int nocommande, Date datecommande, int noClient, String codeStatut) {
        this.nocommande = nocommande;
        this.datecommande = datecommande;
        this.noClient = noClient;
        this.codeStatut = codeStatut;
        this.articleList = new Hashtable();
    }


    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }


    public int getNocommande() {
        return nocommande;
    }

    public void setNocommande(int nocommande) {
        this.nocommande = nocommande;
    }

    public int getClient() {
        return noClient;
    }

    public void setClient(Client client) {
        this.noClient = client.getNoclient();
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("datecommande=");
        buffer.append(getDatecommande());
        buffer.append(',');
        buffer.append("nocommande=");
        buffer.append(getNocommande());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }

    public Map getArticleList() {
        return articleList;
    }

    public void setArticleList(Map articleList) {
        this.articleList = articleList;
    }

    public String getStatut() {
        return codeStatut;
    }

    public void setStatut(String codeStatut) {
        this.codeStatut = codeStatut;
    }
    
    public void ajouterArticle(int numArticle, int quantite){
        articleList.put(new Integer(numArticle),new Integer(quantite));
    }
    
    public void supprimerArticle(int numArticle){
        articleList.remove(numArticle);
    }
    
}