public class Employee {
    int employeeId;
    String name;
    String position;
    double salary;
    Employee(int id, String name, String pos, double sal) {
        employeeId = id;
        this.name = name;
        position = pos;
        salary = sal;
    }
    void display() {
        System.out.println("ID: " + employeeId + ", Name: " + name + ", Position: " + position + ", Salary: " + salary);
    }
}
