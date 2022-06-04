/* Faça um programa para repetir a leitura de um número enquanto o valor fornecido for diferente de 0. Para cada número fornecido, escrever se ele é NEGATIVO ou POSITIVO. Quando o número 0 for fornecido a repetição deve ser encerrada sem escrever mensagem alguma. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numero;
  while(numero != 0) {
    printf("\nDigite um número: ");
    scanf("%d%*c", &numero);
    if (numero == 0) {
      break;
    }
    else if(numero > 0) {
      printf("O número %d é POSITIVO.\n", numero);
    }
    else {
      printf("O número %d é NEGATIVO", numero);
    }
  }
  return 0;
}