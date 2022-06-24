#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#include <string.h>
#define TAM_PALAVRA 100

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  char palavra[TAM_PALAVRA] = {};
  int soma = 0;
  int quantidadeLetras;

  printf("Digite uma palavra: ");
  gets(palavra);
  quantidadeLetras = strlen(palavra);

  for(int i = 0; i < strlen(palavra); i++){
    switch (palavra[i])
    {
    case 'A':
    case 'a':
      soma++;
      break;

    case 'E':
    case 'e':
      soma++;
      break;

    case 'I':
    case 'i':
      soma++;
      break;
      
    case 'O':
    case 'o':
      soma++;
      break;

    case 'U':
    case 'u':
      soma++;
      break;  
    case ' ':
      quantidadeLetras--;
      break;
    }
  }
  printf("Quantidade de vogais que compões a palavra digitada: %d\n", soma);
  printf("Quantidade de letras da palavra digitada: %d\n", quantidadeLetras);

  return 0;
}