/* Efetue um programa que mostre todos os números inteiros ímpares situados na faixa de 1000 a 1500. Esse algoritmo deve ser feito duas vezes uma usando o FOR,WHILE; */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  /* FOR */
  printf("\n--- LAÇO FOR ---\n");
  int i;
  for (i = 1000; i < 1500; i++) {
    if (i % 2 == 1) {
      printf("%d\n", i);
    }
  }
  /* WHILE */
  printf("\n--- LAÇO WHILE ---\n");
  int aux = 1000;
  while(aux <= 1500) {
    if (aux % 2 == 1) {
      printf("%d\n", aux);
    }
    aux++;
  }
  printf("\n");
  return 0;
}