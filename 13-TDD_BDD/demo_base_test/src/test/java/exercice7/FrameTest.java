package exercice7;

import org.example.exercice7.Frame;
import org.example.exercice7.IGenerateur;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class FrameTest {

    private Frame frame;

    @Mock
    private IGenerateur IGenerateur;

    @BeforeEach
    void setUp() {
        frame = new Frame(IGenerateur, false);
    }

    @Test
    void Roll_SimpleFrame_FirstRoll_CheckScore() throws Exception {
        // Arrange
        Mockito.when(IGenerateur.randomPin(10)).thenReturn(5);
        // Act
        frame.makeRoll();
        // Assert
        Assertions.assertEquals(5, frame.getScore());
    }


}
