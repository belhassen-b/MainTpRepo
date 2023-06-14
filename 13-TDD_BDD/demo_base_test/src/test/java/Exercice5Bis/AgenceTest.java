package Exercice5Bis;

import org.example.exercice5Bis.Agence;
import org.example.exercice5Bis.ConditionException;
import org.example.exercice5Bis.Voiture;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AgenceTest {

    private Agence agence;
    private Voiture voiture;

    @BeforeEach
    void setUp() {
         agence = new Agence();
    }

    @Test
    void testDailyRoutineShouldDecreaseRentDueIn() {
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(10)
                .condition(100)
                .isLuxury(false)
                .isOldCar(false)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertEquals(9, voiture.getRentDueIn());
    }

    @Test
    void testDailyRoutineShouldDecreaseCondition() {
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(0)
                .condition(100)
                .isLuxury(false)
                .isOldCar(false)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertEquals(98, voiture.getCondition());
    }

    @Test
    void testDailyRoutineShouldDecreaseConditionTwice(){
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(0)
                .condition(100)
                .isLuxury(false)
                .isOldCar(false)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertEquals(98, voiture.getCondition());
    }

    @Test
    void testDailyRoutineConditionShouldNotBeNegative() {
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(0)
                .condition(0)
                .isLuxury(false)
                .isOldCar(false)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertThrowsExactly(ConditionException.class, () -> agence.dailyRoutine(voiture));
    }

    @Test
    void testDailyRoutineConditionShouldNotBeMore100() {
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(0)
                .condition(100)
                .isLuxury(true)
                .isOldCar(false)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertEquals(100, voiture.getCondition());
    }


    @Test
    void testDailyRoutineConditionForLuxuryCarIncreaseInTime() {
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(10)
                .condition(80)
                .isLuxury(true)
                .isOldCar(false)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertEquals(81, voiture.getCondition());
    }

    @Test
    void testDailyRoutineConditionForOldCarDecreaseTwice() {
        // Arrange
        Voiture voiture = Voiture.builder()
                .rentDueIn(0)
                .condition(80)
                .isLuxury(false)
                .isOldCar(true)
                .build();
        // Act
        agence.dailyRoutine(voiture);
        // Assert
        Assertions.assertEquals(78, voiture.getCondition());
    }

}


