class Student {
    private String name;
    private String id;
    private String grade;

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getGrade() { return grade; }
    public void setGrade(String grade) { this.grade = grade; }
}
class StudentView {
    public void displayStudentDetails(String name, String id, String grade) {
        System.out.println("Student Details:");
        System.out.println("Name  : " + name);
        System.out.println("ID    : " + id);
        System.out.println("Grade : " + grade);
    }
}
class StudentController {
    private Student model;
    private StudentView view;

    public StudentController(Student model, StudentView view) {
        this.model = model;
        this.view = view;
    }
    public void setStudentName(String name) {
        model.setName(name);
    }
    public void setStudentId(String id) {
        model.setId(id);
    }
    public void setStudentGrade(String grade) {
        model.setGrade(grade);
    }
    public void updateView() {
        view.displayStudentDetails(model.getName(), model.getId(), model.getGrade());
    }
}
public class MVCPatternExample {
    public static void main(String[] args) {
        Student model = new Student();
        model.setName("Koushika");
        model.setId("IT046");
        model.setGrade("O");

        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
        controller.setStudentName("Koushi");
        controller.setStudentGrade("A+");
        controller.updateView();
    }
}
