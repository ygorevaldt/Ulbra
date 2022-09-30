#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define APROVADO 7
#define REPROVADO 3
#define PESO_EXAME 12

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i;
  float notas[3] = {}, mediaAritimetica = 0, notaExame;
  for(i = 0; i < 3; i++) {
    printf("Digite a %dº nota: ", (i+1));
    scanf("%f%*c", &notas[i]);
    mediaAritimetica += notas[i];
  }
  mediaAritimetica /= i;
  notaExame = PESO_EXAME - mediaAritimetica;
  if (mediaAritimetica >= APROVADO) {
    printf("Média %.1f - APROVADO", mediaAritimetica);
  }
  else if (mediaAritimetica < APROVADO && mediaAritimetica >= REPROVADO) {
    printf("Média %.1f - EXAME\nO aluno precisa tirar nota %.1f no exame final para passar", mediaAritimetica, notaExame);
  }
  else {
    printf("Média %.1f - REPROVADO", mediaAritimetica);
  }
  return 0;
}