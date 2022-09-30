/*
  4- Faça um programa que leia um vetor de 5 posições para números reais e depois, um código inteiro. 
  Se o código for 0: finalize o programa.
  se for 1: mostre o vetor na ordem  direta. 
  se for 2: mostre o vetor na ordem inversa.
  Caso, o código diferir de 1 e 2: escreva uma mensagem informando que o código  e inválido. 
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_VETOR 5

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float vetor[TAM_VETOR] = {};
  int codigo;
  int i;
  int aux;

  printf("Digite valores reais para preencher um vetor de 5 posições: \n");
  for(i = 0; i < TAM_VETOR; i++) {
    printf("%dº Valor: ", i + 1);
    scanf("%f%*c", &vetor[i]);
  };

  printf("Suas opções: \n");
  printf("Código [0] - Finalizar programa\n");
  printf("Código [1] - Mostrar o vetor na ordem direta\n");
  printf("Código [2] - Mostrar o vetor na ordem inversa\n");
  printf("Sua opção: ");
  scanf("%d%*c", &codigo);
  while (codigo > 2 || codigo < 0) {
      printf("Opção inválida! Tente novamente\nSua opção: ");
      scanf("%d%*c", &codigo);
  }

  switch (codigo){
  case 0:
    printf("Programa finalizado");
    break;
  case 1:
    for(i = 0; i < TAM_VETOR; i++) {
      for(aux = i+1; aux < TAM_VETOR; aux++) {
        if(vetor[i] > vetor[aux]) {
          float temp = vetor[i];
          vetor[i] = vetor[aux];
          vetor[aux] = temp;
        }
      }
      printf("%.2f\n", vetor[i]);
    }
    break;
  case 2:
    for(i = TAM_VETOR -1 ; i >= 0; i--) {
      for(aux = i-1; aux >= 0; aux--) {
        if(vetor[i] < vetor[aux]) {
          float temp = vetor[i];
          vetor[i] = vetor[aux];
          vetor[aux] = temp;
        }
      }
      printf("%.2f\n", vetor[i]);
    }
    break;
  }
  return 0;
}