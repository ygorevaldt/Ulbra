/* 
 Faça um programa que receba do usuário um vetor com 10 posições. Em seguida, deverá ser impresso o maior e o menor elemento do vetor. 
*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

    int numeros[10];
    int i,maior,menor;
     for (i = 0; i < 10; i++){
      printf("Digite %dº valor: ", i + 1);
      scanf("%d%*c", &numeros[i]);
    }   
    maior = numeros[0];
    menor = numeros[0];
    for(i = 0 ; i < 10 ; i++){
      if(maior < numeros[i]){
          maior = numeros[i];
      }
      if (menor > numeros[i]){
          menor = numeros[i];
      }
    }
      printf("O Maior é : %d\n",maior);
      printf("O Menor é : %d\n",menor);
  return 0;
}