package GestionNote;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Instant;
import static org.junit.jupiter.api.Assertions.*;

public class GestionNotesTestUnit {
    private GestionNotes gestionNotes;
    private Enseignant enseignant;
    private Cours coursProg2;
    private Examens exam1, exam2;
    private Tuteurs tuteur;
    private Etudiants etudiant;

    @BeforeEach
    void setUp() {
        gestionNotes = new GestionNotes();

        enseignant = new Enseignant: (1, "Dupont", "Pierre",
                LocalDate.of(1975, 5, 15),
                "p.dupont@ecole.fr", "0123456789", "Back-end");


        coursProg2 = new Cours(1, "PROG2", 5, enseignant);
        gestionNotes.ajouterCours(coursProg2);


        exam1 = new Examens(1, "Examen partiel PROG2", coursProg2,
                LocalDateTime.of(2024, 6, 15, 9, 0), 2.0);
        exam2 = new Examens(2, "Examen final PROG2", coursProg2,
                LocalDateTime.of(2024, 7, 10, 14, 0), 3.0);
        gestionNotes.ajouterExamen(exam1);
        gestionNotes.ajouterExamen(exam2);


        tuteur = new Tuteurs(1, "Martin", "Sophie",
                LocalDate.of(1980, 3, 20),
                "s.martin@email.com", "0987654321", "Mère");


        etudiant = new Etudiants(1, "Durand", "Jean",
                LocalDate.of(2005, 8, 12),
                "j.durand@ecole.fr", "0612345678", "Groupe A", tuteur);
        gestionNotes.ajouterEtudiant(etudiant);
    }

    @Test
    void testGetExamGrade() {

        Note note = new Note(etudiant, exam1, 10.0);
        gestionNotes.ajouterNote(Note);

        Instant maintenant = Instant.now();
        double noteObtenue = gestionNotes.getExamGrade(exam1, etudiant, maintenant);

        assertEquals(10.0, noteObtenue, 0.001);
    }

    @Test
    void testGetExamGradeAvecHistorique() {

        Note note = new Note(etudiant, exam1, 10.0);


        note.modifierNote(12.0, "Révision de la copie");

        Instant apresModification = Instant.now().plusSeconds(10);
        double noteObtenue = gestionNotes.getExamGrade(exam1, etudiant, apresModification);

        assertEquals(12.0, noteObtenue, 0.001);
    }

    @Test
    void testGetCourseGrade() {
        // Création des notes pour les deux examens
        Note noteExam1 = new Note(etudiant, exam1, 10.0);
        Note noteExam2 = new Note(etudiant, exam2, 15.0);

        gestionNotes.ajouterNote(noteExam1);
        gestionNotes.ajouterNote(noteExam2);

        Instant maintenant = Instant.now();
        double noteFinale = gestionNotes.getCourseGrade(coursProg2, etudiant, maintenant);


        assertEquals(13.0, noteFinale, 0.001);
    }

    @Test
    void testGetCourseGradeAvecModifications() {

        Note noteExam1 = new Noteetudiant, exam1, 10.0);
        Note noteExam2 = new Note(etudiant, exam2, 15.0);

        gestionNotes.ajouterNote(noteExam1);
        gestionNotes.ajouterNote(noteExam2);

        Instant avantModification = Instant.now();


        noteExam1.modifierNote(12.0, "Correction d'erreur");
        noteExam2.ChangementNote(16.0, "Bonus participation");


        double noteFinale = gestionNotes.getCourseGrade(coursProg2, etudiant, avantModification);


        assertEquals(13.0, noteFinale, 0.001);
    }

    @Test
    void testNoteInexistante() {
        Instant maintenant = Instant.now();
        double note = gestionNotes.getExamGrade(exam1, etudiant, maintenant);

        assertEquals(0.0, note, 0.001); // Note par défaut pour un examen non trouvé
    }
}
