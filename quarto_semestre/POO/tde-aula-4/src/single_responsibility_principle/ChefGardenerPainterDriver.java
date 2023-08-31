package single_responsibility_principle;

// ERRADO
public class ChefGardenerPainterDriver {
    public void cook () {
        System.out.println("Cozinhando");
    }
    public void cutGrass () {
        System.out.println("Cortando grama");
    }
    public void paint () {
        System.out.println("Pintando");
    }
    public void Drive () {
        System.out.println("Dirigindo");
    }
}

// CORRETO
public class Person {
    private String name;

    public void hello () {
        System.out.println("Olá, meu nome é: " + this.name);
    }
}

public class Chef extends Person {
    public void cook () {
        System.out.println("Cozinhando");
    }
}
