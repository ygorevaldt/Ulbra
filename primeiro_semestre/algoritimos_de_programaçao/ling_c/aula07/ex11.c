#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float salarioAtual, percAumento;
  printf("Salario: $");
  scanf("%f%*c", &salarioAtual);
  if (salarioAtual <= 300) {
    percAumento = salarioAtual * 15 / 100;
    salarioAtual += percAumento;
    printf("Aumento de $%.2f\nNovo salario: $%.2f", percAumento, salarioAtual);
  }
  else if (salarioAtual > 300 && salarioAtual <= 600) {
    percAumento = salarioAtual * 10 / 100;
    salarioAtual += percAumento;
    printf("Aumento de $%.2f\nNovo salario: $%.2f", percAumento, salarioAtual);
  }
  else if (salarioAtual > 600 && salarioAtual <= 900) {
    percAumento = salarioAtual * 5 / 100;
    salarioAtual += percAumento;
    printf("Aumento de $%.2f\nNovo salario: $%.2f", percAumento, salarioAtual);
  }
  else {
    printf("Não há aumento disponível para esse valor de salário. \n");
  }
  return 0;
}