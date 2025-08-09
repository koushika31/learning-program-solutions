package voidexceptiondemo7;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class MyServiceTest {
    @Test
    public void testVoidMethodThrowsException() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doThrow(new RuntimeException("Disconnect failed")).when(mockApi).disconnect();
        MyService service = new MyService(mockApi);
        assertThrows(RuntimeException.class, () -> service.shutdown());
        verify(mockApi).disconnect();
    }
}
