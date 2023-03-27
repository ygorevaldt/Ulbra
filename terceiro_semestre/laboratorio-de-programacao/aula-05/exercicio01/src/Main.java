public class Main {
    public static void main(String[] args) {
        Pessoa person = new Pessoa("Alessandra", 20, 1.74);
        person.setName("Ygor");
        person.setAge(26);
        person.setHeigth(1.78);

        printPropertiesClassPerson(person);


        Carro car = new Carro("Volklswagen", "Fox", 2013 );
        car.setBrand("Chevrolet");
        car.setModel("Onix");
        car.setYear(2022);

        printPropertiesClassCar(car);

        ContaBancaria bankAccount = new ContaBancaria("1234-15", 10000.00, person);
        bankAccount.deposit(1000);
        bankAccount.withdraw(500);
        bankAccount.deposit(0);
        bankAccount.withdraw(11000);

        printBankAccountBalance(bankAccount);
    }

    public static void printPropertiesClassPerson(Pessoa person) {
        System.out.println("Exercicio 01 - class Pessoa");
        System.out.println(person.getName());
        System.out.println(person.getAge());
        System.out.println(person.getHeigth());
    }

    public static void printPropertiesClassCar(Carro car) {
        System.out.println("Exercicio 02 - class Carro");
        System.out.println(car.getBrand());
        System.out.println(car.getModel());
        System.out.println(car.getYear());
    }

    public static void printBankAccountBalance(ContaBancaria bankAccount) {
        System.out.println(bankAccount.getBalance());
    }
}