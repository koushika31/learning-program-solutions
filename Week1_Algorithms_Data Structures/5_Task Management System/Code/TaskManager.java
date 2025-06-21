import java.util.Scanner;
public class TaskManager {
    Task head = null;
    void addTask(Scanner sc) {
        System.out.print("Enter Task ID: ");
        int id = sc.nextInt();
        sc.nextLine();
        System.out.print("Enter Task Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Task Status: ");
        String status = sc.nextLine();

        Task newTask = new Task(id, name, status);
        if (head == null)
            head = newTask;
        else {
            Task temp = head;
            while (temp.next != null)
                temp = temp.next;
            temp.next = newTask;
        }
        System.out.println("Task added.\n");
    }
    void displayTasks() {
        if (head == null) {
            System.out.println("No tasks available.\n");
            return;
        }
        System.out.println("Tasks:");
        Task temp = head;
        while (temp != null) {
            temp.display();
            temp = temp.next;
        }
    }
    void searchTask(Scanner sc) {
        System.out.print("Enter Task ID to search: ");
        int id = sc.nextInt();
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) {
                temp.display();
                return;
            }
            temp = temp.next;
        }
        System.out.println("Task not found.\n");
    }
    void deleteTask(Scanner sc) {
        System.out.print("Enter Task ID to delete: ");
        int id = sc.nextInt();
        if (head == null) {
            System.out.println("No tasks to delete.\n");
            return;
        }
        if (head.taskId == id) {
            head = head.next;
            System.out.println("Task deleted.\n");
            return;
        }
        Task temp = head;
        while (temp.next != null && temp.next.taskId != id) {
            temp = temp.next;
        }
        if (temp.next != null) {
            temp.next = temp.next.next;
            System.out.println("Task deleted.\n");
        } else {
            System.out.println("Task not found.\n");
        }
    }
    public static void main(String[] args) {
        TaskManager tm = new TaskManager();
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("---- Task Manager ----");
            System.out.println("1. Add Task");
            System.out.println("2. View All Tasks");
            System.out.println("3. Search Task");
            System.out.println("4. Delete Task");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: tm.addTask(sc); break;
                case 2: tm.displayTasks(); break;
                case 3: tm.searchTask(sc); break;
                case 4: tm.deleteTask(sc); break;
                case 5: System.out.println("Exiting..."); break;
                default: System.out.println("Invalid choice.");
            }
        } while (choice != 5);
        sc.close();
    }
}
