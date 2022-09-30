#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int primeiroNumero, segundoNumero;
  printf("Digite um número: ");
  scanf("%d%*c", &primeiroNumero);
  printf("Digite outro número: ");
  scanf("%d%*c", &segundoNumero);
 
  if (primeiroNumero % 2 == 0) {
    printf("o número %d é multiplo de dois\n", primeiroNumero);
  }
  if (primeiroNumero % 2 == 1) {
    printf("o número %d não é multiplo de dois\n", primeiroNumero);
  }
  if (segundoNumero % 2 == 0) {
    printf("o número %d não é multiplo de dois\n", segundoNumero);
  }
  if (segundoNumero % 2 == 1) {
    printf("o número %d não é multiplo de dois\n", segundoNumero);
  }
  return 0;
}