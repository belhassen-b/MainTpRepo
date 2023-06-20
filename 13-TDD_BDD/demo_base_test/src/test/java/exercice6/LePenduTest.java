package exercice6;


import org.example.exercice6.LePendu;
import org.example.exercice6.IGenerateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LePenduTest {

    private LePendu lePendu;

    @Mock
    private IGenerateur IGenerateur;

    @Test
    void testGenererMasque() throws Exception {
        // Arrange

        Mockito.when(IGenerateur.generer()).thenReturn("test");
        // Act
        lePendu.genererMasque(IGenerateur);
        // Assert
        Assertions.assertEquals("****", lePendu.getMasque());
    }

    @Test
    void testGenererMasqueShouldRaiseExceptionNotCorrectString() throws Exception {
        // Arrange

        Mockito.when(IGenerateur.generer()).thenReturn("");
        // Act
        // Assert
        Assertions.assertThrowsExactly(Exception.class, () -> lePendu.genererMasque(IGenerateur));
    }


    @Test
    void testTestChar() throws Exception {
        // Arrange
        LePendu lePendu = LePendu.builder()
                .nbEssai(10)
                .motATrouve("test")
                .build();
        Mockito.when(IGenerateur.generer()).thenReturn("test");
        lePendu.genererMasque(IGenerateur);
        // Act
        lePendu.testChar('t');
        // Assert
        Assertions.assertEquals("*t**", lePendu.getMasque());
    }
}
