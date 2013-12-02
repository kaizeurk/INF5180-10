package model;

import java.io.Serializable;

import java.math.BigDecimal;

public class ComptebancairePK implements Serializable {
    public BigDecimal idbanque;
    public BigDecimal nocompte;

    public ComptebancairePK() {
    }

    public ComptebancairePK(BigDecimal idbanque, BigDecimal nocompte) {
        this.idbanque = idbanque;
        this.nocompte = nocompte;
    }

    public boolean equals(Object other) {
        if (other instanceof ComptebancairePK) {
            final ComptebancairePK otherComptebancairePK = (ComptebancairePK) other;
            final boolean areEqual = true;
            return areEqual;
        }
        return false;
    }

    public int hashCode() {
        return super.hashCode();
    }

    public BigDecimal getIdbanque() {
        return idbanque;
    }

    public void setIdbanque(BigDecimal idbanque) {
        this.idbanque = idbanque;
    }

    public BigDecimal getNocompte() {
        return nocompte;
    }

    public void setNocompte(BigDecimal nocompte) {
        this.nocompte = nocompte;
    }
}
