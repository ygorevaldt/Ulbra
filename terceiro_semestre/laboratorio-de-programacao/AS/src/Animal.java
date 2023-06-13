public class Animal {
    private String Name;
    private int Age;
    private double Weight;
    private String Species;

    public Animal(String name, int age, double weight, String species) {
        this.Name = name;
        this.Age = age;
        this.Weight = weight;
        this.Species = species;
    }

    public String getName() {
        return this.Name;
    }

    public int getAge() {
        return this.getAge();
    }

    public double getWeight() {
        return this.Weight;
    }

    public String getSpecies() {
        return this.Species;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public void setAge(int age) {
        this.Age = age;
    }

    public void setWeight(double weight) {
        this.Weight = weight;
    }

    public void setSpecies(String species) {
        this.Species = species;
    }

    public void move() {
        System.out.println(this.getName() + " se moveu de uma maneira padrão.");
    }

    public void move(String movement) {
        System.out.println(this.getName() + " se moveu " + movement);
    }
}

class Mammal extends Animal {
    private String TypeCoat;

    public Mammal(String name, int age, double weight, String species, String typeCoat) {
        super(name, age, weight, species);
        this.TypeCoat = typeCoat;
    }

    public String getTypeCoat() {
        return this.TypeCoat;
    }

    public void setTypeCoat(String typeCoat) {
        this.TypeCoat = typeCoat;
    }

    public void breastFeed() {
        System.out.println(this.getName() + " está amamentando.");
    }

}

class Bird extends Animal implements Trainable {
    private double WingSpan;
    public Bird(String name, int age, double weight, String species, double wingSpan) {
        super(name, age, weight, species);
        this.WingSpan = wingSpan;
    }

    public double getWingSpan() {
        return this.WingSpan;
    }

    public void setWingSpan(double wingSpan) {
        this.WingSpan = wingSpan;
    }

    public void performTrick() {
        System.out.println(this.getName() + " realizou um truque voador.");
    }

    public void fly() {
        System.out.println(this.getName() + " está voando.");
    }
}
