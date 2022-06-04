/* Crie um programa que lê 6 valores inteiros e, em seguida, mostre na tela os valores lidos.  */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int lista_numeros[6] = {};
  for (int i = 0 ; i < 6 ; i++) {
    printf("%dº número: ", i+1);
    scanf("%d%*c", &lista_numeros[i]);
  }
  printf("Resultado: ");
  for (int i = 0 ; i < 6 ; i++) {
    printf("%d ", lista_numeros[i]);
  }
  return 0;
}