package org.koushika;

public class MyService {
    private ExternalApi externalApi;
    public MyService(ExternalApi externalApi) {
        this.externalApi = externalApi;
    }
    public String[] fetchTwice() {
        String first = externalApi.getData();
        String second = externalApi.getData();
        return new String[] { first, second };
    }
}
