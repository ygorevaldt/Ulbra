/* Ler uma quantidade indeterminada de duplas de valores (2 valores de cada vez). Escrever para cada dupla uma mensagem que indique se ela foi informada em ordem crescente ou decrescente. A repetição será encerrada ao ser fornecido, para os elementos da dupla, valores iguais.

[Para os dados de entrada abaixo]
[Deve ser gerada a seguinte saída]
5   4
7   2
3   8
2   2
Decrescente
Decrescente
Crescente */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <conio.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int valorUm, valorDois;
  
  while(valorUm != valorDois){
    printf("Digite dois números inteiros: ");
    scanf("%d%*c %d%*c", &valorUm, &valorDois);
    if (valorUm < valorDois){
      printf("%d  %d - Ordem crescente\n", valorUm, valorDois);
    }
    else if (valorUm > valorDois) {
      printf("%d  %d - Ordem decrescente\n",valorUm, valorDois);
    }
    else if (valorUm == valorDois) {
      printf("Números iguais.\nFim do algoritimo.\n");
      break;
    }
  }
  return 0;
}