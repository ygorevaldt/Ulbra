/* Faça um programa que leia um número N, e realize a soma dos números de 1 a N. Ao final, deve-se escrever o resultado. Esse algoritmo deve ser feito duas vezes uma usando o While e Do-While
 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numero, i = 1, soma = 0;
  printf("Digite um número: ");
  scanf("%d%*c", &numero);
  
  printf("\n=-=-= LAÇO WHILE =-=-=\n");
  while(i < numero) {
    i++;
    if (i == 10){
      break;
    }
    soma += i;
  }
  printf("A soma dos números entre 1 e o número digitado é: \n%d\n", soma);
 
  printf("\n=-=-= LAÇO DO-WHILE =-=-=\n");
  i = 2, soma = 0;
  do {
    soma += i;
    i++;
  } while(i < numero);
  printf("A soma dos números entre 1 e o número digitado é: \n%d\n", soma);

  return 0;
}