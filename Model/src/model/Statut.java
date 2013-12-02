package model;

import java.io.Serializable;

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
@NamedQueries({ @NamedQuery(name = "Statut.findAll", query = "select o from Statut o") })
public class Statut implements Serializable {
    private static final long serialVersionUID = 4750396986518430850L;
    @Id
    @Column(nullable = false, length = 5)
    private String codestatut;
    @Column(nullable = false, length = 25)
    private String desstatut;
    @XmlTransient
    @OneToMany(mappedBy = "statut", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Commande> commandeList1;

    public Statut() {
    }

    public Statut(String codestatut, String desstatut) {
        this.codestatut = codestatut;
        this.desstatut = desstatut;
    }


    public String getCodestatut() {
        return codestatut;
    }

    public void setCodestatut(String codestatut) {
        this.codestatut = codestatut;
    }

    public String getDesstatut() {
        return desstatut;
    }

    public void setDesstatut(String desstatut) {
        this.desstatut = desstatut;
    }

    @XmlTransient
    public List<Commande> getCommandeList1() {
        return commandeList1;
    }

    @XmlTransient
    public void setCommandeList1(List<Commande> commandeList1) {
        this.commandeList1 = commandeList1;
    }

    public Commande addCommande(Commande commande) {
        getCommandeList1().add(commande);
        commande.setStatut(this);
        return commande;
    }

    public Commande removeCommande(Commande commande) {
        getCommandeList1().remove(commande);
        commande.setStatut(null);
        return commande;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("codestatut=");
        buffer.append(getCodestatut());
        buffer.append(',');
        buffer.append("desstatut=");
        buffer.append(getDesstatut());
        buffer.append(']');
        return buffer.toString();
    }
}
