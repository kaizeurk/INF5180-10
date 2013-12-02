package model;

import java.io.Serializable;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Paiementparcarte.findAll", query = "select o from Paiementparcarte o") })
@IdClass(PaiementparcartePK.class)
public class Paiementparcarte implements Serializable {
    private static final long serialVersionUID = 3488223784489106154L;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal nocarte;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal nopaiement;
    @Column(nullable = false)
    private BigDecimal numeroautorisation;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOPAIEMENT")
    private Paiement paiement1;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOCARTE")
    private Cartecredit cartecredit;

    public Paiementparcarte() {
    }

    public Paiementparcarte(Cartecredit cartecredit, Paiement paiement1, BigDecimal numeroautorisation) {
        this.cartecredit = cartecredit;
        this.paiement1 = paiement1;
        this.numeroautorisation = numeroautorisation;
    }


    public BigDecimal getNocarte() {
        return nocarte;
    }

    public void setNocarte(BigDecimal nocarte) {
        this.nocarte = nocarte;
    }

    public BigDecimal getNopaiement() {
        return nopaiement;
    }

    public void setNopaiement(BigDecimal nopaiement) {
        this.nopaiement = nopaiement;
    }

    public BigDecimal getNumeroautorisation() {
        return numeroautorisation;
    }

    public void setNumeroautorisation(BigDecimal numeroautorisation) {
        this.numeroautorisation = numeroautorisation;
    }

    @XmlTransient
    public Paiement getPaiement1() {
        return paiement1;
    }

    @XmlTransient
    public void setPaiement1(Paiement paiement1) {
        this.paiement1 = paiement1;
        if (paiement1 != null) {
            this.nopaiement = paiement1.getNopaiement();
        }
    }

    @XmlTransient
    public Cartecredit getCartecredit() {
        return cartecredit;
    }

    @XmlTransient
    public void setCartecredit(Cartecredit cartecredit) {
        this.cartecredit = cartecredit;
        if (cartecredit != null) {
            this.nocarte = cartecredit.getNocarte();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("nocarte=");
        buffer.append(getNocarte());
        buffer.append(',');
        buffer.append("nopaiement=");
        buffer.append(getNopaiement());
        buffer.append(',');
        buffer.append("numeroautorisation=");
        buffer.append(getNumeroautorisation());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
