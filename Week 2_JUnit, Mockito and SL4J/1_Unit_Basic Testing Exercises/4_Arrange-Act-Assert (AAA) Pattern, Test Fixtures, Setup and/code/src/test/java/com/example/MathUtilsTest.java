package com.example;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;
import static org.junit.Assert.*;
public class MathUtilsTest {
    private MathUtils math;
    @Before
    public void setUp() {
        math = new MathUtils();
        System.out.println("Setup complete");
    }
    @After
    public void tearDown() {
        math = null;
        System.out.println("Teardown complete");
    }
    @Test
    public void testAdd() {
        int a = 4, b = 6;
        int result = math.add(a, b);
        assertEquals(10, result);
    }
    @Test
    public void testMultiply() {
        int a = 3, b = 5; 
        int result = math.multiply(a, b);
        assertEquals(15, result);
    }
}
