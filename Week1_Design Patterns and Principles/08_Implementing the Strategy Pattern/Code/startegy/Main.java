package strategy;
public class Main {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();
        context.setStrategy(new CreditCardPayment("1234-5678-9012-3456"));
        context.executePayment(2500);
        context.setStrategy(new PayPalPayment("rmkoushika3115@gmail.com"));
        context.executePayment(1200);
    }
}
