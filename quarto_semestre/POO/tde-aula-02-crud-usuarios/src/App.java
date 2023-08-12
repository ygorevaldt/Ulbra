import model.User;
import controller.UserController;

public class App {
    public static void main(String[] args) throws Exception {
        UserController userController = new UserController();

        userController.add(new User("Alessandra"));
        userController.add(new User("Ygor"));
        userController.add(new User("Daniel"));
        System.out.println(userController.list());

        User user = userController.get(1);

        user.setName("Lelê Silveira");
        userController.update(user);
        System.out.println(userController.list());

        userController.delete(3);
        System.out.println(userController.list());
    }
}
