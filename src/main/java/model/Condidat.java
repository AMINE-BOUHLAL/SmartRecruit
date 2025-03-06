package model;

import java.awt.*;

public class Condidat extends User {
    private Image cv;

    public Condidat(String nom, String prenom, String email, String tel, String password, String roles) {
        super(nom, prenom, email, tel, password, roles);
    }

    public Image getCv() {
        return cv;
    }

    public void setCv(Image cv) {
        this.cv = cv;
    }
}
