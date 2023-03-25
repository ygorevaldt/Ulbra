import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        int number;

        //exercicio 01
        Exercice01 exercice01 = new Exercice01();
        System.out.println(exercice01.calculateNaturalNumbers(4));

        //exercicio 02
        Exercice02 exercice02 = new Exercice02();
        System.out.println(exercice02.infoTypeNumber(3));

        //exercicio 03
        number = getNumber("Informe um número inteiro positivo para visualizar sua tabuada: ");
        Exercice03 exercice03 = new Exercice03();
        exercice03.printMultiplicationTable(number);

        //exercice 04
        number = getNumber("Informe um número inteiro positivo para visualizar os números pares de 1 até o número informado: ");
        Exercice04 exercice04 = new Exercice04();
        exercice04.printEvenNumbers(number);

        //exercice 05
        number = getNumber("Informe um número inteiro positivo para visualizar os números ímpares de 1 até o número informado: ");
        Exercice05 exercice05 = new Exercice05();
        exercice05.printOddNumbers(number);

    }

    public static int getNumber(String message) {
        Scanner myNumber = new Scanner(System.in);
        System.out.println(message);

        int number = myNumber.nextInt();
        return number;
    }
}
