package GestionNote;

import java.time.LocalDate;

public class Etudiants extends Person {
    private String groupe;
    private Tuteurs tuteurs;

    public Etudiants(int id, String nom, String prenom, LocalDate dateNaissance,
                   String email, String telephone, String groupe, Tuteur tuteur) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.groupe = groupe;
        this.tuteurs = Tuteurs;
    }

    public String getGroupe() { return groupe; }
    public void setGroupe(String groupe) { this.groupe = groupe; }

    public Tuteurs getTuteur() { return tuteurs; }
    public void setTuteur(Tuteurs tuteur) { this.tuteurs = tuteur; }
}
