package com.example;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class MathUtilsTest {
    @Test
    void testAdd() {
        MathUtils mu = new MathUtils();
        assertEquals(5, mu.add(2, 3));
    }
}
