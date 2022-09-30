#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <math.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i = 0, opcaoUsuario, numeros[2] = {}, soma, raizQuadrada;
  printf("Menu de opções:\n");
  while (i < 2){
    if (i == 0) {
      printf("%d. Somar dois números:\n", (i+1));
    }
    else if (i == 1) {
      printf("%d. Raiz quadrada de um número:\n", (i+1));
    }
    i++;
  }
  i = 0;
  printf("Digite a opção desejada: ");
  scanf("%d%*c", &opcaoUsuario);
  if (opcaoUsuario == 1) {
    printf("digite os dois números para obter a sua soma:\n");
    while (i < 2){
      printf("%dº número: ", (i+1));
      scanf("%d%*c", &numeros[i]);
      i++;
    }
    soma = numeros[0] + numeros[1];
    printf("A soma de %d + %d é: %d", numeros[0], numeros[1], soma);    
  }
  else if (opcaoUsuario == 2) {
    printf("Digite o número para obter sua raiz quadrada: ");
    scanf("%d%*c", &numeros[0]);
    raizQuadrada = sqrt(numeros[0]);
    printf("A raiz quadrada de %d é: %d", numeros[0], raizQuadrada);
  }
  return 0;
}