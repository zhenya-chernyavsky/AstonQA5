package com.example;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FactorialTest {

    private Factorial calculator;

    @BeforeClass
    public void setUp() {
        calculator = new Factorial();
    }

    @Test
    public void testFactorialZero() {
        Assert.assertEquals(calculator.factorial(0), 1);
    }

    @Test
    public void testFactorialPositive() {
        Assert.assertEquals(calculator.factorial(3), 6);
    }


    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testFactorialNegative() {
        calculator.factorial(-1);
    }
}