/*
2. Escreva um programa em Java que recebe um número
inteiro positivo e imprime se ele é um número primo ou
não. Utilize um loop for para testar se o número é primo.
*/
public class Exercice02 {
    public String infoTypeNumber(int number) {

        int divisions = 0;
        for (int count = 1; count <= number; count++) {
            if (number % count == 0) {
                divisions++;
            }
        }
        if (divisions == 2) {
            return "É um número Primo";
        }

        return "Não é um número primo";
    }
}


