package JDBC.model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.ArrayList;
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
@NamedQueries({ @NamedQuery(name = "Paiement.findAll", query = "select o from Paiement o") })
public class Paiement implements Serializable {
    private static final long serialVersionUID = 5477390029131907726L;
    @Temporal(TemporalType.DATE)
    private Date datepaiement;
    @Column(nullable = false)
    private double montantpaiement;
    @Id
    @Column(nullable = false)
    private int nopaiement;
    @ManyToOne
    private Facture facture;
    private int typePaiement;

    public Paiement() {
    }

    public Paiement(Date datepaiement, double montantpaiement, Facture facture, int nopaiement) {
        this.datepaiement = datepaiement;
        this.montantpaiement = montantpaiement;
        this.facture = facture;
        this.nopaiement = nopaiement;
        
        
        
    }

    
    public Date getDatepaiement() {
        return datepaiement;
    }

    public void setDatepaiement(Date datepaiement) {
        this.datepaiement = datepaiement;
    }

    public double getMontantpaiement() {
        return montantpaiement;
    }

    public void setMontantpaiement(double montantpaiement) {
        this.montantpaiement = montantpaiement;
    }


    public int getNopaiement() {
        return nopaiement;
    }

    public void setNopaiement(int nopaiement) {
        this.nopaiement = nopaiement;
    }


    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("datepaiement=");
        buffer.append(getDatepaiement());
        buffer.append(',');
        buffer.append("montantpaiement=");
        buffer.append(getMontantpaiement());
        buffer.append(',');
        buffer.append("nopaiement=");
        buffer.append(getNopaiement());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }

    public Facture getFacture() {
        return facture;
    }

    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    public int getTypePaiement() {
        return typePaiement;
    }

    public void setTypePaiement(int typePaiement) {
        this.typePaiement = typePaiement;
    }
    
}
