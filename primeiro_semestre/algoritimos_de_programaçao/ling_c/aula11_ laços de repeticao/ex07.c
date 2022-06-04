/* Faça um programa que escreva os números de 1 a 20, em ordem decrescente. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i = 0;
  do {
    i++;
    if (i > 20) {
      break;
    }
    printf("%d ", i);
  } while(i <= 20);

  return 0;
}