package JDBC.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
import java.util.Date;
import java.util.Hashtable;

import java.util.List;
import java.util.Map;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Commande.findAll", query = "select o from Commande o") })
public class Commande implements Serializable {
    private static final long serialVersionUID = 3366700937014838413L;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datecommande;
    @Id
    @Column(nullable = false)
    private int nocommande;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOCLIENT")
    private Client client;
    @XmlTransient
    @OneToMany
    @JoinColumn(name = "NOARTICLE")
    private Map articleList;
    @OneToOne
    private Statut statut;

    public Commande() {
    }

    public Commande(Statut statut, Date datecommande, Client client, int nocommande) {
        this.statut = statut;
        this.datecommande = datecommande;
        this.client = client;
        this.nocommande = nocommande;
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

    @XmlTransient
    public Client getClient() {
        return client;
    }

    @XmlTransient
    public void setClient(Client client) {
        this.client = client;
    }


    @Override
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

    public Statut getStatut() {
        return statut;
    }

    public void setStatut(Statut statut) {
        this.statut = statut;
    }
    public void ajouteArticle(Article art, int quantite){
        articleList.put(new Integer(art.getNoarticle()),new Integer(quantite));
    }
    public void supprimerArticle(Article art){
        articleList.remove(art.getNoarticle());
    }
    
}