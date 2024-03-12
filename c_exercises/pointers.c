#include <stdio.h>

int main() {
  float x = 3.5, y;
  float *p;

  p = &x;
  y = *p;

  printf("O valor de x, apontado por *p é: %.2f\n", y);
}
