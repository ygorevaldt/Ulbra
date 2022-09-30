#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int i = 0;
  float numeros[] = {}, menorNumero;
  for (i = 0; i < 2; i++) {
    printf("Digite o %dº número: ", (i+1));
    scanf("%f%*c", &numeros[i]);
  }
  if (numeros[0] < numeros[1]) {
    menorNumero = numeros[0];
    printf("O menor número digitado foi: %.1f", menorNumero);
  } 
  else {
    menorNumero = numeros[1];
    printf("O menor número digitado foi: %.1f", menorNumero);
  }
  return 0;
}