/*
    5. Escreva um programa em Java que solicita um número
    inteiro positivo e imprime todos os números ímpares
    entre 1 e esse número. Utilize um loop for para realizar a
    impressão.
*/
public class Exercice05 {
    public void printOddNumbers(int number){
        int initNumber = 1;
        int finishNumber = number;

        for (initNumber = 1; initNumber <= finishNumber; initNumber++) {
            boolean condition = initNumber % 2 != 0;
            if (condition) {
                System.out.println(initNumber);
            }
        }
    }
}
