public class Student extends Person {
    public Student(String name, String email) {
        super(name, email);
    }

    @Override
    public void login() {
        System.out.println("Aluno logado");
    }

    @Override
    public String toString() {
        return String.format("Student{name: %s, email: %s}", this.name, this.email);
    }
}
