package model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Cartecredit.findAll", query = "select o from Cartecredit o") })
public class Cartecredit implements Serializable {
    private static final long serialVersionUID = -3383144917579498509L;
    @Id
    @Column(nullable = false)
    private BigDecimal nocarte;
    @Column(nullable = false)
    private BigDecimal numeroautorisation;
    @Column(nullable = false, length = 18)
    private String sortecarte;
    @XmlTransient
    @OneToMany(mappedBy = "cartecredit", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Paiementparcarte> paiementparcarteList1;

    public Cartecredit() {
    }

    public Cartecredit(BigDecimal nocarte, BigDecimal numeroautorisation, String sortecarte) {
        this.nocarte = nocarte;
        this.numeroautorisation = numeroautorisation;
        this.sortecarte = sortecarte;
    }


    public BigDecimal getNocarte() {
        return nocarte;
    }

    public void setNocarte(BigDecimal nocarte) {
        this.nocarte = nocarte;
    }

    public BigDecimal getNumeroautorisation() {
        return numeroautorisation;
    }

    public void setNumeroautorisation(BigDecimal numeroautorisation) {
        this.numeroautorisation = numeroautorisation;
    }

    public String getSortecarte() {
        return sortecarte;
    }

    public void setSortecarte(String sortecarte) {
        this.sortecarte = sortecarte;
    }

    @XmlTransient
    public List<Paiementparcarte> getPaiementparcarteList1() {
        return paiementparcarteList1;
    }

    @XmlTransient
    public void setPaiementparcarteList1(List<Paiementparcarte> paiementparcarteList1) {
        this.paiementparcarteList1 = paiementparcarteList1;
    }

    public Paiementparcarte addPaiementparcarte(Paiementparcarte paiementparcarte) {
        getPaiementparcarteList1().add(paiementparcarte);
        paiementparcarte.setCartecredit(this);
        return paiementparcarte;
    }

    public Paiementparcarte removePaiementparcarte(Paiementparcarte paiementparcarte) {
        getPaiementparcarteList1().remove(paiementparcarte);
        paiementparcarte.setCartecredit(null);
        return paiementparcarte;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("nocarte=");
        buffer.append(getNocarte());
        buffer.append(',');
        buffer.append("numeroautorisation=");
        buffer.append(getNumeroautorisation());
        buffer.append(',');
        buffer.append("sortecarte=");
        buffer.append(getSortecarte());
        buffer.append(']');
        return buffer.toString();
    }
}
