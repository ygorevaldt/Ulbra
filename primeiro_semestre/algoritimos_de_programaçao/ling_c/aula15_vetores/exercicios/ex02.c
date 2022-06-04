#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int vetor[6] = {};
  int multiplosDeDois[] = {};
  int multiplosDeTres[] = {};
  for (int i = 0 ; i < 6 ; i++) {
    printf("Digite o %dº número: ", i+1);
    scanf("%d%*c", &vetor[i]);
    if (vetor[i] % 2 == 0) {
      multiplosDeDois[i] = vetor[i];
    }
    if (vetor[i] % 3 == 0) {
      multiplosDeTres[i] = vetor[i];
    }
  }
  int tamanhoMultiplosDeDois = sizeof(multiplosDeDois) / 
  printf("Os números multiplos de dois são: ");
  for (int i = 0 ; i < (sizeof(multiplosDeDois) / sizeof(int)) ; i++) {
    printf("%d ", multiplosDeDois[i]);
  }


  return 0;
}