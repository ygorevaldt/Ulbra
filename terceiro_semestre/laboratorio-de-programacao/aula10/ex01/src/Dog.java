public class Dog {
    private String Name;
    private String Breed;
    private int Age;

    public Dog(String name, String breed, int age) {
        this.Name = name;
        this.Breed = breed;
        this.Age = age;
    }

    public Dog(String name, String breed) {
        this.Name = name;
        this.Breed = breed;
        this.Age = 1;
    }
}
