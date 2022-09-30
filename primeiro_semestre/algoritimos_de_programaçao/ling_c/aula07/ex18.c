#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int idade;
  printf("Digite a sua idade: ");
  scanf("%d%*c", &idade);
  while(idade < 0) {
    printf("A idade informada é inválida\nDigite a sua idade: ");
    scanf("%d%*c", &idade);
  }
  if (idade >= 18) {
    printf("Você tem %d anos, por tanto, é maior de idade.", idade);
  }
  else {
    printf("Você tem %d anos, por tanto, é menor de idade.", idade);
  }
  return 0;
}