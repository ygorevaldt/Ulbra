/*
  6-Faça um programa para ler 10 números DIFERENTES a serem armazenados em um vetor.
  Os dados deverão ser armazenados no vetor na ordem que forem sendo lidos.
  Caso o usuário digite um número que já foi digitado anteriormente, o programa devera pedir para ele digitar outro número. 
  Note que cada valor digitado pelo usuário deve ser pesquisado no vetor, verificando se ele existe entre os números que já foram fornecidos. 
  Exibir na tela o vetor final digitado.
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define TAM_VETOR 5

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i;
  int x;
  int v1[TAM_VETOR] = {};
  int v2[TAM_VETOR] = {};

  for(i = 0; i < TAM_VETOR; i++){
    printf("Insira um valor: ");
    scanf("%d%*c", &v1[i]);
    for(x = 0; x < TAM_VETOR; x++){
      if(v2[x] == v1[i]){
        printf("Número repetido.\n");
        printf("Por favor, digite outro numero: ");
        scanf("%d%*c", &v1[i]);
      }
      v2[x] = v1[i];
    }
  }

  printf("Valores presentes no vetor: ");
  for(i = 0; i < TAM_VETOR; i++){
    printf("%d ", v1[i]);
  }

  return 0;
}
