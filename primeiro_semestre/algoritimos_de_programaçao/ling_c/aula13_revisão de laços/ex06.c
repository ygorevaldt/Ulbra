/* Faça um programa que verifique a validade de uma senha fornecida pelo usuário. A senha válida é o número 1234.
Se a senha informada pelo usuário for inválida, a mensagem "ACESSO NEGADO" deve ser impressa e repetida a solicitação de uma nova senha até que ela seja válida. Caso contrário deve ser impressa a mensagem "ACESSO PERMITIDO" junto com um número que representa quantas vezes a senha foi informada.*/

#include <stdio.h>
#include <stdlib.h>
#include <windows.h>
#define SENHA_CORRETA 1234

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int contador = 0, senha;
  while (senha != SENHA_CORRETA){
    printf("Digite a sua senha: ");
    scanf("%d%*c", &senha);
    if (senha == SENHA_CORRETA) {
      printf("[%d] - ACESSO PERMITIDO\n", (contador+1));
      break;
    }
    printf("ACESSO NEGAGO\n");
    contador++;
  }
  return 0;
}