package model;

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
@NamedQueries({ @NamedQuery(name = "Paiement.findAll", query = "select o from Paiement o") })
public class Paiement implements Serializable {
    private static final long serialVersionUID = 5477390029131907726L;
    @Temporal(TemporalType.DATE)
    private Date datepaiement;
    @Column(nullable = false)
    private Long montantpaiement;
    @Id
    @Column(nullable = false)
    private BigDecimal nopaiement;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOFACTURE")
    private Facture facture;
    @XmlTransient
    @OneToMany(mappedBy = "paiement", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Paiementparcheque> paiementparchequeList2;
    @XmlTransient
    @OneToMany(mappedBy = "paiement1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Paiementparcarte> paiementparcarteList;

    public Paiement() {
    }

    public Paiement(Date datepaiement, Long montantpaiement, Facture facture, BigDecimal nopaiement) {
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

    public Long getMontantpaiement() {
        return montantpaiement;
    }

    public void setMontantpaiement(Long montantpaiement) {
        this.montantpaiement = montantpaiement;
    }


    public BigDecimal getNopaiement() {
        return nopaiement;
    }

    public void setNopaiement(BigDecimal nopaiement) {
        this.nopaiement = nopaiement;
    }

    @XmlTransient
    public Facture getFacture() {
        return facture;
    }

    @XmlTransient
    public void setFacture(Facture facture) {
        this.facture = facture;
    }

    @XmlTransient
    public List<Paiementparcheque> getPaiementparchequeList2() {
        return paiementparchequeList2;
    }

    @XmlTransient
    public void setPaiementparchequeList2(List<Paiementparcheque> paiementparchequeList2) {
        this.paiementparchequeList2 = paiementparchequeList2;
    }

    public Paiementparcheque addPaiementparcheque(Paiementparcheque paiementparcheque) {
        getPaiementparchequeList2().add(paiementparcheque);
        paiementparcheque.setPaiement(this);
        return paiementparcheque;
    }

    public Paiementparcheque removePaiementparcheque(Paiementparcheque paiementparcheque) {
        getPaiementparchequeList2().remove(paiementparcheque);
        paiementparcheque.setPaiement(null);
        return paiementparcheque;
    }

    @XmlTransient
    public List<Paiementparcarte> getPaiementparcarteList() {
        return paiementparcarteList;
    }

    @XmlTransient
    public void setPaiementparcarteList(List<Paiementparcarte> paiementparcarteList) {
        this.paiementparcarteList = paiementparcarteList;
    }

    public Paiementparcarte addPaiementparcarte(Paiementparcarte paiementparcarte) {
        getPaiementparcarteList().add(paiementparcarte);
        paiementparcarte.setPaiement1(this);
        return paiementparcarte;
    }

    public Paiementparcarte removePaiementparcarte(Paiementparcarte paiementparcarte) {
        getPaiementparcarteList().remove(paiementparcarte);
        paiementparcarte.setPaiement1(null);
        return paiementparcarte;
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
}
