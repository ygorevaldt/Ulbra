package model;
import java.util.ArrayList;

public class UserModel {
    private ArrayList<User> users = new ArrayList<>();
    private int nextId = 1;

    public ArrayList<User> list () {
        return this.users;
    }

    public void add (User user) {
        user.setId(this.nextId);
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

    public void update (User userRecived) {
        int index = this.users.indexOf(userRecived);
        this.users.set(index, userRecived);
    }    

    public void delete (int id) {
        for (User user : this.users) {
            if (user.getId() != id) {
                continue;
            }

            this.users.remove(user);
            break;
        }
    }

    private void incrementId () {
        this.nextId++;
    }
}
