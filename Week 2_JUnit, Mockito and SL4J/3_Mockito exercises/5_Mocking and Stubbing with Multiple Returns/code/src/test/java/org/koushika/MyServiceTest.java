package org.koushika;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
public class MyServiceTest {
    @Test
    public void testMultipleReturnValues() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData()).thenReturn("First Call", "Second Call");

        MyService service = new MyService(mockApi);
        String[] results = service.fetchTwice();

        assertEquals("First Call", results[0]);
        assertEquals("Second Call", results[1]);
    }
}
