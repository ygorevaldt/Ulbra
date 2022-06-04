#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  double salario, valorReceber, imposto, gratificacao;
  printf("Salario bruto: $");
  scanf("%lf%*c", &salario);
  imposto = salario * 7 / 100;

  if (salario <= 350) {
    gratificacao = 100;
    valorReceber = (salario - imposto) + gratificacao;
    printf("Valor a receber: $%.2lf\n", valorReceber);
  }
  else if (salario > 350 && salario <= 600) {
    gratificacao = 75;
    valorReceber = (salario - imposto) + gratificacao;
    printf("Valor a receber: $%.2lf\n", valorReceber);
  }
  else if (salario > 600 && salario <= 900) {
    gratificacao  = 50;
    valorReceber = (salario - imposto) + gratificacao;
    printf("Valor a receber: $%.2lf\n", valorReceber);
  }
  else {
    gratificacao  = 35;
    valorReceber = (salario - imposto) + gratificacao;
    printf("Valor a receber: $%.2lf\n", valorReceber);
  }
  return 0;
}