#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
    UINT CPAGE_UTF8 = 65001;
    SetConsoleOutputCP(CPAGE_UTF8);

    int vetorNumeros[5] = {};
    int soma = 0, i = 0;
    printf("Digite 5 números inteiros:\n");

    for (i; i < 5; i++){
        printf("%dº número: ", (i+1));
        scanf("%d%*c", &vetorNumeros[i]);
        soma += vetorNumeros[i];
    }
    for (int c = 0; c < 5; c++){
        if (c == 4) {
            printf("%d = ", vetorNumeros[c]);
            break;
        }
    printf("%d + ", vetorNumeros[c]);
    }
    
    printf("%d", soma);
    return 0;
}
