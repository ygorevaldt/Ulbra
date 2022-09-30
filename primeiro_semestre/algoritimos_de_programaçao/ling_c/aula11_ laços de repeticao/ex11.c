/* Faça um programa que leia a matrícula, o nome e as três notas de 10 alunos, e indique para cada aluno, se ele foi aprovado ou não.
 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#define MEDIA 7

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float notas[3], somaNotas = 0, mediaAluno;
  int matricula, alunos = 0;
  char nome[20];
  while (alunos < 10){
    printf("\nNome: ");
    gets(nome);

    printf("Matricula: ");
    scanf("%d%*c", &matricula);

    for (int i = 0; i < 3; i++) {
      printf("%dº nota: ", i+1);
      scanf("%f%*c", &notas[i]);
    }

    printf("Aluno - %s\nMatricula - %d\n", nome, matricula);
    for (int i = 0; i < 3; i++) {
      printf("Nota %d - %.1f ", i+1, notas[i]);
      somaNotas += notas[i];
    }
    mediaAluno = somaNotas / 3;
    printf("\nMedia %.1f ", mediaAluno);
    if (mediaAluno >= MEDIA) {
      printf("- APROVADO\n\n");
    }
    else {
      printf("- REPROVADO\n\n");
    }
    mediaAluno = 0;
    somaNotas = 0;
  }

  return 0;
}