package interactionorderdemo6;
import static org.mockito.Mockito.*;
import org.junit.jupiter.api.Test;
import org.mockito.InOrder;
public class MyServiceTest {
    @Test
    public void testInteractionOrder() {
        ExternalApi mockApi = mock(ExternalApi.class);
        MyService service = new MyService(mockApi);
        service.executeSession();
        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).login();
        inOrder.verify(mockApi).fetchData();
        inOrder.verify(mockApi).logout();
    }
}
