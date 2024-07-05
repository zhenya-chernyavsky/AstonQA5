package com.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FactorialCalculatorTest {

    private final Factorial calculator = new Factorial();

    @Test
    public void testFactorialZero() {
        Assertions.assertEquals(1, calculator.factorial(0));
    }

    @Test
    public void testFactorialPositive() {
        Assertions.assertEquals(6, calculator.factorial(3));
    }

    @Test
    public void testFactorialNegative() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> calculator.factorial(-1));
    }
}
