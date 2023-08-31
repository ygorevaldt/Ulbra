package liskov_substitution_principle;

// Errado
public class Bird {
    public void peck () {
        System.out.println("Bicando");
    }
    public void fly () {
        System.out.println("Voando");
    }
}

public class Duck extends Bird {
    @Override
    public void peck () {
        System.out.println("Pato Bicando");
    }

    @Override
    public void fly () {
        System.out.println("Pato Voando");
    }
}

public class Penguin extends Bird {
    @Override
    public void peck () {
        System.out.println("Pinguim Bicando");
    }

    @Override
    public void fly () {
        throw new UnsupportedOperationException("Pinguim não voa");
    }
}

// Correto
public class Bird {
    public void peck () {
        System.out.println("Bicando");
    }
}

public interface Flying {
    void fly();
}

public class Duck extends Bird implements Flying {
    @Override
    public void peck () {
        System.out.println("Pato Bicando");
    }

    @Override
    public void fly () {
        System.out.println("Pato voando");
    }
}

public class Penguin extends Bird {
    @Override
    public void peck () {
        System.out.println("Pinguim Bicando");
    }

}

