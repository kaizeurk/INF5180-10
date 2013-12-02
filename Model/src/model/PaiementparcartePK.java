package model;

import java.io.Serializable;

import java.math.BigDecimal;

public class PaiementparcartePK implements Serializable {
    public BigDecimal nocarte;
    public BigDecimal nopaiement;

    public PaiementparcartePK() {
    }

    public PaiementparcartePK(BigDecimal nocarte, BigDecimal nopaiement) {
        this.nocarte = nocarte;
        this.nopaiement = nopaiement;
    }

    public boolean equals(Object other) {
        if (other instanceof PaiementparcartePK) {
            final PaiementparcartePK otherPaiementparcartePK = (PaiementparcartePK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
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
}
