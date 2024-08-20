// Exercicio 1

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
System.out.println("Calculadora simples");

Scanner read = new Scanner(System.in);

System.out.println("Escolha a operação:");
System.out.println("1 - Adição");
System.out.println("2 - Subtração");
System.out.println("3 - Divisão");
System.out.println("4 - Multiplicação");
int operation = read.nextInt();

System.out.println("Digite o primeiro número:");
double number1 = read.nextDouble();

System.out.println("Digite o segundo número:");
double number2 = read.nextDouble();

double result;

switch (operation) {
case 1:
result = number1 + number2;
System.out.println(String.format("O resultado de %.2f + %.2f é igual a: %.2f", number1, number2, result));
break;

case 2:
result = number1 - number2;
System.out.println(String.format("O resultado de %.2f - %.2f é igual a: %.2f", number1, number2, result));
break;

case 3:
result = number1 / number2;
System.out.println(String.format("O resultado de %.2f / %.2f é igual a: %.2f", number1, number2, result));
break;

case 4:
result = number1 * number2;
System.out.println(String.format("O resultado de %.2f * %.2f é igual a: %.2f", number1, number2, result));
break;
}

}
}




// Exercicio 2

import java.util.Scanner;

public class Main {
public static void main(String[] args) {
System.out.println("Calculadora simples");

Scanner read = new Scanner(System.in);

int countAddition = 0;
int countSubtraction = 0;
int countDivision = 0;
int countMultiplication = 0;
int totalOperations = 0;

int choice;

do {
System.out.println("Escolha a operação:");
System.out.println("1 - Adição");
System.out.println("2 - Subtração");
System.out.println("3 - Divisão");
System.out.println("4 - Multiplicação");
int operation = read.nextInt();

System.out.println("Digite o primeiro número:");
double number1 = read.nextDouble();

System.out.println("Digite o segundo número:");
double number2 = read.nextDouble();

double result;

switch (operation) {
case 1:
countAddition++;
result = number1 + number2;
System.out.println(String.format("O resultado de %.2f+%.2f é igual a: %.2f", number1, number2, result));
break;

case 2:
countSubtraction++;
result = number1 - number2;
System.out.println(String.format("O resultado de %.2f-%.2f é igual a: %.2f", number1, number2, result));
break;

case 3:
countDivision++;
result = number1 / number2;
System.out.println(String.format("O resultado de %.2f/%.2f é igual a: %.2f", number1, number2, result));
break;

case 4:
countMultiplication++;
result = number1 * number2;
System.out.println(String.format("O resultado de %.2f*%.2f é igual a: %.2f", number1, number2, result));
break;

default:
System.out.println("Operação inválida");
break;
}

System.out.println("");
System.out.println("1 - Realizar nova operação");
System.out.println("2 - Encerrar programa");
choice = read.nextInt();

} while(choice != 2);

System.out.println("Histórico de operações:");
System.out.println(String.format("Adição: %d", countAddition));
System.out.println(String.format("Subtração: %d", countSubtraction));
System.out.println(String.format("Divisão: %d", countDivision));
System.out.println(String.format("Multiplicação: %d", countMultiplication));

totalOperations = countAddition + countSubtraction + countDivision + countMultiplication;
System.out.println(String.format("Total de operações: %d", totalOperations));
}
}