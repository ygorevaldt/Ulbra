#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[15] = {2, 5, 15, 20, 35, 30, 2, 8, 45, 11, 30, 91, 21, 30, 1};
  int posicao[] = {};
  int aux = 0, i, c;
  printf("\n");
  for (i = 0 ; i < 15 ; i++) {
    if (vetor[i] == 30) {
      aux++;
      posicao[i] = i;
    }
  }
  if (aux >= 0) {
    printf("Existem %d elementos iguais a 30 no vetor.\n", aux);
    if (aux > 0) {
      printf("Eles se encontram nas posições: ");
      for (int c = 0; c < aux; c++) {
        printf("%d ", posicao[c]);
      }
    }
  }

  return 0;
}