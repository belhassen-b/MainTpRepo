package exercice3;

import org.example.exercice3.Bissextil;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BissextilTest {

    @Test
    void isBissextilTest() {
        // Arrange
        Bissextil bissextil = new Bissextil();
        // Act
        bissextil.isBissextil(2021);
        // Assert
        Assertions.assertTrue(bissextil.isBissextil(2020));
        Assertions.assertFalse(bissextil.isBissextil(2021));
        Assertions.assertTrue(bissextil.isBissextil(2024));
        Assertions.assertFalse(bissextil.isBissextil(2025));
        Assertions.assertTrue(bissextil.isBissextil(2028));
    }

}
