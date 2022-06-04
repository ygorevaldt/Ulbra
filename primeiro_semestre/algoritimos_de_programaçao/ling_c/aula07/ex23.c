#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int codigoProduto, quantidadeComprada;
  float preco, total, desconto;
  printf("Código do produto: ");
  scanf("%d%*c", &codigoProduto);
  while(codigoProduto <= 0) {
    printf("Código inválido\nDigite o código do produto: ");
    scanf("%d%*c", &codigoProduto);
  }
  printf("Quantidade comprada: ");
  scanf("%d%*c", &quantidadeComprada);
  while(quantidadeComprada <= 0) {
    printf("Quantidade inválida\nDigite a quantidade comprada: ");
    scanf("%d%*c", &quantidadeComprada);
  }
  if(codigoProduto >= 1 && codigoProduto <= 10) {
    preco = 10 * quantidadeComprada;
    total = preco;
    if (total <= 250) {
      desconto = total * 5 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else if (total > 250 && total <= 500) {
      desconto = total * 10 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else {
      desconto = total * 15 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
  }
  else if(codigoProduto >= 11 && codigoProduto <= 20) {
    preco = 15 * quantidadeComprada;
    total = preco;
    if (total <= 250) {
      desconto = total * 5 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else if (total > 250 && total <= 500) {
      desconto = total * 10 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else {
      desconto = total * 15 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
  }
  else if(codigoProduto >= 21 && codigoProduto <= 30) {
    preco = 20 * quantidadeComprada;
    total = preco;
    if (total <= 250) {
      desconto = total * 5 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else if (total > 250 && total <= 500) {
      desconto = total * 10 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else {
      desconto = total * 15 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
  }
  else {
    preco = 30 * quantidadeComprada;
    total = preco;
    if (total <= 250) {
      desconto = total * 5 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else if (total > 250 && total <= 500) {
      desconto = total * 10 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
    else {
      desconto = total * 15 / 100;
      total -= desconto;
      printf("Total %.2f", total);
    }
  }
  return 0;
}