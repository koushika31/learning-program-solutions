package observer;
public class MobileApp implements Observer {
    public void update(String stockName, double stockPrice) {
        System.out.println("MobileApp Notification: " + stockName + " = ₹" + stockPrice);
    }
}
