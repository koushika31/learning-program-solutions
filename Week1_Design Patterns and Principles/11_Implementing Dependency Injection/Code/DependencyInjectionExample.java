interface CustomerRepository {
    String findCustomerById(int id);
}
class CustomerRepositoryImpl implements CustomerRepository {
    public String findCustomerById(int id) {
        return switch (id) {
            case 1 -> "Koushika";
            case 2 -> "Dhakshana";
            default -> "Customer Not Found";
        };
    }
}
class CustomerService {
    private final CustomerRepository repository;   
    public CustomerService(CustomerRepository repository) {
        this.repository = repository;
    }

    public void getCustomer(int id) {
        String customer = repository.findCustomerById(id);
        System.out.println("Customer: " + customer);
    }
}
public class DependencyInjectionExample {
    public static void main(String[] args) {
        CustomerRepository repo = new CustomerRepositoryImpl();
        CustomerService service = new CustomerService(repo);
        service.getCustomer(1); 
        service.getCustomer(3); 
    }
}
