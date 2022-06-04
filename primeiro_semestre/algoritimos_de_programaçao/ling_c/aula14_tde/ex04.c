/* 
Faça um programa que leia um vetor de 8 posições e, em seguida, leia também dois valores X e Y quaisquer correspondentes a duas posições no vetor. Ao final, seu programa deverá escrever a soma dos valores encontrados nas respectivas posições  X e Y . 
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <math.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int valores[8] = {1, 5, 9, 4, 3, 5, 2, 8}, x, y;
  for (int i = 0 ; i < 8 ; i++) {
    if (i == 0) {
      printf("[");
    }
    printf("%d ", valores[i]);
    if (i == 7) {
      printf("]");
    }
  }
  x = valores[2];
  y = valores[5];
  printf("\nA soma entre o número %d e o número %d é igual a: %d", x, y, (x+y));
  return 0;
}