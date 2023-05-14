public class Person {
    String Name;
    int Age;
    String address;

    public String speak(String text) {
        return text;
    }

    public void walk() {
        System.out.println("Andando..");
    }

}

class Employee extends Person {
    String office;
}

class Student extends Person {
    public void study() {
        System.out.println("Estudando...");
    }
}

class Client extends Person {
    int NumCard;
}