package model;

import java.io.Serializable;

import java.math.BigDecimal;

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

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Article.findAll", query = "select o from Article o") })
public class Article implements Serializable {
    private static final long serialVersionUID = 7063075448323579531L;
    @Column(length = 20)
    private String description;
    @Id
    @Column(nullable = false)
    private BigDecimal noarticle;
    @Column(nullable = false)
    private Long prixunitaire;
    @Column(nullable = false)
    private BigDecimal quantiteenstock;
    @Column(length = 100)
    private String url;
    @XmlTransient
    @OneToMany(mappedBy = "article", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Lignecommande> lignecommandeList;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "CODECATEGORIE")
    private Categorie categorie;

    public Article() {
    }

    public Article(Categorie categorie, String description, BigDecimal noarticle, Long prixunitaire,
                   BigDecimal quantiteenstock, String url) {
        this.categorie = categorie;
        this.description = description;
        this.noarticle = noarticle;
        this.prixunitaire = prixunitaire;
        this.quantiteenstock = quantiteenstock;
        this.url = url;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getNoarticle() {
        return noarticle;
    }

    public void setNoarticle(BigDecimal noarticle) {
        this.noarticle = noarticle;
    }

    public Long getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(Long prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public BigDecimal getQuantiteenstock() {
        return quantiteenstock;
    }

    public void setQuantiteenstock(BigDecimal quantiteenstock) {
        this.quantiteenstock = quantiteenstock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public List<Lignecommande> getLignecommandeList() {
        return lignecommandeList;
    }

    @XmlTransient
    public void setLignecommandeList(List<Lignecommande> lignecommandeList) {
        this.lignecommandeList = lignecommandeList;
    }

    public Lignecommande addLignecommande(Lignecommande lignecommande) {
        getLignecommandeList().add(lignecommande);
        lignecommande.setArticle(this);
        return lignecommande;
    }

    public Lignecommande removeLignecommande(Lignecommande lignecommande) {
        getLignecommandeList().remove(lignecommande);
        lignecommande.setArticle(null);
        return lignecommande;
    }

    @XmlTransient
    public Categorie getCategorie() {
        return categorie;
    }

    @XmlTransient
    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("description=");
        buffer.append(getDescription());
        buffer.append(',');
        buffer.append("noarticle=");
        buffer.append(getNoarticle());
        buffer.append(',');
        buffer.append("prixunitaire=");
        buffer.append(getPrixunitaire());
        buffer.append(',');
        buffer.append("quantiteenstock=");
        buffer.append(getQuantiteenstock());
        buffer.append(',');
        buffer.append("url=");
        buffer.append(getUrl());
        buffer.append(']');
        return buffer.toString();
    }
}
