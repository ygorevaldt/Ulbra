#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#define MEDIA_APROVADO 7
/*Se for exercutar o programa fora do windows desconsiderar o uso dessa biblioteca*/
#include <windows.h>

int main() {
  /*Se for exercutar o programa fora do windows desconsiderar este código*/ 
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float mediaAritimetica = 0, notas[4] = {};
  int i;
  for (i = 0; i < 4; i++) {
    printf("Digite a %dº nota do aluno: ", (i+1));
    scanf("%f%*c", &notas[i]);
    mediaAritimetica += notas[i];
  }
  mediaAritimetica /= i;
  if (mediaAritimetica >= MEDIA_APROVADO){
  printf("Nota do aluno: %.1f - APROVADO\n", mediaAritimetica);
  }
  else {
  printf("Nota do aluno: %.1f - REPROVADO\n", mediaAritimetica);
  }
  return 0;
}
