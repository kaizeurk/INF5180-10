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
@NamedQueries({ @NamedQuery(name = "Facture.findAll", query = "select o from Facture o") })
public class Facture implements Serializable {
    private static final long serialVersionUID = -201700060357283052L;
    @Temporal(TemporalType.DATE)
    private Date datelimitepaiement;
    @Column(nullable = false)
    private Long montantapayer;
    @Id
    @Column(nullable = false)
    private BigDecimal nofacture;
    @XmlTransient
    @OneToMany(mappedBy = "facture", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Paiement> paiementList;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOLIVRAISON")
    private Livraison detaillivraison1;

    public Facture() {
    }

    public Facture(Date datelimitepaiement, Long montantapayer, BigDecimal nofacture, Livraison detaillivraison1) {
        this.datelimitepaiement = datelimitepaiement;
        this.montantapayer = montantapayer;
        this.nofacture = nofacture;
        this.detaillivraison1 = detaillivraison1;
    }


    public Date getDatelimitepaiement() {
        return datelimitepaiement;
    }

    public void setDatelimitepaiement(Date datelimitepaiement) {
        this.datelimitepaiement = datelimitepaiement;
    }

    public Long getMontantapayer() {
        return montantapayer;
    }

    public void setMontantapayer(Long montantapayer) {
        this.montantapayer = montantapayer;
    }

    public BigDecimal getNofacture() {
        return nofacture;
    }

    public void setNofacture(BigDecimal nofacture) {
        this.nofacture = nofacture;
    }


    @XmlTransient
    public List<Paiement> getPaiementList() {
        return paiementList;
    }

    @XmlTransient
    public void setPaiementList(List<Paiement> paiementList) {
        this.paiementList = paiementList;
    }

    public Paiement addPaiement(Paiement paiement) {
        getPaiementList().add(paiement);
        paiement.setFacture(this);
        return paiement;
    }

    public Paiement removePaiement(Paiement paiement) {
        getPaiementList().remove(paiement);
        paiement.setFacture(null);
        return paiement;
    }

    @XmlTransient
    public Livraison getDetaillivraison1() {
        return detaillivraison1;
    }

    @XmlTransient
    public void setDetaillivraison1(Livraison detaillivraison1) {
        this.detaillivraison1 = detaillivraison1;
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
}
