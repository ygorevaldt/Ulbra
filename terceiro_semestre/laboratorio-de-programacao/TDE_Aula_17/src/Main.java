import Charge.Batery;
import Flying.Airplane;
import Flying.Bird;
import Flying.Superman;
import GeometricForm.Circle;
import GeometricForm.Rectangle;
import GeometricForm.Triangle;
import Payable.Check;
import Payable.Deposit;
import Payable.Invoice;
import Person.Athlete;
import Printables.Document;
import Printables.Photo;
import Animal.Cat;
import Animal.Dog;
import Animal.Elephant;
import Musical.Baterry;
import Musical.Guitar;
import Musical.Piano;
import Person.User;

public class Main {
    public static void main(String[] args) {
        // Exercise 1
        showExerciseNumber(1);
        Document someDocument = new Document();
        someDocument.print();
        breakLine();

        // Exercise 2
        showExerciseNumber(2);
        Photo somePhoto = new Photo();
        somePhoto.print();
        breakLine();

        // Exercise 3
        showExerciseNumber(3);
        Airplane someAirplane = new Airplane();
        someAirplane.takeOf();
        someAirplane.fly();
        someAirplane.land();

        Bird someBird = new Bird();
        someBird.takeOf();
        someBird.fly();
        someBird.land();

        Superman clark = new Superman();
        clark.takeOf();
        clark.fly();
        clark.land();
        breakLine();

        // Exercise 4
        showExerciseNumber(4);
        Batery someBatery = new Batery();
        someBatery.charge();
        breakLine();

        // Exercise 5
        showExerciseNumber(5);

        Circle someCircle = new Circle(15.2);
        someCircle.showResults("Circulo");

        Rectangle someRectangle = new Rectangle(12.4, 10);
        someRectangle.showResults("Retângulo");

        Triangle someTriangle = new Triangle(10, 4.5, 6.5, 10, 6.5);
        someTriangle.showResults("Triângulo");

        breakLine();

        // Exercise 6
        showExerciseNumber(6);

        Cat someCat = new Cat();
        someCat.eat();
        someCat.sleep();

        Dog someDog = new Dog();
        someDog.eat();
        someDog.sleep();

        Elephant someElephant = new Elephant();
        someElephant.eat();
        someElephant.sleep();

        breakLine();

        // Exercise 7
        showExerciseNumber(7);

        Baterry someBaterry = new Baterry();
        someBaterry.play();
        someBaterry.pause();
        someBaterry.stop();

        Guitar someGuitar = new Guitar();
        someGuitar.play();
        someGuitar.pause();
        someGuitar.stop();

        Piano somePiano = new Piano();
        somePiano.play();
        somePiano.pause();
        somePiano.stop();

        breakLine();

        // Exercise 8
        showExerciseNumber(8);

        Check someCheck = new Check();
        someCheck.pay();
        someCheck.checkPayment();

        Deposit someDeposit = new Deposit();
        someDeposit.pay();
        someDeposit.checkPayment();

        Invoice someInvoice = new Invoice();
        someInvoice.pay();
        someInvoice.checkPayment();

        breakLine();

        // Exercise 9
        showExerciseNumber(9);
        Athlete someAthlete = new Athlete();
        someAthlete.walk();
        someAthlete.run();
        breakLine();

        // Exercise 10
        showExerciseNumber(10);
        User someUser = new User("adm.user");
        someUser.save();
        someUser.update();
        someUser.search();
        someUser.delete();
        breakLine();
    }

    public static void showExerciseNumber(int number) {
        System.out.println("** Exercício " + number + " **");
    }
    public static void breakLine() {
        System.out.println("\n");
    }
}