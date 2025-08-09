package observer;
public class Main {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();
        Observer mobile = new MobileApp();
        Observer web = new WebApp();
        stockMarket.register(mobile);
        stockMarket.register(web);
        stockMarket.updateStock("CTS", 3750.50);
        stockMarket.updateStock("TCS", 3655.00);
    }
}
