package com.example.myapplication.unit;

import com.example.myapplication.addition.Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class ExampleUnitTest {

    private Calculator calculator;

    @Before
    public void createCalculator() {
        calculator = new Calculator();
    }

    @Test
    public void addition_isCorrect() {
        assertEquals(4, calculator.addition(2, 2));
    }

    @Test
    public void addition_isIncorrect() {
        assertNotEquals(5, calculator.addition(2, 2));
    }

}