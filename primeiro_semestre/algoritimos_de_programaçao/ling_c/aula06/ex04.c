#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numeros[3] = {}, i = 0, temp, aux, n1, n2, n3;
  printf("Digite 3 números:\n");
  while(i < 3) {
    printf("%dº número: ", (i+1));
    scanf("%d%*c", &numeros[i]);
    i++;
  }
  n1 = numeros[0], n2 = numeros[1], n3 = numeros[2];
  if (n1 > n2) {
    aux = n1;
    n1 = n2;
    n2 = aux;
  }
  if (n1 > n3) {
    aux = n1;
    n1 = n3;
    n3 = aux;
  }
  if (n2 > n3) {
    aux = n2;
    n2 = n3;
    n3 = aux;
  }
  printf("%d, %d, %d", n1, n2, n3);
  return 0;
}