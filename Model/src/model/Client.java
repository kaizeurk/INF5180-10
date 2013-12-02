package model;

import java.io.Serializable;

import java.math.BigDecimal;

import java.util.Date;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import javax.xml.bind.annotation.XmlTransient;

@Entity
@NamedQueries({ @NamedQuery(name = "Client.findAll", query = "select o from Client o") })
public class Client implements Serializable {
    private static final long serialVersionUID = -403681682563625652L;
    @Column(nullable = false, length = 100)
    private String adresse;
    @Column(length = 100)
    private String courriel;
    @Temporal(TemporalType.DATE)
    private Date dateinscription;
    @Column(nullable = false, length = 50)
    private String motdepasse;
    @Id
    @Column(nullable = false)
    private BigDecimal noclient;
    @Column(nullable = false, length = 20)
    private String nomclient;
    @Column(nullable = false, length = 15)
    private String notelephone;
    @XmlTransient
    @OneToMany(mappedBy = "client", cascade = { CascadeType.PERSIST, CascadeType.MERGE })
    private List<Commande> commandeList;

    public Client() {
    }

    public Client(String adresse, String courriel, Date dateinscription, String motdepasse, BigDecimal noclient,
                  String nomclient, String notelephone) {
        this.adresse = adresse;
        this.courriel = courriel;
        this.dateinscription = dateinscription;
        this.motdepasse = motdepasse;
        this.noclient = noclient;
        this.nomclient = nomclient;
        this.notelephone = notelephone;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String courriel) {
        this.courriel = courriel;
    }

    public Date getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(Date dateinscription) {
        this.dateinscription = dateinscription;
    }

    public String getMotdepasse() {
        return motdepasse;
    }

    public void setMotdepasse(String motdepasse) {
        this.motdepasse = motdepasse;
    }

    public BigDecimal getNoclient() {
        return noclient;
    }

    public void setNoclient(BigDecimal noclient) {
        this.noclient = noclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public String getNotelephone() {
        return notelephone;
    }

    public void setNotelephone(String notelephone) {
        this.notelephone = notelephone;
    }

    @XmlTransient
    public List<Commande> getCommandeList() {
        return commandeList;
    }

    @XmlTransient
    public void setCommandeList(List<Commande> commandeList) {
        this.commandeList = commandeList;
    }

    public Commande addCommande(Commande commande) {
        getCommandeList().add(commande);
        commande.setClient(this);
        return commande;
    }

    public Commande removeCommande(Commande commande) {
        getCommandeList().remove(commande);
        commande.setClient(null);
        return commande;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("adresse=");
        buffer.append(getAdresse());
        buffer.append(',');
        buffer.append("courriel=");
        buffer.append(getCourriel());
        buffer.append(',');
        buffer.append("dateinscription=");
        buffer.append(getDateinscription());
        buffer.append(',');
        buffer.append("motdepasse=");
        buffer.append(getMotdepasse());
        buffer.append(',');
        buffer.append("noclient=");
        buffer.append(getNoclient());
        buffer.append(',');
        buffer.append("nomclient=");
        buffer.append(getNomclient());
        buffer.append(',');
        buffer.append("notelephone=");
        buffer.append(getNotelephone());
        buffer.append(']');
        return buffer.toString();
    }
}
