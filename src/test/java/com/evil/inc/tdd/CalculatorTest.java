package com.evil.inc.tdd;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    public void setup(){
        System.out.println("CalculatorTest.setup");
        calculator = new Calculator();
    }

    @BeforeAll
    static void beforeAll() {
        System.out.println("CalculatorTest.beforeAll");
    }

    @AfterAll
    static void afterAll() {
        System.out.println("CalculatorTest.afterAll");
    }

    @AfterEach
    void tearDown() {
        System.out.println("CalculatorTest.tearDown");
    }

    @Test
    public void shouldAdd2And3ToEqual5(){
        assertEquals(5, calculator.add(2, 3), "Should add 2 and 3 to equal 5");
    }

    @Test
    public void shouldSubtract5And3ToEqual2(){
        assertEquals(2, calculator.subtract(5, 3));
    }

    @Test
    public void shouldSquare3ToEqual9(){
        assertEquals(9, calculator.square(3));
    }

    @Test
    public void shouldTrio2ToEqual8(){
        assertEquals(8, calculator.trio(2));
    }
}
