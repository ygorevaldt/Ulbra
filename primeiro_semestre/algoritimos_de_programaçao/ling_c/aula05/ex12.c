#include <stdio.h>
#include <stdlib.h>
#include <math.h>
#include <windows.h>

int main() {
  /*Código para mostrar caracteries especiais no console.*/
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);
  int numero1, numero2;

  printf("digite um número maior que zero: ");
  scanf("%d%*c", &numero1);
  /*Validando número recebido*/
  while(numero1 <= 0) {
    printf("Número inválido\n");
    printf("digite um número maior que zero: ");
    scanf("%d%*c", &numero1);
  }
  printf("digite outro número: ");
  scanf("%d%*c", &numero2);
  /*Validando número recebido*/
  while(numero2 <= 0) {
    printf("Número inválido\n");
    printf("digite um número maior que zero: ");
    scanf("%d%*c", &numero2);
  }
  
  int resultado = pow(numero1, numero2);
  printf("Os número %d elevado ao número %d é igual a: %d\n", numero1, numero2, resultado);
  return 0;
}
