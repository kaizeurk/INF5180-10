package JDBC.model;

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
    private int noarticle;
    @Column(nullable = false)
    private double prixunitaire;
    @Column(nullable = false)
    private int quantite;
    @Column(length = 100)
    private String url;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "CODECATEGORIE")
    private Categorie categorie;

    public Article() {
    }

    public Article(Categorie categorie, String description, int noarticle, double prixunitaire,
                   int quantite, String url) {
        this.categorie = categorie;
        this.description = description;
        this.noarticle = noarticle;
        this.prixunitaire = prixunitaire;
        this.quantite = quantite;
        this.url = url;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoarticle() {
        return noarticle;
    }

    public void setNoarticle(int noarticle) {
        this.noarticle = noarticle;
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantiteenstock) {
        this.quantite = quantiteenstock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        buffer.append(getQuantite());
        buffer.append(',');
        buffer.append("url=");
        buffer.append(getUrl());
        buffer.append(']');
        return buffer.toString();
    }
}
