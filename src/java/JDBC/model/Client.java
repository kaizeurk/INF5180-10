package JDBC.model;

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
    private int noclient;
    @Column(nullable = false, length = 20)
    private String nomclient;
    @Column(nullable = false, length = 15)
    private String notelephone;

    public Client() {
    }

    public Client(String _adresse, String _courriel, Date _dateinscription, String _motdepasse, int _noclient,
                  String _nomclient, String _notelephone) {
        this.adresse = _adresse;
        this.courriel = _courriel;
        this.dateinscription = _dateinscription;
        this.motdepasse = _motdepasse;
        this.noclient = _noclient;
        this.nomclient = _nomclient;
        this.notelephone = _notelephone;
    }


    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String _adresse) {
        this.adresse = _adresse;
    }

    public String getCourriel() {
        return courriel;
    }

    public void setCourriel(String _courriel) {
        this.courriel = _courriel;
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

    public int getNoclient() {
        return noclient;
    }

    public void setNoclient(int _noclient) {
        this.noclient = _noclient;
    }

    public String getNomclient() {
        return nomclient;
    }

    public void setNomclient(String _nomclient) {
        this.nomclient = _nomclient;
    }

    public String getNotelephone() {
        return notelephone;
    }

    public void setNotelephone(String _notelephone) {
        this.notelephone = _notelephone;
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
