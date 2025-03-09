package model;

public class OffreEmploi {
    private int idOffre;
    private String titre;
    private String description;
    private String datePublication;
    private String location;
    private  String experience;

    public OffreEmploi(int idOffre, String titre, String description, String datePublication, String location, String experience) {
        this.idOffre = idOffre;
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.location = location;
        this.experience = experience;
    }

    public OffreEmploi(String titre, String description, String datePublication, String location, String experience) {
        this.titre = titre;
        this.description = description;
        this.datePublication = datePublication;
        this.location = location;
        this.experience = experience;
    }

    public int getIdOffre() {
        return idOffre;
    }

    public void setIdOffre(int idOffre) {
        this.idOffre = idOffre;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDatePublication() {
        return datePublication;
    }

    public void setDatePublication(String datePublication) {
        this.datePublication = datePublication;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }
}
