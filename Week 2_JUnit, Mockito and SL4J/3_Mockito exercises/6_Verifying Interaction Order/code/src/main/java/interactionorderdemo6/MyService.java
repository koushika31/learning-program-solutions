package interactionorderdemo6;

public class MyService {
    private ExternalApi api;
    public MyService(ExternalApi api) {
        this.api = api;
    }
    public void executeSession() {
        api.login();
        api.fetchData();
        api.logout();
    }
}
