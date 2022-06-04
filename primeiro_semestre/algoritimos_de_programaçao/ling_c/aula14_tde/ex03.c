/* 
Ler um conjunto de números reais, armazenando-o em vetor e calcular o quadrado das componentes deste vetor, armazenando o resultado em outro vetor. Os conjuntos têm 10 elementos cada. Imprimir todos os conjuntos. 
 */

#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  
  float numeros_digitados[10] = {}, numeros_digitados_ao_quadrado[10] = {};

  for (int i = 0 ; i < 10 ; i++){
    printf("%dº Valor: ", i+1);
    scanf("%f%*c", &numeros_digitados[i]);
  }

  for (int i = 0 ; i < 10 ; i++){
    numeros_digitados_ao_quadrado[i] = numeros_digitados[i] * numeros_digitados[i];
  }

  printf("Os números digitados foram: ");
  for (int i = 0 ; i < 10 ; i++){
    printf("%.2f ", numeros_digitados[i]);
  }
  printf("\nOs números digitados ao quadrado são: ");
  for (int i = 0 ; i < 10 ; i++){
    printf("%.2f ", numeros_digitados_ao_quadrado[i]);
  }
  printf("\n");
  return 0;
}