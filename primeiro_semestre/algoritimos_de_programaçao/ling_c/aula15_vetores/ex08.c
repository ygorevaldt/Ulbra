#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#include <conio.h>
#define MEDIA 7
#define TAMANHO 10

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
 
  char alunos[TAMANHO][20] = {"Thais","Ygor","Vinicius","Paulo","Leticia","Daniela","Vitor","Emily","Demétrio","Joaquim"};
  float notas[TAMANHO] = {};
  float notaQueFalta[TAMANHO] = {};
  float maiorNota = 0;
  char melhorAluno[20] = {};
  for (int i = 0; i < TAMANHO; i++) {
    printf("Nota do aluno %s: ", alunos[i]);
    scanf("%f%*c", &notas[i]);
    if (notas[i] > maiorNota) {
      maiorNota = notas[i];
    }

  }
  for (int c = 0; c < TAMANHO; c++) {
    printf("Aluno: %s -  Nota: %.2f\n", alunos[c], notas[c]);
  }
  printf("\nFoi o melhor aluno da turma com nota %.2f", maiorNota);
  for (int i = 0; i < TAMANHO; i++) {
    if (notas[i] < MEDIA) {
      notaQueFalta[i] = 10 - notas[i];
      printf("\nO aluno %s precisar tirar %.2f no exame final para passar", alunos[i], notaQueFalta[i]);
    }
  }
  printf("\n\n");
  return 0;
}
