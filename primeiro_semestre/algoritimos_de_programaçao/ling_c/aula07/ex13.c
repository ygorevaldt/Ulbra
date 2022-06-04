#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float precoProduto, novoPreco, imposto;
  printf("Preço do produto: $");
  scanf("%f%*c", &precoProduto);
  if (precoProduto >= 0 && precoProduto <= 50) {
    imposto = precoProduto * 5 / 100;
    novoPreco = precoProduto + imposto;
    printf("Novo preço: $%.2f\n", novoPreco);
  }
  else if (precoProduto > 50 && precoProduto <= 100) {
    imposto = precoProduto * 10 / 100;
    novoPreco = precoProduto + imposto;
    printf("Novo preço: $%.2f\n", novoPreco);
  }
  else if (precoProduto > 100) {
    imposto = precoProduto * 15 / 100;
    novoPreco = precoProduto + imposto;
    printf("Novo preço: $%.2f\n", novoPreco);
  }
  else {
    novoPreco = precoProduto;
    printf("Valor inválido\n");

  }

  if (novoPreco >= 0 && novoPreco <= 80) {
    printf("Classificação: BARATO\n");
  }
  else if (novoPreco > 80 && novoPreco <= 120){
    printf("classificação: NORMAL\n");
  }
  else if (novoPreco > 120 && novoPreco <= 200){
    printf("classificação: CARO\n");
  }
  else if (novoPreco > 200) {
    printf("classificação: MUITO CARO\n");
  }
  return 0;
}

  




  // if (novoPreco <= 80) {
  //     printf("Classificação: BARATO");
  //   }