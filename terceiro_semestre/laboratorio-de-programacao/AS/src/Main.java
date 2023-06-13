public class Main {
    public static void main(String[] args) {

        Animal someAnimal = new Animal("Lagarto", 2, 5.2, "Papo amarelo");
        Mammal cat = new Mammal("Sayuri", 4, 5.8,"Gato", "curto");
        Bird falcao = new Bird("Falcão", 3, 3.8, "Falcão montanhes", 3.1);

        Employee someEmployee = new Employee("John Snow", "Guarda da noite", 0);
        Veterinarian someVeterinarian = new Veterinarian("Sr. Dolittle", "Veterinário", 5000, "Entender animais");

        Zoo someZoo = new Zoo(3, 2);
        someZoo.setAnimals(new Animal[] {someAnimal, cat, falcao});
        someZoo.setEmployees(new Employee[] {someEmployee, someVeterinarian});

        someAnimal.move();
        someAnimal.move("rastejando");

        cat.breastFeed();
        falcao.fly();
        falcao.performTrick();

        someVeterinarian.takeExam(cat);

    }
}