#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float primeiroNumero, segundoNumero, diferenca;
  printf("\nDigite um número: ");
  scanf("%f%*c", &primeiroNumero);
  printf("Digite mais um número: ");
  scanf("%f%*c", &segundoNumero);

  diferenca = abs(primeiroNumero - segundoNumero);
  printf("\nA diferença do maior número para o menor número digitado é de: %.1f\n\n", diferenca);
  return 0;
}