/*
1. Faça um programa em Java que solicita um número
inteiro positivo e calcule a soma dos números naturais
até esse número. Utilize um loop while para realizar o
cálculo.
*/

class Exercice01 {
    public int calculateNaturalNumbers(int finishNumber) {
        int sum = 0;
        int number = 0;

        while(sum < finishNumber) {
            number++;
            sum += number;
        }

        return sum;
    }
}
