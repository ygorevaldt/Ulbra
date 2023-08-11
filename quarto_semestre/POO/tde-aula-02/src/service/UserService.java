package service;

import java.util.ArrayList;
import repository.UserRepository;
import model.User;

public class UserService {
    private UserRepository repository = new UserRepository();

    public ArrayList<User> list () {
        return repository.list();
    }

    public void add (User user) {
        repository.add(user);
    }

    public void update (User userUpdated) {
        repository.update(userUpdated.getId(), userUpdated);
    }

    public User get (int id) {
        return repository.get(id);
    }

    public void delete (int id) {
        repository.delete(id);
    }
}
