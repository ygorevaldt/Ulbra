#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  float preco, percAumento, imposto;
  int categoria, i;
  char situacao[10];

  printf("Preço do produto: $");
  scanf("%f%*c", &preco);

  printf("Categorias:\n");
  printf("1 - Limpeza\n2 - Alimentação\n3 - Vestuário\n");
  printf("Categoria do produto: ");
  scanf("%d%*c", &categoria);

  printf("Situação:\n[R] - Refrigerado\n[N] - Não refrigerado\nSituação do produto: ");
  gets(situacao);

  if (strcasecmp(situacao, "R") == 0 || categoria == 2){
    imposto = preco * 5 / 100;
  }
  else {
    imposto = preco * 8 / 100;
  }

  if (preco <= 25){
    switch (categoria) {
      case 1:
        percAumento = preco * 5 / 100;  
        preco = (preco + percAumento) - imposto;
        printf("Aumento de $%.2f\n", percAumento);
        break;
      case 2:
        percAumento = preco * 8 / 100;
        preco = (preco + percAumento) - imposto;
        printf("Aumento de $%.2f\n", percAumento);
        break;  
      default:
        percAumento = preco * 10 / 100;
        preco = (preco + percAumento) - imposto;
        printf("Aumento de $%.2f\n", percAumento);
        break;  
    }
    printf("Preço final $");
        if (preco <= 50) {
          printf("%.2f - BARATO", preco);
        }
        else if (preco > 50 && preco <= 120) {
          printf("%.2f - NORMAL", preco);
        }
        else {
          printf("%.2f - CARO", preco);
        }
  }
  else if (preco > 25){
    switch (categoria) {
      case 1:
        percAumento = preco * 12 / 100;
        preco = (preco + percAumento) - imposto;
        printf("Aumento de $%.2f\n", percAumento);
        break;
      case 2:
        percAumento = preco * 15 / 100;
        preco = (preco + percAumento) - imposto;
        printf("Aumento de $%.2f\n", percAumento);
        break;  
      default:
        percAumento = preco * 18 / 100;
        preco = (preco + percAumento) - imposto;
        printf("Aumento de $%.2f\n", percAumento);
        break;
    }
    printf("Preço final $");
        if (preco <= 50) {
          printf("%.2f - BARATO", preco);
        }
        else if (preco > 50 && preco <= 120) {
          printf("%.2f - NORMAL", preco);
        }
        else {
          printf("%.2f - CARO", preco);
        }
  }
  return 0;
}
