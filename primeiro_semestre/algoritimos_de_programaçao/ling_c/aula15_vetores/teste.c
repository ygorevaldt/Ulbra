#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  char nome[10] = {};
  printf("%d",strcmp("Banana", "Banana"));

  printf("\nDigite um nome: ");
  gets(nome);
  printf("%s\n", strlen(nome));
}