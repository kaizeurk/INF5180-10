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
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Facture.findAll", query = "select o from Facture o") })
public class Facture implements Serializable {
    private static final long serialVersionUID = -201700060357283052L;
    @Temporal(TemporalType.DATE)
    private Date datelimitepaiement;
    @Column(nullable = false)
    private double montantapayer;
    @Id
    @Column(nullable = false)
    private int nofacture;
    @OneToOne
    private Commande commande;


    public Facture() {
    }

    public Facture(Date datelimitepaiement, double montantapayer, int nofacture, Commande _commande) {
        this.datelimitepaiement = datelimitepaiement;
        this.montantapayer = montantapayer;
        this.nofacture = nofacture;
        this.commande = _commande;
    }


    public Date getDatelimitepaiement() {
        return datelimitepaiement;
    }

    public void setDatelimitepaiement(Date datelimitepaiement) {
        this.datelimitepaiement = datelimitepaiement;
    }

    public double getMontantapayer() {
        return montantapayer;
    }

    public void setMontantapayer(double montantapayer) {
        this.montantapayer = montantapayer;
    }

    public int getNofacture() {
        return nofacture;
    }

    public void setNofacture(int nofacture) {
        this.nofacture = nofacture;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("datelimitepaiement=");
        buffer.append(getDatelimitepaiement());
        buffer.append(',');
        buffer.append("montantapayer=");
        buffer.append(getMontantapayer());
        buffer.append(',');
        buffer.append("nofacture=");
        buffer.append(getNofacture());
        buffer.append(',');
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
