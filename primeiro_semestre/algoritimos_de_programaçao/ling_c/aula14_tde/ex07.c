/* Escreva um programa que leia 10 números inteiros e os armazene em um vetor. Imprima  o vetor, o maior elemento e a posição em que ele se encontra. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numeros[10] = {};
  int maior, aux, posicao;
  int contador = 0;
  for (int i = 0; i < 10; i++){
    printf("Digite %dº valor: ", i + 1);
    scanf("%d%*c", &numeros[i]);
  }   
  maior = numeros[0];
  for (int i = 0; i < 10; i++){
    if (numeros[i] > maior) {
      maior = numeros[i];
      posicao = i;
    }
    printf("%d ", numeros[i]);
  }
  printf("\nMaior número: %d ", maior);
  printf("e ele está na posição [%d] do vetor.", posicao);
  return 0;
}
