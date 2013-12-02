package model;

import java.io.Serializable;

import java.math.BigDecimal;

public class DetaillivraisonPK implements Serializable {
    public BigDecimal noarticle;
    public BigDecimal nocommande;
    public BigDecimal nolivraison;

    public DetaillivraisonPK() {
    }

    public DetaillivraisonPK(BigDecimal noarticle, BigDecimal nocommande, BigDecimal nolivraison) {
        this.noarticle = noarticle;
        this.nocommande = nocommande;
        this.nolivraison = nolivraison;
    }

    public boolean equals(Object other) {
        if (other instanceof DetaillivraisonPK) {
            final DetaillivraisonPK otherDetaillivraisonPK = (DetaillivraisonPK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
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
}
