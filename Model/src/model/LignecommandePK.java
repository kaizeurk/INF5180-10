package model;

import java.io.Serializable;

import java.math.BigDecimal;

public class LignecommandePK implements Serializable {
    public BigDecimal noarticle;
    public BigDecimal nocommande;

    public LignecommandePK() {
    }

    public LignecommandePK(BigDecimal noarticle, BigDecimal nocommande) {
        this.noarticle = noarticle;
        this.nocommande = nocommande;
    }

    public boolean equals(Object other) {
        if (other instanceof LignecommandePK) {
            final LignecommandePK otherLignecommandePK = (LignecommandePK) other;
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
}
