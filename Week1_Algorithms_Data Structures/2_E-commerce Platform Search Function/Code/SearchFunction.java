import java.util.*;
public class SearchFunction {
    public static int linearSearch(Product[] products, String searchName) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(searchName)) {
                return i;
            }
        }
        return -1;
    }
    public static int binarySearch(Product[] products, String searchName) {
        int left = 0, right = products.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = products[mid].productName.compareToIgnoreCase(searchName);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    public static void sortProducts(Product[] products) {
        Arrays.sort(products, Comparator.comparing(p -> p.productName.toLowerCase()));
    }

    public static void displayArray(Product[] products) {
        for (Product p : products) {
            p.display();
        }
    }
    public static void main(String[] args) {
        // Unique Product List
        Product[] productList = {
            new Product(201, "AirPods", "Audio"),
            new Product(202, "Blender", "Home Appliances"),
            new Product(203, "Camera", "Electronics"),
            new Product(204, "Desk", "Furniture"),
            new Product(205, "Knife", "Kitchen")
        };
        Scanner sc = new Scanner(System.in);
        System.out.println("Unsorted Product List:");
        displayArray(productList);

        System.out.print("\nEnter product name to search: ");
        String searchInput = sc.nextLine();
    
        // Linear Search
        int linIndex = linearSearch(productList, searchInput);
        System.out.println("\nLinear Search Result:");
        if (linIndex != -1) {
            productList[linIndex].display();
        } else {
            System.out.println("Product not found.");
        }
        // Sort products
        sortProducts(productList);
        System.out.println("\nSorted Product List for Binary Search:");
        displayArray(productList);
        // Binary Search
        int binIndex = binarySearch(productList, searchInput);
        System.out.println("\nBinary Search Result:");
        if (binIndex != -1) {
            productList[binIndex].display();
        } else {
            System.out.println("Product not found.");
        }
        sc.close();
    }
}
