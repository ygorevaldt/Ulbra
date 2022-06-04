#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float salario, percAumento;
  printf("Salario: $");
  scanf("%f%*c", &salario);

  if (salario >= 0 && salario <= 300) {
    percAumento = salario * 50 / 100;
    salario += percAumento;
    printf("Novo salário: $%.2f", salario);
  }
  else if (salario > 300 && salario <= 500) {
    percAumento = salario * 40 / 100;
    salario += percAumento;
    printf("Novo salário: $%.2f", salario);
  }
  else if (salario > 500 && salario <= 700) {
    percAumento = salario * 30 / 100;
    salario += percAumento;
    printf("Novo salário: $%.2f", salario);
  }
  else if (salario > 700 && salario <= 800) {
    percAumento = salario * 20 / 100;
    salario += percAumento;
    printf("Novo salário: $%.2f", salario);
  }
  else if (salario > 800 && salario <= 1000) {
    percAumento = salario * 10 / 100;
    salario += percAumento;
    printf("Novo salário: $%.2f", salario);
  }
  else if (salario > 1000) {
    percAumento = salario * 5 / 100;
    salario += percAumento;
    printf("Novo salário: $%.2f", salario);
  }
  else {
    printf("Valor inválido.\n");
  }
  return 0;
}