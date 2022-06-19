/*
2 - Escreve um programa que sorteia, aleatoriamente, 10 números e armazene estes em um vetor.
Em seguida, o usuário digita um número e seu programa em C deve acusar se o número digitado está no vetor ou não. Se estiver, diga a posição que está.
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <time.h>
#define TAM_VETOR 10


int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetorNumerosAleatorios[TAM_VETOR] = {};
  int numeroUsuario;
  int posicao;

  srand(time(NULL));
  for(int i = 0; i < TAM_VETOR; i++) {
    vetorNumerosAleatorios[i] = rand() % 100;
  }
  
  printf("Digite um número: ");
  scanf("%d", &numeroUsuario);

  for(int i = 0; i < TAM_VETOR; i++) {
    if (numeroUsuario == vetorNumerosAleatorios[i]) {
      posicao = i;
      printf("O número digitado está na posição %d do vetor de números aleatórios.\n", posicao);
    }
  }
  
  return 0;
}