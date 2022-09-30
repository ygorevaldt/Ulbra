#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int numeros[4] = {}, i = 0, aux = 1;
  while(i < 4) {
    printf("Digite o %dº número: ", aux);
    scanf("%d%*c", &numeros[i]);
    i++;
  }
  printf("\nOs números digitados divisíveis por 2 e por 3 são: ");
  for (i; i >= 0; i--) {
    if (numeros[i] % 2 == 0) {
      printf("%d ", numeros[i]);
    }
    if (numeros[i] % 3 == 0) {
      printf("%d ", numeros[i]);
    }
  }
  return 0;
}