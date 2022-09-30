/* Efetue um programa que leia a nota de 10 alunos de uma turma. Ao final, deve ser escrita a média geral da turma. Esse algoritmo deve ser feito duas vezes uma usando o FOR, e DO-WHILE */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  printf("\n=-=-= LAÇO FOR =-=-=\n");
  float somaNotas = 0, notas, c, media;
  for (int i = 0; i < 10; i++) {
    printf("Digite a %dº nota: ", i+1);
    scanf("%f%*c", &notas);
    somaNotas += notas;
    c++;
  }
  media = somaNotas / c;
  printf("\nA média das notas dos alunos é igual a: %.1f\n", media);

  printf("\n=-=-= LAÇO DO-WHILE =-=-=\n");
  somaNotas = 0, notas = 0, media = 0;
  int i = 0;
  do {
    printf("Digite a %dº nota: ", i+1);
    scanf("%f%*c", &notas);
    somaNotas += notas;
    i++;
  } while(i < 10);
  media = somaNotas / c;
  printf("\nA média das notas dos alunos é igual a: %.1f\n", media);
  return 0;
}