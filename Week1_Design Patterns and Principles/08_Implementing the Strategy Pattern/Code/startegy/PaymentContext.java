package strategy;
public class PaymentContext {
    private PaymentStrategy strategy;

    public PaymentContext() {
        // default constructor
    }
    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    public void executePayment(double amount) {
        if (strategy != null) {
            strategy.pay(amount);
        } else {
            System.out.println("No payment strategy selected.");
        }
    }
}
