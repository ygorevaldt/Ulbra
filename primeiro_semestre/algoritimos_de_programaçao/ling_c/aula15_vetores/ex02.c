#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[6] = {2, 12, 225, 6, 7, 15};
  printf("Os números multiplos de 2 são: ");
  for (int i = 0; i < 6; i++) {
    if (vetor[i] % 2 == 0) {
      printf("%d ", vetor[i]);
    }
  }
  printf("\nOs números multiplos de 3 são: ");
  for (int i = 0; i < 6; i++) {
    if (vetor[i] % 3 == 0) {
      printf("%d ", vetor[i]);
    }
  }
  printf("\nOs números multiplos de 2 e de 3 são: ");
  for (int i = 0; i < 6; i++) {
    if (vetor[i] % 2 == 0 && vetor[i] % 3 == 0) {
      printf("%d ", vetor[i]);
    }
  }
  return 0;
}