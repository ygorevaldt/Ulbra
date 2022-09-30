/* Efetue um programa que mostre todos os números inteiros ímpares situados numa  faixa de dois números digitados pelo usuário. Esse algoritmo deve ser feito duas vezes uma usando o WHILE e DO-WHILE */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numero1, numero2, aux;
  printf("digite um número: ");
  scanf("%d%*c", &numero1);
  printf("digite outro número: ");
  scanf("%d%*c", &numero2);

  aux = abs(numero1 - numero2);

  /* FOR */
  printf("\nLAÇO DO-WHILE\n");
  int i = 0;
  do {
    if (i % 2 == 1){
      printf("%d\n", i);
    }
    i++;
  }
  while (i <= aux);

  printf("\nLAÇO WHILE\n");
  i = 0;
  while(i <= aux) {
    if (i % 2 == 1){
      printf("%d\n", i);
    }
    i++;
  }
  printf("\n");
  return 0;
}