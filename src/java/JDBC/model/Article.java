package JDBC.model;

public class Article {
    
    private String description;
    private int noarticle;
    private double prixunitaire;
    private int quantite;
    private String url;
    private Categorie categorie;

    public Article() {
        
    }

    public Article(Categorie categorie, String description, int noarticle, double prixunitaire, int quantite, String url) {
        this.categorie = categorie;
        this.description = description;
        this.noarticle = noarticle;
        this.prixunitaire = prixunitaire;
        this.quantite = quantite;
        this.url = url;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getNoarticle() {
        return noarticle;
    }

    public void setNoarticle(int noarticle) {
        this.noarticle = noarticle;
    }

    public double getPrixunitaire() {
        return prixunitaire;
    }

    public void setPrixunitaire(double prixunitaire) {
        this.prixunitaire = prixunitaire;
    }

    public int getQuantite() {
        return quantite;
    }

    public void setQuantite(int quantiteenstock) {
        this.quantite = quantiteenstock;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
    
    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public String toString() {
        StringBuffer buffer = new StringBuffer();
        buffer.append(getClass().getName() + "@" + Integer.toHexString(hashCode()));
        buffer.append('[');
        buffer.append("description=");
        buffer.append(getDescription());
        buffer.append(',');
        buffer.append("noarticle=");
        buffer.append(getNoarticle());
        buffer.append(',');
        buffer.append("prixunitaire=");
        buffer.append(getPrixunitaire());
        buffer.append(',');
        buffer.append("quantiteenstock=");
        buffer.append(getQuantite());
        buffer.append(',');
        buffer.append("url=");
        buffer.append(getUrl());
        buffer.append(']');
        return buffer.toString();
    }
}
