package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class AppTest {


    @Test
    public void testSubtraction() {
        Operation subtraction = new Subtraction();
        assertEquals(-1.0, subtraction.calculate(2.0, 3.0));
        assertEquals(-3.0, subtraction.calculate(-2.0, 1.0));
    }

    @Test
    public void testMultiplication() {
        Operation multiplication = new Multiplication();
        assertEquals(6.0, multiplication.calculate(2.0, 3.0));
        assertEquals(-2.0, multiplication.calculate(-2.0, 1.0));
        assertEquals(2.0, multiplication.calculate(2.0, 1.0));
    }

    @Test
    public void testDivision() {
        Operation division = new Division();
        assertEquals(2.0, division.calculate(6.0, 3.0));
        assertThrows(ArithmeticException.class, () -> {
            division.calculate(1.0, 0);
        });
    }
    @Test
    public void testAddition() {
        Operation addition = new Addition();
        assertEquals(5.0, addition.calculate(2.0, 3.0));
        assertEquals(-1.0, addition.calculate(-2.0, 1.0));
    }

    @Test
    public void testCalculatorPerformOperation() {
        Calculator calculator = new Calculator();
        assertEquals(5.0, calculator.performOperation(new Addition(), 2.0, 3.0));
        assertEquals(1.0, calculator.performOperation(new Subtraction(), 3.0, 2.0));
        assertEquals(6.0, calculator.performOperation(new Multiplication(), 2.0, 3.0));
        assertEquals(2.0, calculator.performOperation(new Division(), 6.0, 3.0));
        assertThrows(ArithmeticException.class, () -> {

            calculator.performOperation(new Division(), 1.0, 0);
        });
    }
}