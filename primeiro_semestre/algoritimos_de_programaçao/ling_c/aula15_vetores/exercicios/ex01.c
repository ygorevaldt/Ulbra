#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[6] = {};
  int contadorPar = 0;
  int contadorImpar = 0;
  for (int i = 0 ; i < 6 ; i++) {
    printf("Digite o %dº número: ", i+1);
    scanf("%d%*c", &vetor[i]);
  }
  printf("Os números pares foram: ");
  for (int i = 0 ; i < 6 ; i++) {
    if (vetor[i] % 2 == 0) {
      contadorPar++;
      printf("%d ", vetor[i]);
    }
  }
  printf(" Total: %d números PARES\n", contadorPar);

  printf("Os números impares foram: ");
  for (int i = 0 ; i < 6 ; i++) {
    if (vetor[i] % 2 == 1) {
      contadorImpar++;
      printf("%d ", vetor[i]);
    }
  }
  printf(" Total: %d números IMPARES", contadorImpar);
  return 0;
}