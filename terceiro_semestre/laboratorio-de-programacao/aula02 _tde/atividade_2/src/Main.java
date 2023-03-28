/*
Neste exercício, você deve completar 4 tarefas:
1. Imprima todos os números inteiros de 10 a 25 utilizando uma estrutura de repetição.
2. Imprima a soma dos números de 1 a 100, pulando de dois em dois (1, 3, 5, 7, etc.).
3. Começando em 0, imprima os números seguintes, enquanto a soma dos números já
impressos for menor que 100.
4. Imprima a tabuada do 9 (até o décimo valor).
*/

public class Main {
    public static void main(String[] args) {
        printNumbersInRange(10, 25);
        printNumbersInTwos(1, 100);
        multiplicationTable(9);
        addUpTo100();
    }

    //tarefa 1
    public static void printNumbersInRange(int init, int finish) {
        for (int i = init; i <= finish; i++) {
            System.out.println(i);
        }
    }

    //tarefa 2
    public static void printNumbersInTwos(int init, int finish) {
        while(init <= finish) {
            System.out.println(init);
            init += 2;
        }
    }

    //tarefa 3
    public static void addUpTo100() {
        int number = 0;
        int sum = 0;

        while (sum < 100) {
            System.out.println(number);
            number++;
            sum += number;
        }
    }

    //tarefa 4
    public static void multiplicationTable(int number) {
        int result;
        for (int i = 0; i <= 10; i++) {
            result = i * number;
            System.out.println(number + " x " + i + " = " + result);
        }
    }
}