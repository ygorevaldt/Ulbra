#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float numeros[3] = {}, temp;
  int i = 0, I, aux;
  float A, B, C;
  printf("Digite respectivamente 3 valores reais para as letras A, B, C:\n");
  while (i < 3){
    printf("Digite o %dº valor: ", (i+1));
    scanf("%f%*c", &numeros[i]);
    i++;
  }
  i = 0;
  printf("Digite um valor inteiro para I:\n");
  while (i < 3) {
    printf("(%d)\n", (i+1));
    i++;
  }
  printf("Qual a sua opção: ");
  scanf("%d%*c", &I);

  A = numeros[0], B = numeros[1], C = numeros[2];
  if (I == 1){
    if (A > B) {
      temp = A;
      A = B;
      B = temp;
    }
    if (A > C) {
      temp = A;
      A = C;
      C = temp;
    }
    if (B > C) {
      temp = B;
      B = C;
      C = temp;
    }
  printf("Opção %d =  %.1f, %.1f, %.1f", I, A, B, C);
  }
  if (I == 2) {
    if (A < B) {
      temp = A;
      A = B;
      B = temp;
    }
    if (A < C) {
      temp = A;
      A = C;
      C = temp;
    }
    if (B < C) {
      temp = B;
      B = C;
      C = temp;
    }
    printf("Opção %d =  %.1f, %.1f, %.1f", I, A, B, C);
  }
  if (I == 3) {
    if (A > B) {
      temp = A;
      A = B;
      B = temp;
    }
    if (B < C) {
      temp = B;
      B = C;
      C = temp;
    }
    printf("Opção %d =  %.1f, %.1f, %.1f", I, A, B, C);
  }
  return 0;
}