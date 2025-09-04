package GestionNote;

import java.time.LocalDate;

public class Tuteurs extends Person {
    private String lienAvecEtudiant;

    public Tuteurs(int id, String nom, String prenom, LocalDate dateNaissance,
                  String email, String telephone, String lienAvecEtudiant) {
        super(id, nom, prenom, dateNaissance, email, telephone);
        this.lienAvecEtudiant = lienAvecEtudiant;
    }

    public String getLienAvecEtudiant() { return lienAvecEtudiant; }
    public void setLienAvecEtudiant(String lienAvecEtudiant) { this.lienAvecEtudiant = lienAvecEtudiant; }
}