package GestionNote;

import java.time.LocalDateTime;
import java.util.Objects;

public class Examens {
    private int id;
    private String titre;
    private Cours cours;
    private LocalDateTime dateHeure;
    private double coefficient;

    public Examens(int id, String titre, Cours cours, LocalDateTime dateHeure, double coefficient) {
        this.id = id;
        this.titre = titre;
        this.cours = cours;
        this.dateHeure = dateHeure;
        this.coefficient = coefficient;
    }


    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getTitre() { return titre; }
    public void setTitre(String titre) { this.titre = titre; }

    public Cours getCours() { return cours; }
    public void setCours(Cours cours) { this.cours = cours; }

    public LocalDateTime getDateHeure() { return dateHeure; }
    public void setDateHeure(LocalDateTime dateHeure) { this.dateHeure = dateHeure; }

    public double getCoefficient() { return coefficient; }
    public void setCoefficient(double coefficient) { this.coefficient = coefficient; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Examens examens = (Examens) o;
        return id == examens.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}