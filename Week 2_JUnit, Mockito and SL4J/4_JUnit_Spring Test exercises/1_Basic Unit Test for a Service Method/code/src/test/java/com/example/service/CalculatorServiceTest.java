package com.example.service;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorServiceTest {

    @Test
    void testAdd() {
        CalculatorService calculator = new CalculatorService();
        assertEquals(10, calculator.add(7, 3));
        assertEquals(0, calculator.add(-2, 2));
        assertEquals(-7, calculator.add(-4, -3));
    }
}
