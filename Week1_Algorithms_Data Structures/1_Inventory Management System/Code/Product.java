public class Product {
    String productId;
    String productName;
    int quantity;
    double price;

    public Product(String productId, String productName, int quantity, double price) {
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }
    public void display() {
        System.out.println("Product ID: " + productId);
        System.out.println("Name: " + productName);
        System.out.println("Quantity: " + quantity);
        System.out.println("Price: ₹" + price);
        System.out.println("---------------------");
    }
}
