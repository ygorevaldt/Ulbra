/*
Imprima os 15 primeiros números da série de Fibonacci. A série de Fibonacci é tem os
seguintes elementos: 0, 1, 1, 2, 3, 5, 8, 13, 21, etc. Para calculá-la, o primeiro e segundo
elementos valem 1, e daí por diante, o n-ésimo elemento vale o (n-1)-ésimo elemento somado
ao (n-2)-ésimo elemento (ex: 8 = 5 + 3).
 */

public class Main {
    public static void main(String[] args) {
        fibonacciSequence(15);
    }
    public static void fibonacciSequence(int finish){
        int previousNumber = 0;
        int currentNumber = 1;
        int nextNumber;

        System.out.println(previousNumber);
        System.out.println(currentNumber);

        for(int i = 2; i < finish; i++) {
            nextNumber = previousNumber + currentNumber;
            System.out.println(nextNumber);
            previousNumber = currentNumber;
            currentNumber = nextNumber;
        }
    }
}