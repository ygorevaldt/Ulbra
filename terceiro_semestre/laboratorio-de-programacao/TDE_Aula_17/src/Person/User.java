package Person;

import Persistent.Persistent;

public class User implements Persistent {
    private String Name;
    public User(String name) {
        this.Name = name;
    }
    @Override
    public void save() {
        System.out.println("Salvar");
    }

    @Override
    public void delete() {
        System.out.println("Deletar");
    }

    @Override
    public void update() {
        System.out.println("Atualizar");
    }

    @Override
    public void search() {
        System.out.println("Buscar");
    }
}
