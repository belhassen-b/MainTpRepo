package exercice1;

import org.example.exercice1.GradingCalculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class GradingCalculatorTest {

    @Test
        //- Score : 95%, Présence : 90 => Note: A
    void getGradeTest() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();
        // Act
        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(90);
        // Assert
        Assertions.assertEquals('A', gradingCalculator.getGrade());
    }

    @Test
    void getGradeTest2() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();

        // Act
        gradingCalculator.setScore(85);
        gradingCalculator.setAttendancePercentage(90);

        // Assert
        Assertions.assertEquals('B', gradingCalculator.getGrade());

    }

    @Test
    void getGradeTest3() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();

        // Act

        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(90);

        // Assert

        Assertions.assertEquals('C', gradingCalculator.getGrade());
    }

    @Test
    void getGradeTest4() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();

        // Act

        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(65);

        // Assert

        Assertions.assertEquals('B', gradingCalculator.getGrade());
    }

    @Test
    void getGradeTest5() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();

        // Act

        gradingCalculator.setScore(95);
        gradingCalculator.setAttendancePercentage(55);

        // Assert

        Assertions.assertEquals('F', gradingCalculator.getGrade());
    }

    @Test
    void getGradeTest6() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();

        // Act

        gradingCalculator.setScore(65);
        gradingCalculator.setAttendancePercentage(55);

        // Assert

        Assertions.assertEquals('F', gradingCalculator.getGrade());
    }

    @Test
    void getGradeTest7() {
        // Arrange
        GradingCalculator gradingCalculator = new GradingCalculator();

        // Act

        gradingCalculator.setScore(50);
        gradingCalculator.setAttendancePercentage(90);

        // Assert

        Assertions.assertEquals('F', gradingCalculator.getGrade());
    }
//    @Test
//    void getGradeTest8() {
//        // Arrange
//        GradingCalculator gradingCalculator = new GradingCalculator();
//
//        // Act
//
//        gradingCalculator.setScore(65);
//        gradingCalculator.setAttendancePercentage(55);
//
//        // Assert
//
//        Assertions.assertEquals('G', gradingCalculator.getGrade());
//    }

}

