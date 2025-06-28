package com.example;
import org.junit.Test;
import static org.junit.Assert.*;

public class MathUtilsTest {
    MathUtils utils = new MathUtils();
    @Test
    public void testAdd() {
        assertEquals(10, utils.add(7, 3));
    }
    @Test
    public void testSubtract() {
        assertEquals(4, utils.subtract(10, 6));
    }
    @Test
    public void testMultiply() {
        assertEquals(21, utils.multiply(7, 3));
    }
}
