package proxy;
public class Main {
    public static void main(String[] args) {
        Image img = new ProxyImage("nature.jpg");
        System.out.println("First call:");
        img.display(); 
        System.out.println("Second call:");
        img.display(); 
    }
}
