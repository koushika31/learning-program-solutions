public class Task {
    int taskId;
    String taskName;
    String status;
    Task next; 
    Task(int id, String name, String stat) {
        taskId = id;
        taskName = name;
        status = stat;
        next = null;
    }
    void display() {
        System.out.println("ID: " + taskId + ", Name: " + taskName + ", Status: " + status);
    }
}
