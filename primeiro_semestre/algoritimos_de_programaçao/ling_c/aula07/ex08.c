#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  double salario, aumento, novoSalario;
  printf("Digite o valor do salário: $");
  scanf("%lf%*c", &salario);
  if (salario <= 300) {
    aumento = salario * 35 / 100;
    novoSalario = salario + aumento;
    printf("Aumento: 35%%\nNovo salário: $%.2lf", novoSalario);
  }
  else {
    aumento = salario * 15 / 100;
    novoSalario = salario + aumento;
    printf("Aumento: 15%%\nNovo salário: $%.2lf\n", novoSalario);
  }
  return 0;
}