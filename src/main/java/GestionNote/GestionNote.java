package GestionNote;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GestionNotes {
    private List<Etudiants> etudiants;
    private List<Enseignant> enseignants;
    private List<Tuteurs> tuteurs;
    private List<Cours> cours;
    private List<Exam> examens;
    private List<Grade> notes;
    private Promotion promotion;

    public GestionNotes() {
        this.etudiants = new ArrayList<>();
        this.enseignants = new ArrayList<>();
        this.tuteurs = new ArrayList<>();
        this.cours = new ArrayList<>();
        this.examens = new ArrayList<>();
        this.notes = new ArrayList<>();
        this.promotion = new Promotion();
    }

    public double getExamGrade(Exam exam, Etudiants Etudiants, Instant t) {
        for (Grade note : notes) {
            if (note.getExamen().equals(examens) && note.getEtudiant().equals(Etudiants)) {
                return note.getValeurA(t);
            }
        }
        return 0.0; // Ou lancer une exception si la note n'existe pas
    }

    public double getCourseGrade(Cours course, Etudiants Etudiants, Instant t) {
        double sommeNotesPonderees = 0.0;
        double sommeCoefficients = 0.0;

        for (Exam exam : examens) {
            if (exam.getCours().equals(course)) {
                double note = getExamGrade(Exa, Etudiants, t);
                sommeNotesPonderees += note * exam.getCoefficient();
                sommeCoefficients += exam.getCoefficient();
            }
        }

        if (sommeCoefficients == 0.0) {
            return 0.0; // Ou lancer une exception si aucun examen trouvé
        }

        return sommeNotesPonderees / sommeCoefficients;
    }

    // Méthodes d'ajout
    public void ajouterEtudiant(Student etudiant) {
        etudiants.add(etudiant);
        promotion.ajouterGroupe(etudiant.getGroupe());
    }

    public void ajouterNote(Grade note) {
        notes.add(note);
    }

    public void ajouterExamen(Exam examen) {
        examens.add(examen);
    }

    public void ajouterCours(Course cours) {
        this.cours.add(cours);
    }

    // Getters
    public List<Student> getEtudiants() { return etudiants; }
    public List<Teacher> getEnseignants() { return enseignants; }
    public List<Tuteur> getTuteurs() { return tuteurs; }
    public List<Course> getCours() { return cours; }
    public List<Exam> getExamens() { return examens; }
    public List<Grade> getNotes() { return notes; }
    public Promotion getPromotion() { return promotion; }
}
