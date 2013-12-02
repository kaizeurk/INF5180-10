package model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Commande.findAll", query = "select o from Commande o") })
public class Commande implements Serializable {
    private static final long serialVersionUID = 3366700937014838413L;
    @Temporal(TemporalType.DATE)
    @Column(nullable = false)
    private Date datecommande;
    @Id
    @Column(nullable = false)
    private BigDecimal nocommande;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "NOCLIENT")
    private Client client;
    @XmlTransient
    @OneToMany(mappedBy = "commande", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Lignecommande> lignecommandeList1;
    @XmlTransient
    @ManyToOne
    @JoinColumn(name = "CODESTATUT")
    private Statut statut;

    public Commande() {
    }

    public Commande(Statut statut, Date datecommande, Client client, BigDecimal nocommande) {
        this.statut = statut;
        this.datecommande = datecommande;
        this.client = client;
        this.nocommande = nocommande;
    }


    public Date getDatecommande() {
        return datecommande;
    }

    public void setDatecommande(Date datecommande) {
        this.datecommande = datecommande;
    }


    public BigDecimal getNocommande() {
        return nocommande;
    }

    public void setNocommande(BigDecimal nocommande) {
        this.nocommande = nocommande;
    }

    @XmlTransient
    public Client getClient() {
        return client;
    }

    @XmlTransient
    public void setClient(Client client) {
        this.client = client;
    }

    @XmlTransient
    public List<Lignecommande> getLignecommandeList1() {
        return lignecommandeList1;
    }

    @XmlTransient
    public void setLignecommandeList1(List<Lignecommande> lignecommandeList1) {
        this.lignecommandeList1 = lignecommandeList1;
    }

    public Lignecommande addLignecommande(Lignecommande lignecommande) {
        getLignecommandeList1().add(lignecommande);
        lignecommande.setCommande(this);
        return lignecommande;
    }

    public Lignecommande removeLignecommande(Lignecommande lignecommande) {
        getLignecommandeList1().remove(lignecommande);
        lignecommande.setCommande(null);
        return lignecommande;
    }

    @XmlTransient
    public Statut getStatut() {
        return statut;
    }

    @XmlTransient
    public void setStatut(Statut statut) {
        this.statut = statut;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("datecommande=");
        buffer.append(getDatecommande());
        buffer.append(',');
        buffer.append("nocommande=");
        buffer.append(getNocommande());
        buffer.append(',');
        buffer.append(']');
        return buffer.toString();
    }
}
