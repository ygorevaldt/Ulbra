public class Animal {
    public String makeSound(String sound) {
        return sound;
    }

    public void move() {
        System.out.println("");
    }
}

class Dog extends Animal {
    public void bark() {
        String sound = this.makeSound("Wolf");
        System.out.println(sound);
    }
}

class Fish extends Animal {
    public void move() {
        System.out.println("Nadando como um peixe");
    }
}

class Cat extends Animal {
    public void move() {
        System.out.println("Miau");
    }
}