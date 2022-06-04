#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <ctype.h>

int main() {
  UINT CPGAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPGAGE_UTF8);

  int i = 0;
  float numeros[2] = {}, media, difMaiorMenor, produto, divisao;
  while (i < 2){
    printf("Digite o %dº número: ", i+1);
    scanf("%f%*c", &numeros[i]);
    i++;
    if (isdigit(numeros[i])) {
      printf("Digite o %d número: ", i+1);    
    }
  }
  int opcaoUsuario = 1, choice;
  printf("Opções: \n");
  while (opcaoUsuario < 5){
    printf("(%d) - Média entre os números digitados.\n", opcaoUsuario);
    opcaoUsuario++;
    printf("(%d) - Diferença do maior pelo menor.\n", opcaoUsuario);
    opcaoUsuario++;
    printf("(%d) - Produto entre os números digitados.\n", opcaoUsuario);
    opcaoUsuario++;
    printf("(%d) - Divisão do primeiro pelo segundo.\n", opcaoUsuario);
    opcaoUsuario++;
  }
  printf("Digite a sua opção: ");
  scanf("%d%*c", &choice);
  if (choice > 4) {
    printf("Opção inválida\n");
  }
  /*Calculando média*/
  if (choice == 1) {
    media = (numeros[0] + numeros[1]) / i;
    printf("Resultado: %.1f\n", media);
  }
  /*Calculando diferença do maior pelo menor*/
  else if (choice == 2) {
    if (numeros[0] > numeros[1]){
      difMaiorMenor = numeros[0] - numeros[1];
    }
    else {
      difMaiorMenor = numeros[1] - numeros[0];
    }
    printf("Resultado: %.1f\n", difMaiorMenor);
  }
  /*Calculando produto*/
  else if (choice == 3) {
    produto = numeros[0] * numeros[1];
    printf("Resultado: %.1f\n", produto);
  }
  /*Divisão entre os números*/
  else if (choice == 4) {
    if (numeros[1] == 0) {
      printf("ERRO! O segundo número não pode ser 0\n");
    }
    else {
      divisao = numeros[0] / numeros[1];
      printf("Resultado: %.1f\n", divisao);
    }
  }
  return 0;  
}