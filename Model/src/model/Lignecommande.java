package model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Lignecommande.findAll", query = "select o from Lignecommande o") })
@IdClass(LignecommandePK.class)
public class Lignecommande implements Serializable {
    private static final long serialVersionUID = -3009920127506981082L;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal noarticle;
    @Id
    @Column(insertable = false, updatable = false)
    private BigDecimal nocommande;
    @Column(nullable = false)
    private Long prixnegocie;
    @Column(nullable = false)
    private BigDecimal quantite;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOARTICLE")
    private Article article;
    @XmlTransient
    @OneToMany(mappedBy = "lignecommande1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Detaillivraison> detaillivraisonList1;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOCOMMANDE")
    private Commande commande;

    public Lignecommande() {
    }

    public Lignecommande(Article article, Commande commande, Long prixnegocie, BigDecimal quantite) {
        this.article = article;
        this.commande = commande;
        this.prixnegocie = prixnegocie;
        this.quantite = quantite;
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

    public Long getPrixnegocie() {
        return prixnegocie;
    }

    public void setPrixnegocie(Long prixnegocie) {
        this.prixnegocie = prixnegocie;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    @XmlTransient
    public Article getArticle() {
        return article;
    }

    @XmlTransient
    public void setArticle(Article article) {
        this.article = article;
        if (article != null) {
            this.noarticle = article.getNoarticle();
        }
    }

    @XmlTransient
    public List<Detaillivraison> getDetaillivraisonList1() {
        return detaillivraisonList1;
    }

    @XmlTransient
    public void setDetaillivraisonList1(List<Detaillivraison> detaillivraisonList1) {
        this.detaillivraisonList1 = detaillivraisonList1;
    }

    public Detaillivraison addDetaillivraison(Detaillivraison detaillivraison) {
        getDetaillivraisonList1().add(detaillivraison);
        detaillivraison.setLignecommande1(this);
        return detaillivraison;
    }

    public Detaillivraison removeDetaillivraison(Detaillivraison detaillivraison) {
        getDetaillivraisonList1().remove(detaillivraison);
        detaillivraison.setLignecommande1(null);
        return detaillivraison;
    }

    @XmlTransient
    public Commande getCommande() {
        return commande;
    }

    @XmlTransient
    public void setCommande(Commande commande) {
        this.commande = commande;
        if (commande != null) {
            this.nocommande = commande.getNocommande();
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
        buffer.append("prixnegocie=");
        buffer.append(getPrixnegocie());
        buffer.append(',');
        buffer.append("quantite=");
        buffer.append(getQuantite());
        buffer.append(']');
        return buffer.toString();
    }
}
