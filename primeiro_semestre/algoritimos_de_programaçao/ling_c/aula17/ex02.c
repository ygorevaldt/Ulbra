#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#define TAM_VETOR 10
#define MEDIA_APROVACAO 7

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float vetorPrimeiraProva[TAM_VETOR] = {};
  float vetorSegundaProva[TAM_VETOR] = {};
  float vetorMediaNotas[TAM_VETOR] = {};
  char vetorAlunos[TAM_VETOR][50] = {};
  char condicao[3] = "S";
  int c = 0;

  while (strcmp(condicao, "S") == 0 || strcmp(condicao, "s") == 0) {
    printf("Nome do aluno: ");
    scanf("%s%*c", &vetorAlunos[c]);
    printf("Nota da 1º prova: ");
    scanf("%f%*c", &vetorPrimeiraProva[c]);
    printf("Nota da 2º prova: ");
    scanf("%f%*c", &vetorSegundaProva[c]);
    vetorMediaNotas[c] = (vetorPrimeiraProva[c] + vetorSegundaProva[c]) / 2;
    c++;
    if (c == TAM_VETOR) {
      break;
    }
    printf("Deseja adicionar um novo aluno: [S/N] ");
    scanf("%s%*c", &condicao);
  }
  
  int opcao = 0;
  printf("Menu de opções: \n");
  printf("[1] - Listar todos os alunos aprovados\n");
  printf("[2] - Listar todos os alunos reprovados\n");
  printf("[3] - Listar todos os alunos com nota maior que uma nota informada\n");
  printf("[4] - Informar uma Posição para o programa exibir os dados e notas de um aluno.\n");
  printf("[5] - Encerrar programa.\n");
  printf("Digite sua opção: ");
  scanf("%d%*c", &opcao);

  switch (opcao)
  {
  case 1:
    printf("Lista de alunos aprovados: \n");
    for(int i = 0; i < c; i++) {
      if (vetorMediaNotas[i] >= MEDIA_APROVACAO) {
        printf("%d - %s \n", (i+1), vetorAlunos[i]);
      }
    }
    break;

  case 2:
    printf("Lista de alunos Reprovados: \n");
    for(int i = 0; i < c; i++) {
      if (vetorMediaNotas[i] < MEDIA_APROVACAO) {
        printf("%d - %s \n", (i+1), vetorAlunos[i]);
      }
    }
    break;

  float notaInformada = 0;
  case 3:
    printf("Informe uma nota: ");
    scanf("%f%*c", &notaInformada);
    printf("Lista de alunos com nota maior do que a nota informada: \n");
    for(int i = 0; i < c; i++) {
      if (vetorMediaNotas[i] > notaInformada) {
        printf("%d - %s \n", (i+1), vetorAlunos[i]);
      }
    }
    break;
  int posicaoInformada = 0;
  case 4:
    printf("Informe uma posição: ");
    scanf("%d%*c", &posicaoInformada);
    for(int i = 0; i < c; i++) {
      if (posicaoInformada == i) {
        printf("Informações do aluno - %s \n", vetorAlunos[i]);
        printf("Nota da primeira prova: %.2f\n", vetorPrimeiraProva[i]);
        printf("Nota da segunda prova: %.2f\n", vetorSegundaProva[i]);
        printf("Média do aluno: %.2f\n", vetorMediaNotas[i]);
      }
    }
    break;

  case 5:
    printf("Programa encerrado.");
    break;

  default:
    printf("Opção inválida.");
    break;
  }
  
  return 0;
}