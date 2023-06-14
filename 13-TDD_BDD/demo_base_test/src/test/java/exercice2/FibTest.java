package exercice2;

import org.example.exercice2.Fib;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class FibTest {


    @Test
    void getFibSeriesTest() {
        // Arrange
        Fib fib = new Fib(1);
        // Act
        fib.getFibSeries();
        // Assert
        Assertions.assertFalse(fib.getFibSeries().isEmpty());
        Assertions.assertEquals(0, fib.getFibSeries().get(0));
    }

    @Test
    void getFibSeriesTest2() {
        List<Integer> expected = Arrays.asList(0, 1, 1, 2, 3, 5);
        // Arrange
        Fib fib = new Fib(6);
        // Act
        fib.getFibSeries();
        // Assert
        Assertions.assertTrue(fib.getFibSeries().contains(3));
        Assertions.assertEquals(6, fib.getFibSeries().size());
        Assertions.assertFalse(fib.getFibSeries().contains(4));
        Assertions.assertEquals(expected, fib.getFibSeries());
        Assertions.assertTrue(fib.getFibSeries().get(0) < fib.getFibSeries().get(1));
    }

}
