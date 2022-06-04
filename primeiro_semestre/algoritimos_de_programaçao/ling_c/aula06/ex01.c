#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i;
  float notas[3] = {}, pesos[] = {2, 3, 5}, somaNotas = 0, somaPesos = 0, mediaPonderada;
  for (i = 0; i < 3; i++) {
    printf("Digite a %dº nota: ", (i+1));
    scanf("%f%*c", &notas[i]);
    somaNotas += notas[i] * pesos[i];
    somaPesos += pesos[i];
  }
  mediaPonderada = somaNotas / somaPesos;
  if (mediaPonderada >= 8.0 && mediaPonderada <= 10.0) {
    printf("A média ponderada das notas do aluno foi de: %.1f - CONCEITO A", mediaPonderada);
  }
  else if (mediaPonderada >= 7.0 && mediaPonderada < 8.0) {
    printf("A média ponderada das notas do aluno foi de: %.1f - CONCEITO B", mediaPonderada);
  }
  else if (mediaPonderada >= 6.0 && mediaPonderada < 7.0) {
    printf("A média ponderada das notas do aluno foi de: %.1f - CONCEITO C", mediaPonderada);
  }
  else if (mediaPonderada >= 5.0 && mediaPonderada < 6.0) {
    printf("A média ponderada das notas do aluno foi de: %.1f - CONCEITO D", mediaPonderada);
  }
  else {
    printf("A média ponderada das notas do aluno foi de: %.1f - CONCEITO E", mediaPonderada);
  }
  return 0;
}
