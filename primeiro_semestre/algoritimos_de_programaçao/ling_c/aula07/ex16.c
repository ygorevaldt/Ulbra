#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float valorProduto, percDesconto;
  int codigoProduto;
  printf("Valor do produto: $");
  scanf("%f%*c", &valorProduto);
  while(valorProduto <= 0) {
    printf("Valor inválido\nValor do produto: $");
    scanf("%f%*c", &valorProduto);
  }
  printf("Código do produto: ");
  scanf("%d%*c", &codigoProduto);
  while(codigoProduto <= 0) {
    printf("Código inválido\nCódigo do produto: ");
    scanf("%f%*c", &codigoProduto);
  }
  if (valorProduto > 0 && valorProduto <= 30){
    percDesconto = 0;
    valorProduto -= percDesconto;
    printf("Produto sem desconto\nPreço: $%.2f", valorProduto);
  }
  else if (valorProduto > 30 && valorProduto <= 100){
    percDesconto = valorProduto * 10 / 100;
    valorProduto -= percDesconto;
    printf("Valor do desconto: $%.2f\nPreço com desconto: $%.2f", percDesconto, valorProduto);
  }
  else{
    percDesconto = valorProduto * 15 / 100;
    valorProduto -= percDesconto;
    printf("Valor do desconto: $%.2f\nPreço com desconto: $%.2f", percDesconto, valorProduto);
  }
  return 0;
}