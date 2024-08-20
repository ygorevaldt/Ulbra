import java.util.ArrayList;
import java.util.UUID;

public class Class {
    private UUID id = new UUID(0, 4);
    private String name;
    private Teacher teacher;
    private ArrayList<Student> students;

    public Class(String name, Teacher teacher, ArrayList<Student> students) {
        this.name = name;
        this.teacher = teacher;
        this.students = students;
    }

    public void insertStudent(Student student) {
        this.students.add(student);
    }

    public ArrayList<Student> listStudents() {
        return this.students;
    }
}
