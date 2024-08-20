public class Teacher extends Person {
    public Teacher(String name, String email) {
        super(name, email);
    }

    @Override
    public void login() {
        System.out.println("Professor logado");
    }
}
