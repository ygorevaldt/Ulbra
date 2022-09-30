/* Faça um programa para ler uma quantidade indeterminada de valores inteiros. Para cada valor fornecido escrever uma mensagem que indica se cada valor fornecido é PAR ou ÍMPAR. O programa será encerrado imediatamente após a leitura de um valor NULO (zero) ou NEGATIVO.
 */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int valorInteiro;
  while(valorInteiro > 0) {
    printf("Digite um valor: ");
    scanf("%d%*c", &valorInteiro);
    if (valorInteiro == 0 || valorInteiro < 0) {
      printf("fim do algoritimo.\n");
      break;
    }
    else if (valorInteiro % 2 == 0) {
      printf("O valor %d é PAR\n", valorInteiro);
    }
    else if (valorInteiro % 2 != 0) {
      printf("O valor %d é IMPAR\n", valorInteiro);
    }
  }
  return 0;
}