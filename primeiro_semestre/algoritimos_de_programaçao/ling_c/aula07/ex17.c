#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define SENHA 4531

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int senhaInformada;
  printf("Digite a sua senha: ");
  scanf("%d%*c", &senhaInformada);
  if (senhaInformada == SENHA) {
    printf("Acesso permitido");
  }
  else {
    printf("Acesso negado");
  }
  return 0;
}