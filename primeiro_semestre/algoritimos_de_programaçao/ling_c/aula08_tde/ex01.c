#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  
  float numero1, numero2;
  printf("Digite dois números: ");
  scanf("%f%*c %f%*c", &numero1, &numero2);
  
  if (numero1 > numero2) {
    numero1 += 100;
    printf("O maior número digitado somado a 100 é igual a: %.1f", numero1);
  }
  else {
    numero2 += 100;
    printf("O maior número digitado somado a 100 é igual a: %.1f", numero2);
  }
  return 0;
}