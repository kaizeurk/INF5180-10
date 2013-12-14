package JDBC.model;

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
@NamedQueries({ @NamedQuery(name = "Categorie.findAll", query = "select o from Categorie o") })
public class Categorie implements Serializable {
    private static final long serialVersionUID = -1153201192010489989L;
    @Id
    @Column(nullable = false, length = 10)
    private String codecategorie;
    @Column(nullable = false, length = 50)
    private String desccategorie;

    public Categorie() {
    }

    public Categorie(String codecategorie, String desccategorie) {
        this.codecategorie = codecategorie;
        this.desccategorie = desccategorie;
    }


    public String getCodecategorie() {
        return codecategorie;
    }

    public void setCodecategorie(String codecategorie) {
        this.codecategorie = codecategorie;
    }

    public String getDesccategorie() {
        return desccategorie;
    }

    public void setDesccategorie(String desccategorie) {
        this.desccategorie = desccategorie;
    }

    @Override
    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("codecategorie=");
        buffer.append(getCodecategorie());
        buffer.append(',');
        buffer.append("desccategorie=");
        buffer.append(getDesccategorie());
        buffer.append(']');
        return buffer.toString();
    }
}
