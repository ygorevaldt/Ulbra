/* Faça um algoritmo que leia a nota de vários alunos de uma turma. Ao final, deve ser escrita a média geral da turma. A leitura das médias somente encerra quando uma nota negativa for digitada. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float nota, somaNotas = 0, mediaTurma;
  int i = 0;

  while(nota > 0) {
    printf("%dº Nota: ", i+1);
    scanf("%f%*c", &nota);
    while(nota < 0) {
      printf("Nota inválida, digite novamente.\n %dº nota: ", i+1);
    }
    somaNotas += nota;
    i++;
  }
  mediaTurma = somaNotas / (i-1);
  printf("A média geral da turma é: %.1f\n", mediaTurma);
}