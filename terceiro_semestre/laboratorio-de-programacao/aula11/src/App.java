public class App {
    public static void main(String[] args) throws Exception {
        Square square = new Square(10);
        square.showResults();

        Car car1 = new Car("volkswagen", "fox");
        Car car2 = new Car("volkswagen", "fox", 5);

        CurrentAccount currentAccount = new CurrentAccount(1000, "123", 5000);

        Dog dog = new Dog();
        dog.makeSound();
        dog.move();

        Cat cat = new Cat();
        cat.makeSound();
        cat.move();

        Fish fish = new Fish();
        fish.makeSound();
        fish.move();

        Student student = new Student();
        student.study();

        Employee employee1 = new Employee("Lucas", 28);
        Employee employee2 = new Employee("Lucas", 28, "professor");

        Client client = new Client("Lucas", "Torres RS", 11223344);
        client.speak("Olá");
        client.walk();

        PerishableProduct perishableProduct = new PerishableProduct(10, 19.90, "2023-12-16");
        perishableProduct.showDetails();
    }
}
