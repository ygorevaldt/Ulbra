/* Ler dois valores inteiros e escrever o resultado da divisão do primeiro pelo segundo. Se o segundo valor informado for ZERO, deve ser impressa uma mensagem de VALOR INVÁLIDO e ser lido um novo valor. Ao final do programa deve ser impressa a seguinte mensagem: VOCE DESEJA OUTRO CÁLCULO (S/N).  Se a resposta for S o programa deverá retornar ao começo, caso contrário deverá encerrar a sua execução imprimindo quantos cálculos foram feitos. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int contador = 1, valorUm, valorDois, divisao;
  char resposta[5];

  while(valorUm > 0 && valorDois > 0) {
    printf("Digite um valor: ");
    scanf("%d%*c", &valorUm);
    printf("Digite outro valor: ");
    scanf("%d%*c", &valorDois);
    while(valorDois <= 0) {
      printf("Valor inválido.\nDigite outro valor: ");
      scanf("%d%*c", &valorDois);
    }
    divisao = abs(valorUm / valorDois);

    printf("%d dividido por %d é igual a: %d\n", valorUm, valorDois, divisao);
    printf("Você deseja outro calculo [S/N]? ");
    gets(resposta);
    if (strcasecmp(resposta, "N") == 0) {
      printf("Foram feitos %d calculos.\nFim do algoritimo\n", contador);
      break;
    }
    contador++;
  }
  return 0;
}