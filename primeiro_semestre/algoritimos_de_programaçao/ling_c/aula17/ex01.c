#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <time.h>
#define TAM_VETOR 100

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[TAM_VETOR] = {};
  int opcao;
  int i = 0;
  int maiorValor = 0;
  srand(time(NULL));
  for (i = 0; i < TAM_VETOR; i++) {
    vetor[i] = rand() % 1000;
    if(vetor[i] == 999) {
      printf("O número randômico é %d, fim do algoritimo", vetor[i]);
      break;
    }
  }

  printf("Menu de opções: \n");
  printf("[1] - Exibir lista os números presentes no vetor.\n");
  printf("[2] - Imprimir o vetor na ordem inversa.\n");
  printf("[3] - Exibir o maior número.\n");
  printf("[4] - Exibir quantos números foram sorteados.\n");
  printf("[5] - Encerrar o programa.\n");
  printf("Digite a sua opção: ");
  scanf("%d%*c", &opcao);

  switch (opcao)
  {
  case 1:
    for (i = 0; i < TAM_VETOR; i++) {
      for(int aux = i + 1; aux < TAM_VETOR; aux++) {
        if(vetor[i] > vetor[aux]) {
          int temp = vetor[i];
          vetor[i] = vetor[aux];
          vetor[aux] = temp;
        }
      }
      printf("%d ", vetor[i]);
    }
    break;
  case 2:
    for (i = TAM_VETOR - 1; i >= 0; i--) {
      for(int aux = i - 1; aux < TAM_VETOR; aux++) {
        if(vetor[i] < vetor[aux]) {
          int temp = vetor[i];
          vetor[i] = vetor[aux];
          vetor[aux] = temp;
        }
      }
      printf("%d ", vetor[i]);
    }
    break;
  case 3:
    for (i = 0; i < TAM_VETOR; i++) {
      for(int aux = i + 1; aux < TAM_VETOR; aux++) {
        if(vetor[i] > vetor[aux]) {
          maiorValor = vetor[i];
          vetor[i] = vetor[aux];
          vetor[aux] = maiorValor;
        }
      }
    }
    printf("%d ", maiorValor);
    break;
  case 4:
    printf("%d números foram sorteados.", i);
    break;
  case 5:
    printf("Programa encerrado.");
    break;
  default:
    printf("Opção inválida.");
  }
  return 0;
}