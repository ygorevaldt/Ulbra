/*
4. Escreva um programa em Java que solicita um número
inteiro positivo e imprime todos os números pares entre 1
e esse número. Utilize um loop while para realizar a
impressão.
*/

public class Exercice04 {
    public void printEvenNumbers(int number){
        int initNumber = 1;
        int finishNumber = number;

        while(initNumber <= finishNumber) {
            boolean condition = initNumber % 2 == 0;
            if (condition) {
                System.out.println(initNumber);
            }
            initNumber++;
        }
    }
}
