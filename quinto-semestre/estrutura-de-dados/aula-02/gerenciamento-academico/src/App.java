import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        System.out.println("App Gerenciamento acadêmico");

        Student student01 = new Student("Estudante 01", "estudante01@email.com");
        Student student02 = new Student("Estudante 02", "estudante02@email.com");
        Student student03 = new Student("Estudante 03", "estudante03@email.com");

        Teacher teacher = new Teacher("Professor", "professor@ulbra.com.br");
        ArrayList<Student> students = new ArrayList<>(Arrays.asList(student01, student02));

        Class class01 = new Class("Turma de terça", teacher, students);

        class01.insertStudent(student03);
        System.out.println(class01.listStudents());
    }
}
