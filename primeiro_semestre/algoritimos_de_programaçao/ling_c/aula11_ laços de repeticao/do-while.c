#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main () {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int i = 0;

  /* Exemplo de laço de repetição do-while */
  do
  {
  printf("%d - Escreva um do-while\n", i+1);
  i++;
  } while (i < 10);

  return 0;
}