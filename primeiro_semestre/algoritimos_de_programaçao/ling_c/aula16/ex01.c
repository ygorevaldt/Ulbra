/* 
1-Faça um programa que leia 10 números inteiros, armazene-os em um vetor, solicite um valor de referência inteiro e: 
a) imprima os números do vetor que são maiores que o valor referência 
b) retorne quantos números armazenados no vetor são menores que o valor de referência 
c) retorne quantas vezes o valor de referência aparece no vetor
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_VETOR 10

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetorNumeros[TAM_VETOR] = {};
  int valorReferencia;
  for (int i = 0; i < TAM_VETOR; i++) {
    printf("%dº Número: ", i+1);
    scanf("%d%*c", &vetorNumeros[i]);
  }
  printf("Digite um número inteiro de referência: ");
  scanf("%d%*c", &valorReferencia);

  printf("A) Números digitados maiores que %d: ", valorReferencia);
  for (int i = 0; i < TAM_VETOR; i++) {
    if(vetorNumeros[i] > valorReferencia) {
      printf("%d ", vetorNumeros[i]);
    }
  }

  printf("\nB) Quantidade de números menores que %d: ", valorReferencia);
  int soma = 0;
  for (int i = 0; i < TAM_VETOR; i++) {
    if(vetorNumeros[i] < valorReferencia) {
      soma++;
    }
  }
  printf("%d", soma);

  printf("\nC) Quantidade de vezes que %d aparece no vetor: ", valorReferencia);
  soma = 0;
  for (int i = 0; i < TAM_VETOR; i++) {
    if(vetorNumeros[i] == valorReferencia) {
      soma++;
    }
  }
  printf("%d", soma);

  return 0;
}