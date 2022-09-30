/* Efetue um programa que leia 5 números. Para cada número fornecido, escrever se ele é NULO, NEGATIVO ou POSITIVO. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numeros[5], i, aux;
  for (i = 0; i < 5; i++) {
    printf("Digite o %dº número: ", (i+1));
    scanf("%d%*c", &numeros[i]);
  }
  
  for(aux = 0; aux < i; aux++) {
    printf("\n");
    if (numeros[aux] < 0) {
      printf("Número %d - NEGATIVO\n", numeros[aux]);
    }
    else if (numeros[aux] == 0) {
      printf("Número %d - NULO\n", numeros[aux]);
    }
    else {
      printf("Número %d - POSITIVO\n", numeros[aux]);
    }
  }
  printf("\n");
  return 0;
}
