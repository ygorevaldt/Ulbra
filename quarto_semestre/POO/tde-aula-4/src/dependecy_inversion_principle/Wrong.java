package dependecy_inversion_principle;

public class Wrong {
}

public class UserService {
    public void list () {
        return sgbd.query(sql);
    }
    public void create () {
        return sgbd.query(sql);
    }
    public void get () {
        return sgbd.query(sql);
    }
    public void update () {
        return sgbd.query(sql);
    }
    public void delete () {
        return sgbd.query(sql);
    }
}

public class UserRoute {
    UserService userService = new UserService();
    public void list () {
        return this.userService.list(params);
    }
    public void create () {
        return this.userService.create(params);
    }
    public void get () {
        return this.userService.get(params);
    }
    public void update () {
        return this.userService.update(params);
    }
    public void delete () {
        return this.userService.delete(params);
    }
}

class 