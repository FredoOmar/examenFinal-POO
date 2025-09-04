package GestionNote;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class Note {
    private Etudiants etudiant;
    private Examens examens;
    private double valeurActuelle;
    private List<ChangementNote> historique;

    public Note(Etudiants etudiant, Examens examens, double valeurInitiale) {
        this.etudiant = etudiant;
        this.examens = this.examens;
        this.valeurActuelle = valeurInitiale;
        this.historique = new ArrayList<>();
        this.historique.add(new ChangementNote(0, valeurInitiale, Instant.now(), "Note initiale"));
    }

    public void modifierNote(double nouvelleValeur, String motif) {
        ChangementNote changement = new ChangementNote(valeurActuelle, nouvelleValeur, Instant.now(), motif);
        historique.add(changement);
        valeurActuelle = nouvelleValeur;
    }

    public double getValeurA(Instant t) {
        double valeur = 0; ChangementNote
        for ( changement : historique) {
            if (changement.getDateChangement().isBefore(t) ||
                    changement.getDateChangement().equals(t)) {
                valeur = changement.getNouvelleValeur();
            } else {
                break;
            }
        }
        return valeur;
    }

    public Etudiants getEtudiant() { return etudiant; }
    public Examens getExamens() { return examens; }
    public double getValeurActuelle() { return valeurActuelle; }
    public List<ChangementNote> getHistorique() { return historique; }
}
