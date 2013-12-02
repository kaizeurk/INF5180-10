package model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Paiementparcheque.findAll", query = "select o from Paiementparcheque o") })
@IdClass(PaiementparchequePK.class)
public class Paiementparcheque implements Serializable {
    private static final long serialVersionUID = 1710618358463896912L;
    @Id
    @Column(nullable = false)
    private BigDecimal nocheque;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal nopaiement;
    @XmlTransient
    @ManyToOne
    @JoinColumns({
                 @JoinColumn(name = "IDBANQUE", referencedColumnName = "IDBANQUE"),
                 @JoinColumn(name = "NOCOMPTE", referencedColumnName = "NOCOMPTE")
        })
    private Comptebancaire comptebancaire1;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOPAIEMENT")
    private Paiement paiement;

    public Paiementparcheque() {
    }

    public Paiementparcheque(Comptebancaire comptebancaire1, BigDecimal nocheque, Paiement paiement) {
        this.comptebancaire1 = comptebancaire1;
        this.nocheque = nocheque;
        this.paiement = paiement;
    }


    public BigDecimal getNocheque() {
        return nocheque;
    }

    public void setNocheque(BigDecimal nocheque) {
        this.nocheque = nocheque;
    }


    public BigDecimal getNopaiement() {
        return nopaiement;
    }

    public void setNopaiement(BigDecimal nopaiement) {
        this.nopaiement = nopaiement;
    }

    @XmlTransient
    public Comptebancaire getComptebancaire1() {
        return comptebancaire1;
    }

    @XmlTransient
    public void setComptebancaire1(Comptebancaire comptebancaire1) {
        this.comptebancaire1 = comptebancaire1;
    }

    @XmlTransient
    public Paiement getPaiement() {
        return paiement;
    }

    @XmlTransient
    public void setPaiement(Paiement paiement) {
        this.paiement = paiement;
        if (paiement != null) {
            this.nopaiement = paiement.getNopaiement();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("nocheque=");
        buffer.append(getNocheque());
        buffer.append(',');
        buffer.append("nopaiement=");
        buffer.append(getNopaiement());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
