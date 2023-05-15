public abstract class Person {
    String Name;
    int Age;
    String Address;

    public abstract void speak(String text);

    public abstract void walk();

    public String getName() {
        return this.Name;
    }

    public int getAge() {
        return this.Age;
    }

    public String getAddress() {
        return this.Address;
    }

}

class Employee extends Person {
    String Office;

    public Employee(String name, int age) {
        this.Name = name;
        this.Age = age;
    }

    public Employee(String name, int age, String office) {
        this.Name = name;
        this.Age = age;
        this.Office = office;
    }

    public void speak(String text) {
        System.out.println(text);
    };

    public void walk() {
        System.out.println("Funcionário caminhando");
    }
}

class Student extends Person {
    public void speak(String text) {
        System.out.println(text);
    };

    public void walk() {
        System.out.println("Estudante caminhando");
    }

    public void study() {
        System.out.println("Estudante estudando");
    }
}

class Client extends Person {
    int NumCard;

    public Client(String name, String address, int numCard) {
        this.Name = name;
        this.Address = address;
        this.NumCard = numCard;
    }

    public void speak(String text) {
        System.out.println(text);
    };

    public void walk() {
        System.out.println("Cliente caminhando");
    }

}