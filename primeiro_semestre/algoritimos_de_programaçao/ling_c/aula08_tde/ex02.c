#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define MAIOR_IDADE 18

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int idade;
  printf("Digite sua idade: ");
  scanf("%d%*c", &idade);
  while(idade <= 0) {
    printf("Idade inválida\nDigite sua idade novamente: ");
    scanf("%d%*c", &idade);
  }

  if (idade < MAIOR_IDADE) {
    printf("Você tem %d anos - Menor de idade", idade);
  }
  else {
    printf("Você tem %d anos - Maior de idade", idade);
  }
  return 0;
}