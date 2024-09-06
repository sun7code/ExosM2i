package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

public class RechercheVilleTest {
    private RechercheVille rechercheVille;

    @BeforeEach
    void setUp() {
        rechercheVille = new RechercheVille();
    }

    @Test
    void testRechercheMotTropCourt() {
        // Arrange
        String motRecherche = "P";

        // Act & Assert
        assertThrows(NotFoundException.class, () -> rechercheVille.rechercher(motRecherche));
    }

    @Test
    void testRechercheDebutMot() throws NotFoundException {
        // Arrange
        String motRecherche = "Va";

        // Act
        List<String> resultat = rechercheVille.rechercher(motRecherche);

        // Assert
        assertEquals(2, resultat.size());
        assertTrue(resultat.contains("Valence"));
        assertTrue(resultat.contains("Vancouver"));
    }

    @Test
    void testRechercheInsensibleCasse() throws NotFoundException {
        // Arrange
        String motRecherche = "pAr";

        // Act
        List<String> resultat = rechercheVille.rechercher(motRecherche);

        // Assert
        assertEquals(1, resultat.size());
        assertTrue(resultat.contains("Paris"));
    }

}
