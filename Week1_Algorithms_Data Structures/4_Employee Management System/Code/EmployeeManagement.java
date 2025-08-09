import java.util.Scanner;
public class EmployeeManagement {
    static Employee[] empList = new Employee[100]; 
    static int count = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- Employee Menu ---");
            System.out.println("1. Add");
            System.out.println("2. Display All");
            System.out.println("3. Search by ID");
            System.out.println("4. Delete by ID");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); 
            if (choice == 1) {
                System.out.print("Enter ID: ");
                int id = sc.nextInt();
                sc.nextLine();
                System.out.print("Enter Name: ");
                String name = sc.nextLine();
                System.out.print("Enter Position: ");
                String pos = sc.nextLine();
                System.out.print("Enter Salary: ");
                double sal = sc.nextDouble();
                empList[count++] = new Employee(id, name, pos, sal);
                System.out.println("Employee added.");
            }
            else if (choice == 2) {
                if (count == 0) System.out.println("No employees.");
                for (int i = 0; i < count; i++) {
                    empList[i].display();
                }
            }
            else if (choice == 3) {
                System.out.print("Enter ID to search: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (empList[i].employeeId == id) {
                        empList[i].display();
                        found = true;
                        break;
                    }
                }
                if (!found) System.out.println("Employee not found.");
            }
            else if (choice == 4) {
                System.out.print("Enter ID to delete: ");
                int id = sc.nextInt();
                boolean found = false;
                for (int i = 0; i < count; i++) {
                    if (empList[i].employeeId == id) {
                        for (int j = i; j < count - 1; j++) {
                            empList[j] = empList[j + 1];
                        }
                        count--;
                        found = true;
                        System.out.println("Employee deleted.");
                        break;
                    }
                }
                if (!found) System.out.println("Employee not found.");
            }
            else if (choice != 5) {
                System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
        System.out.println("Program ended.");
    }
}
