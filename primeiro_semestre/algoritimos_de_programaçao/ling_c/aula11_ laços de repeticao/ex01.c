/* Elabore um programa que calcule e escreva a soma de 10 números lidos.Esse algorimo deve ser feito três vezes uma usando o FOR, DO-WHILE e WHILE */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  printf("\n=-=-=-=-=-=-=-=-=-=-=\n");
  printf("   SOMANDO NÚMEROS   \n");
  printf("=-=-=-=-=-=-=-=-=-=-=\n\n");

  /* do-while */
  int i = 0, soma = 0, numero;
  do { 
    printf("Digite o %dº número: ", i+1);
    scanf("%d%*c", &numero);
    soma += numero;
    i++;
  }
  while(i < 10);
  printf("A soma dos números digitados é igual a: %d\n\n", soma);

  /* while */
  i = 0, soma = 0, numero = 0;
  while (i < 10) {
    printf("Digite o %dº número: ", i+1);
    scanf("%d%*c", &numero);
    soma += numero;
    i++;
  }
  printf("A soma dos números digitados é igual a: %d\n\n", soma);

  /* for */
  soma = 0, numero = 0;
  for (i = 0 ; i < 10; i++) {
    printf("Digite o %dº número: ", i+1);
    scanf("%d%*c", &numero);
    soma += numero;
  }
  printf("A soma dos números digitados é igual a: %d\n", soma);

  return 0;
}