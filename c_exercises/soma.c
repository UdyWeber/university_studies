#include <stdio.h>

int main(void) {
  int a, b, c;

  printf("Digite o primeiro número da soma:");
  scanf("%d", &a);

  printf("Digite o segundo número da soma:");
  scanf("%d", &b);

  c = a + b;
  printf("The sum of the number %d + %d = %d\n", a, b, c);
  return 0;
}
