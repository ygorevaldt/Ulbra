#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#define TAM 5

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float vendas[TAM];
  int percentual[TAM];
  char vendedores[TAM][20];

  for ( int i = 0; i < TAM; i++) {
    printf("Digite as vendas: ");
    scanf("%f%*c", &vendas[i]);
    printf("Digite o percentual: ");
    scanf("%d%*c", &percentual[i]);
    printf("Digite o nome do vendedor: ");
    scanf("%s%*c", &vendedores[i]);
  }

  for (int i = 0; i < TAM; i++) {
    float valorComissao = (vendas[i] * percentual[i]) / 100;
    printf("O vendedor %s fez %.0f vendas - Valor a receber %.2f\n", vendedores[i], vendas[i], vendas[i]*valorComissao);
  }
  int maiorVenda = 0;
  int menorVenda = 0;
  float totalVenda = 0;

  for (int i = 0; i < TAM; i++) {
    if(vendas[maiorVenda] < vendas[i]) {
      maiorVenda = i;
    }
    if(vendas[menorVenda] > vendas[i]) {
      menorVenda = i;
    }
    totalVenda += vendas[i];
  }
  printf("Melhor endedor do mês: %s\n", vendedores[maiorVenda]);
  printf("Valor vendido: %.2f\n", vendas[maiorVenda]);
  printf("Pior vendedor do mês: %s\n", vendedores[menorVenda]);
  printf("Valor vendido: %.2f\n", vendas[menorVenda]);
  printf("Total de vendas: %.2f\n", totalVenda);

  return 0;
}