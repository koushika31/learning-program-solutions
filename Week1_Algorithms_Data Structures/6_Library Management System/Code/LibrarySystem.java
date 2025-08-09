import java.util.Arrays;
import java.util.Scanner;

public class LibrarySystem {

    static void linearSearch(Book[] books, String key) {
        boolean found = false;
        for (Book b : books) {
            if (b.title.equalsIgnoreCase(key)) {
                System.out.println("Found (Linear Search):");
                b.display();
                found = true;
                break;
            }
        }
        if (!found) System.out.println("Book not found (Linear Search).");
    }
    static int binarySearch(Book[] books, String key) {
        int left = 0, right = books.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            int cmp = books[mid].title.compareToIgnoreCase(key);
            if (cmp == 0) return mid;
            else if (cmp < 0) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    static void sortBooks(Book[] books) {
        Arrays.sort(books, (a, b) -> a.title.compareToIgnoreCase(b.title));
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Book[] books = {
            new Book(1, "Java Basics", "James Gosling"),
            new Book(2, "Python Guide", "Guido van Rossum"),
            new Book(3, "Data Structures", "Mark Allen"),
            new Book(4, "Operating Systems", "Andrew Tanenbaum"),
            new Book(5, "Networking Essentials", "William Stallings")
        };
        System.out.print("Enter book title to search: ");
        String inputTitle = sc.nextLine();
        // Linear Search
        linearSearch(books, inputTitle);
        // Binary Search
        sortBooks(books);
        int index = binarySearch(books, inputTitle);
        if (index != -1) {
            System.out.println("Found (Binary Search):");
            books[index].display();
        } else {
            System.out.println("Book not found (Binary Search).");
        }
        sc.close();
    }
}
