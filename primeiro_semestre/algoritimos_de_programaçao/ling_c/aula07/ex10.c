#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float precoFabrica, precoConsumidor;
  int imposto, porcentagemDistribuidor;

  printf("Valor do custo de fábrica do veículo: $");
  scanf("%f%*c", &precoFabrica);

  if (precoFabrica < 12000) {
    porcentagemDistribuidor = precoFabrica * 5 / 100;
    precoConsumidor = precoFabrica + porcentagemDistribuidor;
    printf("Preço do veículo para o consumidor: $%.2f\n", precoConsumidor);
  }
  else if (precoFabrica >= 12000 || precoFabrica <= 25000) {
    porcentagemDistribuidor = precoFabrica * 10 / 100;
    imposto = precoFabrica * 15 / 100;
    precoConsumidor = precoFabrica + porcentagemDistribuidor + imposto;
    printf("Preço do veículo para o consumidor: $%.2f\n", precoConsumidor);
  }
  else {
    porcentagemDistribuidor = precoFabrica * 15 / 100;
    imposto = precoFabrica * 20 / 100;
    precoConsumidor = precoFabrica + porcentagemDistribuidor + imposto;
    printf("Preço do veículo para o consumidor: $%.2f\n", precoConsumidor);
  }
  return 0;
  }
