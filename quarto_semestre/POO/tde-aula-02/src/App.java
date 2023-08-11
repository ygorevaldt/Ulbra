import service.UserService;
import model.User;

public class App {
    public static void main(String[] args) throws Exception {
        showWelcomeMessage();

        UserService userService = new UserService();
        userService.add(new User("Daniel"));
        userService.add(new User("Ygor"));
        userService.add(new User("Alessandra"));

        System.out.println(userService.list());
    }

    public static void showWelcomeMessage() {
        System.out.println("CRUD de Usuários");
    }
}
