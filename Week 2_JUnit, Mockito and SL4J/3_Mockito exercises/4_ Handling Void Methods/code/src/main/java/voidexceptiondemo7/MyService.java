package voidexceptiondemo7;

public class MyService {
    private ExternalApi api;
    public MyService(ExternalApi api) {
        this.api = api;
    }
    public void shutdown() {
        api.disconnect();
    }
}
