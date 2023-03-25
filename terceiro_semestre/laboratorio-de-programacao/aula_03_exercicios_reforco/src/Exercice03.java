/*
3. Escreva um programa em Java que solicita um número
inteiro positivo e imprime a tabuada desse número até o
número 10. Utilize um loop for para realizar a impressão.
*/

public class Exercice03 {
    public void printMultiplicationTable(int number) {
        int stopFor = 10;
        int result;
        for (int i = 0; i <= stopFor; i++) {
            result = number * i;
            System.out.println(number + " x " + i  + " = " + result);
        }
    }
}


