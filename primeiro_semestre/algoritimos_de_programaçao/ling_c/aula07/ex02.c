#include <stdio.h>
#include <stdlib.h>
/*Se for exercutar o programa fora do windows desconsiderar o uso dessa biblioteca*/
#include <windows.h>

#define MEDIA_REPROVADO 4
#define MEDIA_APROVADO 7
int main() {
  /*Se for exercutar o programa fora do windows desconsiderar este código*/ 
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float mediaAritimetica, notas[2] = {};
  int i =0;
  for (i = 0; i < 2; i++){
    printf("Digite a nota: ");
    scanf("%f%*c", &notas[i]);
    mediaAritimetica += notas[i];
  }
  mediaAritimetica /= (i);
  if (mediaAritimetica < MEDIA_REPROVADO){
    printf("Média %.1f - REPROVADO\n", mediaAritimetica);
  }
  else if (mediaAritimetica >= MEDIA_REPROVADO && mediaAritimetica < MEDIA_APROVADO){
    printf("Média %.1f - EXAME\n", mediaAritimetica);
  }
  else {
    printf("Média %.1f - APROVADO\n", mediaAritimetica);
  }
  return 0;
}