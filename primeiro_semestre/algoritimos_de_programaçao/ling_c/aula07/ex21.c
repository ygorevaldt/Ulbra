#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float precoProduto;
  int codigoProduto;
  printf("-----------------------\n");
  printf("PROCEDÊNCIA DE PRODUTOS\n");
  printf("-----------------------\n");
  printf("Digite o preço do produto: ");
  scanf("%f%*c", &precoProduto);
  printf("Digite o código do produto: ");
  scanf("%d%*c", &codigoProduto);

  if (codigoProduto < 1 && codigoProduto > 30) {
    printf("Código inválido");
  }
  else if (codigoProduto == 1) {
    printf("Código %d: Procedência - SUL\n", codigoProduto);
  }
  else if (codigoProduto == 2) {
    printf("Código %d: Procedência - NORTE\n", codigoProduto);
  }
  else if (codigoProduto == 3) {
    printf("Código %d: Procedência - LESTE\n", codigoProduto);
  }
  else if (codigoProduto == 4) {
    printf("Código %d: Procedência - OESTE\n", codigoProduto);
  }
  else if (codigoProduto == 5 || codigoProduto == 6) {
    printf("Código %d: Procedência - NORDESTE\n", codigoProduto);
  }
  else if (codigoProduto == 7 || codigoProduto == 8 || codigoProduto == 9) {
    printf("Código %d: Procedência - SUDESTE\n", codigoProduto);
  }
  else if (codigoProduto >= 10 && codigoProduto <= 20) {
    printf("Código %d: Procedência - CENTRO-OESTE\n", codigoProduto);
  }
  else if (codigoProduto > 20 && codigoProduto <= 30) {
    printf("Código %d: Procedência - NORDESTE\n", codigoProduto);
  }
  return 0;
}