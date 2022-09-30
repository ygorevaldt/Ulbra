#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
    UINT CPAGE_UTF8 = 65001;
    SetConsoleOutputCP(CPAGE_UTF8);

    int vetor[10] = {};
    int vetorPares[] = {};
    int vetorImpares[] = {};
    int i = 0;

    for (i; i < 10; i++) {
        printf("%dº número: ", i+1);
        scanf("%d%*c", &vetor[i]);
    }
    printf("Números Pares: ");
    for (int c = 0; c < i; c++) {
        if (vetor[c] % 2 == 0) {
            vetorPares[c] = vetor[c];
            printf("%d ", vetorPares[c]);
        }
    }
    printf("\nNúmeros Imares: ");
    for (int c = 0; c < i; c++) {
        if (vetor[c] % 2 != 0) {
            vetorImpares[c] = vetor[c];
            printf("%d ", vetorImpares[c]);
        }
    }
    
    return 0;
    
}