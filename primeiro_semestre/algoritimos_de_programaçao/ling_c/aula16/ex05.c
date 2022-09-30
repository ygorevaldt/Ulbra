/*
  5-Faça um programa que receba do usuário dois vetores, A e B, com 10 números inteiros cada. 
  Crie um novo vetor denominado C calculando C = A - B. Mostre na tela os dados do vetor C.
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_VETOR 10

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetorA[TAM_VETOR] = {};
  int vetorB[TAM_VETOR] = {};
  int vetorC[TAM_VETOR] = {};
  
  printf("Prencha as %d posições do vetor A\n", TAM_VETOR);
  for(int i = 0; i < TAM_VETOR; i++) {
    printf("%dº posição: ", i+1);
    scanf("%d%*c", &vetorA[i]);
  }

  printf("Prencha as %d posições do vetor B\n", TAM_VETOR);
  for(int i = 0; i < TAM_VETOR; i++) {
    printf("%dº posição: ", i+1);
    scanf("%d%*c", &vetorB[i]);
  }
  for(int i = 0; i < TAM_VETOR; i++) {
    vetorC[i] = vetorA[i] - vetorB[i];
  }

  printf("Numeros do vetor C: ");
  for(int i = 0; i < TAM_VETOR; i++) {
    printf("%d ", vetorC[i]);
  }

  return 0;
}