/*
3 - Faça um programa que leia um vetor de 10 posições e verifique se existem valores iguais e os escreva na tela.
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_VETOR 10

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[TAM_VETOR] = {8, 15, 10, 21, 10, 15, 24, 3, 19, 8};
  int aux;
  int i;

  for (i = 0; i < TAM_VETOR; i++) {
    for (aux = i+1; aux < TAM_VETOR; aux++ ){
      if(vetor[i] == vetor[aux]) {
        printf("O valor %d se repete no vetor!\n", vetor[i]);
      };
    };
  };
  
  return 0;
}