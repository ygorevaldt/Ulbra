#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;  
  SetConsoleOutputCP(CPAGE_UTF8);

  printf("Olá mundo");
  return 0;
}