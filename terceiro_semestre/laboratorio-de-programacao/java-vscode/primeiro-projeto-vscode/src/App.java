public class App {
    public static void main(String[] args) throws Exception {
        User user = new User("Alessandra");
        user.setAge(20);

        System.out.println(user.getName());
        System.out.println(user.getAge());
    }
}
