package JDBC.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Livraison.findAll", query = "select o from Livraison o") })
public class Livraison implements Serializable {
    private static final long serialVersionUID = 6454830613704562877L;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datelivraison;
    @Id
    @Column(nullable = false)
    private int nolivraison;
    
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOCOMMANDE")
    private Commande commande;

    public Livraison() {
    }

    public Livraison(Date datelivraison, int _nolivraison,Commande commande) {
        this.datelivraison = datelivraison;
        this.nolivraison = _nolivraison;
        this.commande = commande;
    }


    public Date getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public int getNolivraison() {
        return nolivraison;
    }

    public void setNolivraison(int nolivraison) {
        this.nolivraison = nolivraison;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("datelivraison=");
        buffer.append(getDatelivraison());
        buffer.append(',');
        buffer.append("nolivraison=");
        buffer.append(getNolivraison());
        buffer.append(']');
        return buffer.toString();
    }


    public Commande getCommande() {
        return commande;
    }

    public void setCommande(Commande commande) {
        this.commande = commande;
    }
}
