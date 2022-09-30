#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numero;
  printf("Digite um número inteiro: ");
  scanf("%d%*c", &numero);
  if ((numero % 2) == 0){
    printf("O número %d é PAR", numero);
  }
  else {
    printf("O número %d é IMPAR", numero);
  }
  return 0;
}