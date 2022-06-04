#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  double salario, aumento, novoSalario;
  printf("Digite o valor do salário: $");
  scanf("%lf%*c", &salario);
  if (salario < 500) {
    printf("Aumento não autorizado\n");
  }
  else {
    aumento = salario * 30 / 100;
    novoSalario = salario + aumento;
    printf("Aumento autorizado.\nNovo salário: $%.2lf\n", novoSalario);
  }
  return 0;
}