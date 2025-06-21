package AdapterPatternExample;
public class AmazonAdapter implements PaymentProcessor {
    private AmazonPay amazon = new AmazonPay();

    public void processPayment(double amount) {
        amazon.transferUsingAmazon(amount);
    }
}
