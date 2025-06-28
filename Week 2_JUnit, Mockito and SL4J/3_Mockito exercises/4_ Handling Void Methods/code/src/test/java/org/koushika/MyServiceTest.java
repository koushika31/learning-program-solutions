package org.koushika;

import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
public class MyServiceTest {
    @Test
    public void testVoidMethodInteraction() {
        ExternalApi mockApi = mock(ExternalApi.class);
        doNothing().when(mockApi).logAction(anyString());
        MyService service = new MyService(mockApi);
        service.performAction();
        verify(mockApi).logAction("User clicked save");
    }
}
