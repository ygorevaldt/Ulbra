#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  char sexo[10];
  float altura, pesoIdeal;
  printf("[Masculino/Feminino]\nInforme o sexo: ");
  gets(sexo);
  printf("Informe sua altura: ");
  scanf("%f%*c", &altura); 
  if (strcmp(sexo,"Masculino") == 0) {
    pesoIdeal = (72.7 * altura) - 58;
    printf("O peso ideal de uma pessoa de %.1fm de altura e do sexo %s é: %.1fkg", altura, sexo, pesoIdeal);
  }
  else if (strcmp(sexo, "Feminino") == 0) {
    pesoIdeal = (62.1 * altura) - 44.7;
    printf("O peso ideal de uma pessoa de %.1fm de altura e do sexo %s é: %.1fkg", altura, sexo, pesoIdeal);
  }
  return 0;
}

  