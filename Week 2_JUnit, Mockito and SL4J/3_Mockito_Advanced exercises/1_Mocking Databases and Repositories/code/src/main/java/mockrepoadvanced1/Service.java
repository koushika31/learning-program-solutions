package mockrepoadvanced1;

public class Service {
    private Repository repository;
    public Service(Repository repository) {
        this.repository = repository;
    }
    public String processData() {
        String data = repository.getData();
        return "Processed " + data;
    }
}
