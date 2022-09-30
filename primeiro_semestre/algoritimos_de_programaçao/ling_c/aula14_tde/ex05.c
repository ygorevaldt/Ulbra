/* 
Leia um vetor de 10 posições. Contar e escrever quantos valores pares ele possui. 
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <math.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int vetor[10] = {1, 5, 8, 2, 4, 6, 3, 9, 12, 15};
  int contador = 0;
  for (int i = 0 ; i < 10 ; i++) {
    if (vetor[i] % 2 == 0) {
      printf("%d ", vetor[i]);
      contador++;
    }
  }
  printf("\nTem %d números pares neste vetor.", contador);
  return 0;
}