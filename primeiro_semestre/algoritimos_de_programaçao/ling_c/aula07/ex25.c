#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  float horasNormais, horasExtras, horasFaltas, horas, minutos;
  printf("Números de horas normais: ");
  scanf("%f%*c", &horasNormais);
  printf("Números de horas extras: ");
  scanf("%f%*c", &horasExtras);
  printf("Números de horas faltas: ");
  scanf("%f%*c", &horasFaltas);

  horas = horasExtras - (2 / 3 * (horasNormais - horasFaltas));
  minutos = horas * 60;

  if (minutos > 2400) {
    printf("Premio: $500,00");
  }
  else if (minutos >= 1800 && minutos < 2400) {
    printf("Premio: $400,00");
  }
  else if (minutos >= 1200 && minutos < 1800) {
    printf("Premio: $300,00");
  }
  else if (minutos >= 600 && minutos < 1200) {
    printf("Premio: $200,00");
  }
  else if (minutos < 600) {
    printf("Premio: $100,00");
  }
  return 0;
}