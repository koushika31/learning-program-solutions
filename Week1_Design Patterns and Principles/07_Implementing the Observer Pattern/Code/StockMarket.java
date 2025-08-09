package observer;
import java.util.*;
public class StockMarket implements Stock {
    private List<Observer> observers = new ArrayList<>();
    private String stockName;
    private double stockPrice;

    public void updateStock(String name, double price) {
        this.stockName = name;
        this.stockPrice = price;
        notifyObservers();
    }
    public void register(Observer o) {
        observers.add(o);
    }
    public void deregister(Observer o) {
        observers.remove(o);
    }
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(stockName, stockPrice);
        }
    }
}
