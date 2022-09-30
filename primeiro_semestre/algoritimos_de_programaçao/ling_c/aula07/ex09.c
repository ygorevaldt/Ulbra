#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float saldoMedio, creditoEspecial;
  printf("Saldo médio da conta: $");
  scanf("%f%*c", &saldoMedio);

  if (saldoMedio > 300 && saldoMedio <= 400) {
    creditoEspecial = saldoMedio * 25 / 100;
    printf("Saldo médio: $%.2f\nCrédito especial: $%.2f", saldoMedio, creditoEspecial);
  }
  else if (saldoMedio > 200 && saldoMedio <= 300) {
    creditoEspecial = saldoMedio * 20 / 100;
    printf("Saldo médio: $%.2f\nCrédito especial: $%.2f", saldoMedio, creditoEspecial);
  }
  else if (saldoMedio <= 200) {
    creditoEspecial = saldoMedio * 10 / 100;
    printf("Saldo médio: $%.2f\nCrédito especial: $%.2f", saldoMedio, creditoEspecial);
  }
  else {
    creditoEspecial = saldoMedio * 30 / 100;
    printf("Saldo médio: $%.2f\nCrédito especial: $%.2f", saldoMedio, creditoEspecial);
  }
  return 0;
}