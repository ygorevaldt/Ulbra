#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float valorInvestido, rendimento, valorToal;
  int tipoInvestimento;

  printf("\n");
  printf("TIPOS DE INVESTIMENTO\n");
  printf("---------------------\n");
  printf("[1] - Poupança - 3%% ao mês\n");
  printf("[2] - Fundos de renda fica - 4%% ao mês\n");
  printf("Escolha um tipo de investimento: ");
  scanf("%d%*c", &tipoInvestimento);
  while (tipoInvestimento <= 0 || tipoInvestimento > 2) {
    printf("Opção inválida.\nEscolha um tipo de investimento: ");
    scanf("%d%*c", &tipoInvestimento);
  }
  printf("Valor há investir: $");
  scanf("%f%*c", &valorInvestido);
  while (valorInvestido <= 0) {
    printf("valor inválido.\nDigite um valor de investimento válido: $");
    scanf("%f%*c", &valorInvestido);
  }  
  if (tipoInvestimento == 1) {
    rendimento = valorInvestido * 3 / 100;
    valorToal = valorInvestido + rendimento;
    printf("Valor total após rendimento: $%.2f", valorToal);
  }
  else {
    rendimento = valorInvestido * 4 / 100;
    valorToal = valorInvestido + rendimento;
    printf("Valor total após rendimento: $%.2f", valorToal);
  }
  return 0;
}