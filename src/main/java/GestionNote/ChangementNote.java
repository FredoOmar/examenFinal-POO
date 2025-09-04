package GestionNote;

import java.time.Instant;

public class ChangementNote {
    private double ancienneValeur;
    private double nouvelleValeur;
    private Instant dateChangement;
    private String motif;

    public ChangementNote(double ancienneValeur, double nouvelleValeur,
                       Instant dateChangement, String motif) {
        this.ancienneValeur = ancienneValeur;
        this.nouvelleValeur = nouvelleValeur;
        this.dateChangement = dateChangement;
        this.motif = motif;
    }


    public double getAncienneValeur() { return ancienneValeur; }
    public double getNouvelleValeur() { return nouvelleValeur; }
    public Instant getDateChangement() { return dateChangement; }
    public String getMotif() { return motif; }
}