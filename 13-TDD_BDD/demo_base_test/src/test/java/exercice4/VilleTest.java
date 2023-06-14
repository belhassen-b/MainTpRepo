package exercice4;

import org.example.exercice4.Ville;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class VilleTest {

    private Ville ville;

    @BeforeEach
    void setUp() {
        ville = new Ville();

    }

        @Test
        void rechercherTest() {
            // Arrange
            Ville ville = new Ville();
            // Act
            ville.rechercher("Paris");
            // Assert
            Assertions.assertTrue(ville.rechercher("Paris").contains("Paris"));
}
}
