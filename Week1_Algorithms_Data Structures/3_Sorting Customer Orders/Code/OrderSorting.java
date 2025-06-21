import java.util.Scanner;
public class OrderSorting {
    static void bubbleSort(Order[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j].totalPrice > arr[j + 1].totalPrice) {
                    Order temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    static void quickSort(Order[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            quickSort(arr, low, p - 1);
            quickSort(arr, p + 1, high);
        }
    }
    static int partition(Order[] arr, int low, int high) {
        double pivot = arr[high].totalPrice;
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j].totalPrice < pivot) {
                i++;
                Order temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Order temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
    static void display(Order[] arr) {
        for (Order o : arr) o.display();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine();

        Order[] orders = new Order[n];
        for (int i = 0; i < n; i++) {
            System.out.println("\nOrder " + (i + 1));
            System.out.print("ID: ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Customer: ");
            String name = sc.nextLine();
            System.out.print("Total Price: ");
            double price = sc.nextDouble();
            sc.nextLine();
            orders[i] = new Order(id, name, price);
        }

        Order[] bubbleArr = orders.clone();
        Order[] quickArr = orders.clone();

        bubbleSort(bubbleArr);
        System.out.println("\n🧾 Orders by Bubble Sort:");
        display(bubbleArr);

        quickSort(quickArr, 0, quickArr.length - 1);
        System.out.println("\n🧾 Orders by Quick Sort:");
        display(quickArr);
        
        sc.close();
    }
}
