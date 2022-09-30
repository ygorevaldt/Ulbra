/* Elabore um programa que escreva a tabuada do número 9 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  printf("-=-=-=-=-=-=-=-=-=-=-=\n");
  printf(" =-= TABUADA DO 9 =-= \n");
  printf("-=-=-=-=-=-=-=-=-=-=-=\n");
  for (int i = 1; i <= 10; i++) {
    printf("%d x 9 = %d\n", i, (i*9));
  }
  printf("\n");
  return 0;
}