package AdapterPatternExample;

public class PaytmAdapter implements PaymentProcessor {
    private Paytm paytm = new Paytm();

    public void processPayment(double amount) {
        paytm.sendViaPaytm(amount);
    }
}
