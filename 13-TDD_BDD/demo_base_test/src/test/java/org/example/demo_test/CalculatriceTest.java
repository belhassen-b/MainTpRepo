package org.example.demo_test;

import org.example.demo_test.Calculatrice;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CalculatriceTest {

    @Test
    void AdditionTest() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        int result = calculatrice.addition(-1, 1);

        //Assert
        Assertions.assertEquals(0, result);
    }

    @Test
    void DivisionTest() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Pour une exception
        //Act et Assert
        Assertions.assertThrows(IllegalArgumentException.class, () ->
        {
            calculatrice.division(10, 0);
        });
    }

    @Test
    void DivisionTest2() {
        //Arrange
        Calculatrice calculatrice = new Calculatrice();

        //Act
        int result = calculatrice.division(10, 2);

        //Assert
        Assertions.assertEquals(5, result);
    }
}
