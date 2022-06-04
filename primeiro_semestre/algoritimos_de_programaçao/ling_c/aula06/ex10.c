#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int dia1, mes1, ano1, dia2, mes2, ano2, somaData1, somaData2;
  printf("Digite respectivamente o dia, mês e ano de uma data da sua escolha: ");
  scanf("%d%*c %d%*c %d%*c", &dia1, &mes1, &ano1); 
  printf("Digite respectivamente o dia, mês e ano de outra data da sua escolha: ");
  scanf("%d%*c %d%*c %d%*c", &dia2, &mes2, &ano2); 
  somaData1 = dia1 + mes1 + ano1;
  somaData2 = dia2 + mes2 + ano2;

  if (somaData1 > somaData2) {
    printf("A maior data digitada foi %d / %d / %d", dia1, mes1, ano1);
  }
  else {
    printf("A maior data digitada foi %d / %d / %d", dia2, mes2, ano2);
  }
  return 0;
}
