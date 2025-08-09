public class Order {
    int orderId;
    String customerName;
    double totalPrice;

    Order(int id, String name, double price) {
        orderId = id;
        customerName = name;
        totalPrice = price;
    }

    void display() {
        System.out.println("ID: " + orderId + ", Customer: " + customerName + ", Total: ₹" + totalPrice);
    }
}
