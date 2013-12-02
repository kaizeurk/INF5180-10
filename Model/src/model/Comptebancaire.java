package model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

import javax.persistence.OneToMany;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Comptebancaire.findAll", query = "select o from Comptebancaire o") })
@IdClass(ComptebancairePK.class)
public class Comptebancaire implements Serializable {
    private static final long serialVersionUID = -2673114103702913391L;
    @Id
    @Column(nullable = false)
    private BigDecimal idbanque;
    @Id
    @Column(nullable = false)
    private BigDecimal nocompte;
    @XmlTransient
    @OneToMany(mappedBy = "comptebancaire1", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Paiementparcheque> paiementparchequeList1;

    public Comptebancaire() {
    }

    public Comptebancaire(BigDecimal idbanque, BigDecimal nocompte) {
        this.idbanque = idbanque;
        this.nocompte = nocompte;
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

    @XmlTransient
    public List<Paiementparcheque> getPaiementparchequeList1() {
        return paiementparchequeList1;
    }

    @XmlTransient
    public void setPaiementparchequeList1(List<Paiementparcheque> paiementparchequeList1) {
        this.paiementparchequeList1 = paiementparchequeList1;
    }

    public Paiementparcheque addPaiementparcheque(Paiementparcheque paiementparcheque) {
        getPaiementparchequeList1().add(paiementparcheque);
        paiementparcheque.setComptebancaire1(this);
        return paiementparcheque;
    }

    public Paiementparcheque removePaiementparcheque(Paiementparcheque paiementparcheque) {
        getPaiementparchequeList1().remove(paiementparcheque);
        paiementparcheque.setComptebancaire1(null);
        return paiementparcheque;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("idbanque=");
        buffer.append(getIdbanque());
        buffer.append(',');
        buffer.append("nocompte=");
        buffer.append(getNocompte());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
