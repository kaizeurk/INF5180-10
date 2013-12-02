package model;

import java.io.Serializable;

import java.math.BigDecimal;

public class PaiementparchequePK implements Serializable {
    public BigDecimal nocheque;
    public BigDecimal nopaiement;

    public PaiementparchequePK() {
    }

    public PaiementparchequePK(BigDecimal nocheque, BigDecimal nopaiement) {
        this.nocheque = nocheque;
        this.nopaiement = nopaiement;
    }

    public boolean equals(Object other) {
        if (other instanceof PaiementparchequePK) {
            final PaiementparchequePK otherPaiementparchequePK = (PaiementparchequePK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getNocheque() {
        return nocheque;
    }

    public void setNocheque(BigDecimal nocheque) {
        this.nocheque = nocheque;
    }

    public BigDecimal getNopaiement() {
        return nopaiement;
    }

    public void setNopaiement(BigDecimal nopaiement) {
        this.nopaiement = nopaiement;
    }
}
