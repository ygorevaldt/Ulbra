/* Crie um programa que lê 6 valores inteiros e, em seguida, mostre na tela os valores lidos ˆ na ordem inversa.  */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[6] = {};
  for (int i = 0 ; i < 6 ; i++) {
    printf("Digite o %dº número: ", i+1);
    scanf("%d%*c", &vetor[i]);
  }

  for (int i = 5 ; i >= 0 ; i--) {
    printf("%d ", vetor[i]);
  }
  return 0;
}