package org.koushika;

public class MyService {
    private ExternalApi externalApi;
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
        public void performAction() {
        externalApi.logAction("User clicked save");
    }
}
