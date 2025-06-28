package org.koushika.demo;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
public class ExceptionThrowerTest {
    @Test
    void testThrowException() {
        ExceptionThrower obj = new ExceptionThrower();
        assertThrows(IllegalArgumentException.class, obj::throwException);
    }
}
