import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        //Exercício 1: Inicialização de um Array
        System.out.println("Exercicio 1");
        int[] numbers = { 1, 2, 3, 4, 5 };
        showArrayElements(numbers);
        breackLine();

        //Exercício 2: Cálculo da Média
        System.out.println("Exercício 2");
        double[] notes = { 8.5, 7.0, 9.0, 6.5, 10.0 };
        System.out.println(calculateAvarege(notes));
        breackLine();

        //Exercício 3: Encontre o Maior Número
        System.out.println("Exercício 3");
        int[] values = { 23, 1, 34, 89, 2 };
        System.out.println(findBiggestNumber(values));
        breackLine();

        //Exercício 4: Invertendo um Array
        System.out.println("Exercício 4");
        String[] colors = { "vermelho", "azul", "verde", "amarelo", "roxo" };
        reverseArray(colors);
        System.out.println(Arrays.toString(colors));
        breackLine();

        //Exercício 5: Crie um Array de Números Ímpares
        System.out.println("Exercício 5");
        int[] oddNumbers = getArrayOfOddNumbers(10);
        System.out.println(Arrays.toString(oddNumbers));

    }

    public static int[] getArrayOfOddNumbers(int length) {
        int[] array = new int[length];
        int number = 1;
        int index = 0;

        while (number <= length * 2) {
            if (numberIsOdd(number)) {
                array[index] = number;
                index++;
            }
            number++;
        }

        return array;
    }

    public static boolean numberIsOdd(int number) {
        boolean odd = number % 2 != 0;
        if (odd) {
            return true;
        }
        return false;
    }

    public static double calculateAvarege(double[] notes) {
        int index = 0;
        double sum = 0;
        int amountOfNotes = notes.length;

        while (index < amountOfNotes) {
            sum += notes[index];
            index++;
        }

        double result = sum / amountOfNotes;
        return result;
    }

    public static int findBiggestNumber(int[] values) {
        int i = 0;
        int biggestNumber = values[0];
        while(i < values.length) {
            int currentNumber = values[i];
            biggestNumber = getBiggestNumber(biggestNumber, currentNumber);
            i++;
        }

        return biggestNumber;
    }

    public static int getBiggestNumber(int number1, int number2) {
        if (number1 > number2) {
            return number1;
        }
        return number2;
    }

    public static void showArrayElements(int [] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public static <T> void reverseArray(T[] array) {
        Collections.reverse(Arrays.asList(array));
    }

    public static void breackLine() {
        System.out.println("\n");
    }
}