public abstract class Animal {
    public abstract void makeSound();

    public abstract void move();
}

class Dog extends Animal {

    public void makeSound() {
        System.out.println("Wolf");
    }

    public void move() {
        System.out.println("Cachorro Andando");
    }
}

class Fish extends Animal {
    public void makeSound() {
        System.out.println("Blub");
    }
    public void move() {
        System.out.println("Nadando como um peixe");
    }
}

class Cat extends Animal {
    public void makeSound() {
        System.out.println("Miau");
    }
    public void move() {
        System.out.println("Gato Andando");
    }
}