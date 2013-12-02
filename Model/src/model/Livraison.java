package model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
    private BigDecimal nolivraison;
    @XmlTransient
    @OneToMany(mappedBy = "detaillivraison", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Detaillivraison> detaillivraisonList2;
    @XmlTransient
    @OneToMany(mappedBy = "detaillivraison1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Facture> factureList;

    public Livraison() {
    }

    public Livraison(Date datelivraison, BigDecimal nolivraison) {
        this.datelivraison = datelivraison;
        this.nolivraison = nolivraison;
    }


    public Date getDatelivraison() {
        return datelivraison;
    }

    public void setDatelivraison(Date datelivraison) {
        this.datelivraison = datelivraison;
    }

    public BigDecimal getNolivraison() {
        return nolivraison;
    }

    public void setNolivraison(BigDecimal nolivraison) {
        this.nolivraison = nolivraison;
    }

    @XmlTransient
    public List<Detaillivraison> getDetaillivraisonList2() {
        return detaillivraisonList2;
    }

    @XmlTransient
    public void setDetaillivraisonList2(List<Detaillivraison> detaillivraisonList2) {
        this.detaillivraisonList2 = detaillivraisonList2;
    }

    public Detaillivraison addDetaillivraison(Detaillivraison detaillivraison) {
        getDetaillivraisonList2().add(detaillivraison);
        detaillivraison.setDetaillivraison(this);
        return detaillivraison;
    }

    public Detaillivraison removeDetaillivraison(Detaillivraison detaillivraison) {
        getDetaillivraisonList2().remove(detaillivraison);
        detaillivraison.setDetaillivraison(null);
        return detaillivraison;
    }

    @XmlTransient
    public List<Facture> getFactureList() {
        return factureList;
    }

    @XmlTransient
    public void setFactureList(List<Facture> factureList) {
        this.factureList = factureList;
    }

    public Facture addFacture(Facture facture) {
        getFactureList().add(facture);
        facture.setDetaillivraison1(this);
        return facture;
    }

    public Facture removeFacture(Facture facture) {
        getFactureList().remove(facture);
        facture.setDetaillivraison1(null);
        return facture;
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
}
