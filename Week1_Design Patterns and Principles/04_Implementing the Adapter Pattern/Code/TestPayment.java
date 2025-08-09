package AdapterPatternExample;
public class TestPayment {
    public static void main(String[] args) {
        PaymentProcessor p1 = new PaytmAdapter();
        PaymentProcessor p2 = new AmazonAdapter();

        p1.processPayment(750.00);
        p2.processPayment(1200.50);
    }
}
