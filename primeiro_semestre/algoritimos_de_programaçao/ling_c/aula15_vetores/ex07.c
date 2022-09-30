#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float vetor[] = {11.2, 15.8, -10.5, -32.7, 88.3, 9.81, 12.5, 76.5, 7.7, 1.1};
  int quantidadeNumerosNegativos = 0;
  float somaNumerosPositivos = 0;

  for(int i = 0; i < 10; i++) {
    if (vetor[i] >= 0) {
      somaNumerosPositivos += vetor[i];
    }
    if (vetor[i] < 0) {
      quantidadeNumerosNegativos++;;
    }
  }
  printf("Quantidade de números negativos do vetor: %d\nSoma dos números positivos do vetor: %.2f", quantidadeNumerosNegativos, somaNumerosPositivos);
  return 0;
}