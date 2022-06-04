#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float nota1, nota2, nota3, media;
  printf("Digite a primeira nota: ");
  scanf("%f%*c", &nota1);
  while (nota1 < 0 || nota1 > 10) {
    printf("Nota inválida\nDigite novamente: ");
    scanf("%f%*c", &nota1);
  }

  printf("Digite a segunda nota: ");
  scanf("%f%*c", &nota2);
  while (nota2 < 0 || nota2 > 10) {
    printf("Nota inválida\nDigite novamente: ");
    scanf("%f%*c", &nota2);
  }

  printf("Digite a terceira nota: ");
  scanf("%f%*c", &nota3);
  while (nota3 < 0 || nota3 > 10) {
    printf("Nota inválida\nDigite novamente: ");
    scanf("%f%*c", &nota3);
  }

  media = (nota1 + nota2 + nota3) / 3;

  if (media >= 9) {
    printf("Média %.1f - Conceito A", media);
    printf("\nnotas %.1f, %.1f, %.1f - APROVADO", nota1, nota2, nota3);
  }
  else if (media >= 7 && media < 9) {
    printf("Média %.1f - Conceito B", media);
    printf("\nnotas %.1f, %.1f, %.1f - APROVADO", nota1, nota2, nota3);
  }
  else if (media >= 6 && media < 7.5) {
    printf("Média %.1f - Conceito C", media);
    printf("\nnotas %.1f, %.1f, %.1f - APROVADO", nota1, nota2, nota3);
  }
  else if (media >= 4 && media < 6) {
    printf("Média %.1f - Conceito D", media);
    printf("\nnotas %.1f, %.1f, %.1f - REPROVADO", nota1, nota2, nota3);
  }
  else {
    printf("Média %.1f - Conceito E", media);
    printf("\nnotas %.1f, %.1f, %.1f - REPROVADO", nota1, nota2, nota3);
  }
  return 0;
}