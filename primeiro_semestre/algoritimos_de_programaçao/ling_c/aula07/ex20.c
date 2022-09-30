#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  char nomeNadador[20];
  int idadeNadador;
  printf("Nome do nadador: ");
  gets(nomeNadador);
  printf("Idade: ");
  scanf("%d%*c", &idadeNadador);
  if (idadeNadador < 5) {
    printf("%s tem %d anos e não se enquadra em nenhuma categoria.\n", nomeNadador, idadeNadador);
  }
  else if (idadeNadador >= 5 && idadeNadador <= 7) {
    printf("O nadador %s tem %d anos e está na categoria: INFANTIL.\n", nomeNadador, idadeNadador);
  }
  else if (idadeNadador >=8 && idadeNadador <= 10) {
    printf("O nadador %s tem %d anos e está na categoria: JUVENIL.\n", nomeNadador, idadeNadador);
  }
  else if (idadeNadador >=11 && idadeNadador <= 15) {
    printf("O nadador %s tem %d anos e está na categoria: ADOLESCENTE.\n", nomeNadador, idadeNadador);
  }
  else if (idadeNadador >=16 && idadeNadador <= 30) {
    printf("O nadador %s tem %d anos e está na categoria: ADULTO.\n", nomeNadador, idadeNadador);
  }
  else {
    printf("O nadador %s tem %d anos e está na categoria: SÊNIOR.\n", nomeNadador, idadeNadador);
  }
 return 0;
}