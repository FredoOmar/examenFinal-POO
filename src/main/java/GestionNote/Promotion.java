package GestionNote;

import java.util.HashSet;
import java.util.Set;

public class Promotion {
    private Set<String> groupes;

    public Promotion() {
        this.groupes = new HashSet<>();
    }

    public void ajouterGroupe(String groupe) {
        groupes.add(groupe);
    }

    public void supprimerGroupe(String groupe) {
        groupes.remove(groupe);
    }

    public boolean contientGroupe(String groupe) {
        return groupes.contains(groupe);
    }

    public Set<String> getGroupes() {
        return new HashSet<>(groupes);
    }
}