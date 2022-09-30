/* Faça um programa para ler 10 valores inteiros. Para cada valor fornecido escrever uma mensagem que indica se cada valor fornecido é PAR ou ÍMPAR.
 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int valores[10], i;
  for (i = 0; i <10; i++) {
    printf("Digite o %dº valor: ", i+1);
    scanf("%d%*c", &valores[i]);
  }

  printf("\n");
  for (int aux = 0; aux < i; aux++) {
    if (valores[aux] % 2 == 0) {
       printf("Número %d - PAR\n", valores[aux]);
    }
    else {
       printf("Número %d - IMPAR\n", valores[aux]);
    }
  }
  printf("\n");
  return 0;
}