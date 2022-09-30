/* 
Faça um programa para ler a nota da prova de 15 alunos e armazene num vetor, calcule e imprima a média geral.
 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i = 0;
  float soma = 0;
  float mediaDaTurma;
  float notas[15] = {};
  while (i < 15) {
    printf("Digite a nota do %dº aluno: ", i+1);
    scanf("%f%*c", &notas);
    soma += notas[i];
    i++;
  }
  printf("Soma - %.1f", soma);
  printf("\nvalor de i - %d", i);
  mediaDaTurma = soma / i;
  printf("\nA média da turma foi: %.1f", mediaDaTurma);
  return 0;
}