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
@NamedQueries({ @NamedQuery(name = "Detaillivraison.findAll", query = "select o from Detaillivraison o") })
@IdClass(DetaillivraisonPK.class)
public class Detaillivraison implements Serializable {
    private static final long serialVersionUID = -6119528904703924011L;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal noarticle;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal nocommande;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal nolivraison;
    @Column(nullable = false)
    private BigDecimal quantitelivree;
    @XmlTransient
    @ManyToOne
    @JoinColumns({
                 @JoinColumn(name = "NOCOMMANDE", referencedColumnName = "NOCOMMANDE"),
                 @JoinColumn(name = "NOARTICLE", referencedColumnName = "NOARTICLE")
        })
    private Lignecommande lignecommande1;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOLIVRAISON")
    private Livraison detaillivraison;

    public Detaillivraison() {
    }

    public Detaillivraison(Lignecommande lignecommande1, Livraison detaillivraison,
                           BigDecimal quantitelivree) {
        this.lignecommande1 = lignecommande1;
        this.detaillivraison = detaillivraison;
        this.quantitelivree = quantitelivree;
    }


    public BigDecimal getNoarticle() {
        return noarticle;
    }

    public void setNoarticle(BigDecimal noarticle) {
        this.noarticle = noarticle;
    }

    public BigDecimal getNocommande() {
        return nocommande;
    }

    public void setNocommande(BigDecimal nocommande) {
        this.nocommande = nocommande;
    }

    public BigDecimal getNolivraison() {
        return nolivraison;
    }

    public void setNolivraison(BigDecimal nolivraison) {
        this.nolivraison = nolivraison;
    }

    public BigDecimal getQuantitelivree() {
        return quantitelivree;
    }

    public void setQuantitelivree(BigDecimal quantitelivree) {
        this.quantitelivree = quantitelivree;
    }

    @XmlTransient
    public Lignecommande getLignecommande1() {
        return lignecommande1;
    }

    @XmlTransient
    public void setLignecommande1(Lignecommande lignecommande1) {
        this.lignecommande1 = lignecommande1;
        if (lignecommande1 != null) {
            this.noarticle = lignecommande1.getNoarticle();
            this.nocommande = lignecommande1.getNocommande();
        }
    }

    @XmlTransient
    public Livraison getDetaillivraison() {
        return detaillivraison;
    }

    @XmlTransient
    public void setDetaillivraison(Livraison detaillivraison) {
        this.detaillivraison = detaillivraison;
        if (detaillivraison != null) {
            this.nolivraison = detaillivraison.getNolivraison();
        }
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("noarticle=");
        buffer.append(getNoarticle());
        buffer.append(',');
        buffer.append("nocommande=");
        buffer.append(getNocommande());
        buffer.append(',');
        buffer.append("nolivraison=");
        buffer.append(getNolivraison());
        buffer.append(',');
        buffer.append("quantitelivree=");
        buffer.append(getQuantitelivree());
        buffer.append(']');
        return buffer.toString();
    }
}
