/*
  6-Faça um programa para ler 10 números DIFERENTES a serem armazenados em um vetor.
  Os dados deverão ser armazenados no vetor na ordem que forem sendo lidos.
  Caso o usuário digite um número que já foi digitado anteriormente, o programa devera pedir para ele digitar outro número. 
  Note que cada valor digitado pelo usuário deve ser pesquisado no vetor, verificando se ele existe entre os números que já foram fornecidos. 
  Exibir na tela o vetor final digitado.
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_VETOR 5

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float vetor[TAM_VETOR] = {};
  int i;
  int aux;
  float numTemp;

  printf("Digite %d números diferentres para criar um vetor de %d posições: \n", TAM_VETOR, TAM_VETOR);
  for(i = 0; i < TAM_VETOR; i++) {
    printf("%dº Número: ", i+1);
    scanf("%f%*c", &vetor[i]);

    // Exercicio incompleto
  }
  return 0;
}