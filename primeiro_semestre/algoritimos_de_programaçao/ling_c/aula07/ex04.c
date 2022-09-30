#include <stdio.h>
#include <stdlib.h>
#include <windows.h>

int main() {
  UINT CPAGE_UTF8 = 65001;
  SetConsoleOutputCP(CPAGE_UTF8);

  int i, c;
  float numbers[3] = {}, biggestNumber;
  for (i = 0; i < 3; i++) {
    printf("Digite o %dº número: ", (i+1));
    scanf("%f%*c", &numbers[i]);
    }
  biggestNumber = numbers[0];
  if (numbers[1] > biggestNumber) {
    biggestNumber = numbers[1];
  }
  if (numbers[2] > biggestNumber) {
    biggestNumber = numbers[2];
  }
  printf("O maior número digitado foi: %.1f", biggestNumber);
  return 0;
}
