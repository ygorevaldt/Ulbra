#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <math.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numeros[4], i = 0, aux = 1, vazia, vaziaB;
  printf("Digite 3 números em ordem crescente e outro número que não obedeça a essa regra\n");
  while(i < 4){
    printf("%dº número: ", (aux));
    scanf("%d%*c", &numeros[i]);
    i++;
    aux++;
  }
  printf("\nOs números digitados foram: ");
  i = 0;
  while(i < 4) {
    printf("%d ", numeros[i]);
    i++;
  }

  printf("\nOs números digitados em ordem decrescente são: ");
  aux = 1;
  for (i = 0; i < 2; i++) {
    if (numeros[i] > numeros[i + aux]) {
      vazia = numeros[i];
      numeros[i] = numeros[i + aux];
      numeros[i + aux] = vazia;
      }
    }
  for (i = 3; i >= 0; i--){
    printf("%d ", numeros[i]);
  }
  return 0;
}
