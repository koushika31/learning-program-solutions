public class Product {
    public int productId;
    public String productName;
    public String category;

    public Product(int id, String name, String cat) {
        this.productId = id;
        this.productName = name;
        this.category = cat;
    }
    public void display() {
        System.out.println("ID: " + productId + ", Name: " + productName + ", Category: " + category);
    }
}
