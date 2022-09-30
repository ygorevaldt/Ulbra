#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int numeros[2], numero1, numero2, i, opcao, resultado;
  printf("Digite dois números:\n");
  for (i = 0; i < 2; i++) {
    printf("%dº número: ", (i+1));
    scanf("%d%*c", &numeros[i]);
  }
  numero1 = numeros[0];
  numero2 = numeros[1];
  printf("Suas opções são:\n");
  printf("1. O 1º número elevado ao 2º número.\n");
  printf("2. Raiz quadrada de cada um dos números.\n");
  printf("3. Raiz cúbica de cada um dos números.\n");
  printf("Sua opção: ");
  scanf("%d%*c", &opcao);
  if (opcao > 3 || opcao <= 0) {
    printf("Opção inválida");
  }
  switch(opcao) {
    case 1: 
      resultado = pow(numero1, numero2);
      printf("Resultado: %d", resultado);
      break;
    case 2:
      printf("Raiz quadrada de %d é: ", numero1);
      numero1 = sqrt(numero1);
      printf("%d\n",numero1);
      printf("Raiz quadrada de %d é: ", numero2);
      numero2 = sqrt(numero2);
      printf("%d\n",numero2);
      break;
    case 3:
      printf("Raiz cúbica de %d é: ", numero1);
      numero1 = cbrt(numero1);
      printf("%d\n",numero1);
      printf("Raiz cubica de %d é: ", numero2);
      numero2 = cbrt(numero2);
      printf("%d\n",numero2);
      break;
  }
  return 0;
}
