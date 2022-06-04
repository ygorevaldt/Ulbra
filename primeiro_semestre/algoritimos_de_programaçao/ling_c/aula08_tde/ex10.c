/* Faça um programa para determinar se uma pessoa é maior ou menor de idade. Mostre também se ela já está apta a votar de forma obrigatória ou facultativa.  Conforme a Justiça eleitoral o voto é obrigatório para os eleitores com idade acima de 18 anos e facultativo para os analfabetos, para os eleitores maiores de 16 e menores de 18 anos, assim como para os maiores de 70 anos. */

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define MAIOR_IDADE 18

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  
  int idade;
  char alfabetizado[10];
  printf("Digite sua idade: ");
  scanf("%d%*c", &idade);
  printf("Alfabetizado - [S/N]: ");
  gets(alfabetizado);
  while(idade <= 0) {
    printf("Idade inválida\nDigite sua idade novamente: ");
    scanf("%d%*c", &idade);
  }

  if (idade >= MAIOR_IDADE) {
    if (idade >= 70 ){
      printf("Você tem %d anos\nVoto - Facultativo", idade);
    } 
    else {
      printf("Você tem %d anos - Maior de idade\nVoto - Obrigatório\n", idade);
    }
  }
  else if (idade < MAIOR_IDADE && idade >= 16 && strcmp(alfabetizado, "N") == 0){
    printf("Você tem %d anos - Menor de idade\nAnalfabeto\nVoto - Facultativo", idade);
  }  

  return 0;
}