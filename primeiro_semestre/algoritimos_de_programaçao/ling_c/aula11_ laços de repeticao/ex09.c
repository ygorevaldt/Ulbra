/* Elabore um programa que escreva a tabuada de um número qualquer. */ 

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numero;
  printf("Digite um número para ver sua tabuada completa.\nNúmero: ");
  scanf("%d%*c", &numero);
  printf("\n");
  for (int i = 1; i <= 10; i++) {
    printf("%d x %d = %d\n", i, numero, (i*numero));
  }
  printf("\n");

  return 0;
}
