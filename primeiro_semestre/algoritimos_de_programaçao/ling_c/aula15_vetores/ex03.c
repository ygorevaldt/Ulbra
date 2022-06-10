#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int TAM=3;
  int codProdutos[] = {10,20,30,40,50,60,70,80,90,100};
  int qtdProduto[] = {15,15,15,15,15,15,15,15,15,15};
  int codigoCliente;
  int codigoProduto;
  int i, quantidadeDoProduto, pos = -1;

  printf("Digite o código do cliente: ");
  scanf("%d%*c", &codigoCliente);
  printf("Bem vindo cliente %d\n", codigoCliente);
  do {
    printf("Digite o código do produto que você deseja: ");
    scanf("%d%*c", &codigoProduto);
    if (codigoProduto == 0) {
      printf("Compra finalizada");
      break;
    }
    printf("Produto [%d]. Digite a quantidade do produto que você deseja: ", codigoProduto);
    scanf("%d%*c", &quantidadeDoProduto);
    if (quantidadeDoProduto < qtdProduto[0]){
      printf("Ok, %d de produto adicionada ao seu carrinho.\n", quantidadeDoProduto);
    } else {
      printf("Produto sem estoque\n");
    }
  } while(codigoProduto != 0);
  return 0;
}