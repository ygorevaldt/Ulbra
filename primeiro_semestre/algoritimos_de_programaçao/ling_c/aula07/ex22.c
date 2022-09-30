#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  char nome[10];
  int idade;
  float peso;
  printf("---------------\n");
  printf("GRUPOS DE RISCO\n");
  printf("---------------\n");
  printf("Nome: ");
  gets(nome);
  printf("idade: ");
  scanf("%d%*c", &idade);
  printf("Peso: ");
  scanf("%f%*c", &peso);

  if (idade < 20 && peso < 60) {
    printf("%s está no grupo de risco: 9", nome);
  }
  else if (idade < 20 && peso >= 60 && peso <=90) {
    printf("%s está no grupo de risco: 8", nome);
  }
  else if (idade < 20 && peso > 90) {
    printf("%s está no grupo de risco: 7", nome);
  }
  else if (idade >= 20 && idade <= 50 && peso <= 60) {
    printf("%s está no grupo de risco: 6", nome);
  }
  else if (idade >= 20 && idade <= 50 && peso > 60 && peso <= 90) {
    printf("%s está no grupo de risco: 5", nome);
  }
  else if (idade >= 20 && idade <= 50 && peso > 60 && peso <= 90) {
    printf("%s está no grupo de risco: 5", nome);
  }
  else if (idade >= 20 && idade <= 50 && peso > 90) {
    printf("%s está no grupo de risco: 4", nome);
  }
  else if (idade > 50 && peso < 60) {
    printf("%s está no grupo de risco: 3", nome);
  }
  else if (idade > 50 && peso >= 60 && peso <=90) {
    printf("%s está no grupo de risco: 2", nome);
  }
  else if (idade > 50 && peso > 90) {
    printf("%s está no grupo de risco: 1", nome);
  }
  return 0;
}