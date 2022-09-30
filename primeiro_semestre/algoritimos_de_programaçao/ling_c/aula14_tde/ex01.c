/* 
Faça um programa que possua um vetor denominado A que armazene 6 números inteiros. O programa deve executar os seguintes passos: 
(a) Atribua os seguintes valores a esse vetor: 1, 0, 5, -2, -5, 7. 
(b) Armazene em uma variável inteira (simples) a soma entre os valores das posições A[0], A[1] e A[5] do vetor e mostre na tela esta soma. 
(c) Modifique o vetor na posição 4, atribuindo a esta posição o valor 100. ˜ 
(d) Mostre na tela cada valor do vetor A, um em cada linha. 
 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int a[6] = {}, i = 0, soma;
  while(i < 6) {
    printf("Valor: ");
    scanf("%d%*c", &a[i]);
    i++;
  }
  printf("\n(a) => ");
  for(i = 0 ; i < 6 ; i++){
    printf(" %d", a[i]);
  }
  soma = a[0] + a[1] + a[5];
  printf("\n(b) => %d", soma);
  a[4] = 100;
  printf("\n(c) => %d", a[4]);
  printf("\n(d) => ");
  for(i = 0 ; i < 6 ; i++){
    printf("%d ", a[i]);
  }
  return 0;
}