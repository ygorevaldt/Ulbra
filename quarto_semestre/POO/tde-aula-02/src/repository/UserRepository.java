package repository;
import model.User;
import java.util.ArrayList;

public class UserRepository {
    private ArrayList<User> users = new ArrayList<>();
    private int nextId = 0;

    public ArrayList<User> list () {
        return this.users;
    }

    public void add (User user) {
        user.setId(nextId);
        this.users.add(user);
        this.incrementId();
    }

    public User get (int id) {
        for (User user : this.users) {
            if (user.getId() != id) {
                continue;
            }
            return user;
        } 

        return null;
    }

    public void update (int id, User userUpdated) {
        for (User user : this.users) {
            if (user.getId() != id) {
                continue;
            }
            this.users.set(id, userUpdated);
        }
    }

    public void delete (int id) {
        for (User user : this.users) {
            if (user.getId() != id) {
                continue;
            }
            this.users.remove(id);
        }
    }

    private void incrementId () {
        this.nextId++;
    }

    
}
