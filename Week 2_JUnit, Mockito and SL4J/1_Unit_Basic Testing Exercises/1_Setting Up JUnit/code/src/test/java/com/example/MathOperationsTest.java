package com.example;

import static org.junit.Assert.*;
import org.junit.Test;

public class MathOperationsTest {

    @Test
    public void testAdd() {
        MathOperations math = new MathOperations();
        assertEquals(7, math.add(3, 4));
    }
}
