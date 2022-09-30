#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i;
  float numeros[2] = {}, maiorNumero;
  for (i = 0; i < 2; i++) {
    printf("Digite o %dº número: ", (i+1));
    scanf("%f%*c", &numeros[i]);
  }
  maiorNumero = numeros[0];
  if (numeros[1] > maiorNumero){
    maiorNumero = numeros[1];
  }
  printf("O maior número digitado foi %.1f", maiorNumero);
  return 0;
}