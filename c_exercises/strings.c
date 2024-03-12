#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define INPUT_LEN 100

int main() {
  char key[] = "chave:";
  char input[INPUT_LEN];

  printf("Digite uma palavra:");
  scanf("%s", input);

  if (strlen(input) > (INPUT_LEN - strlen(key))) {
    printf("[ERRO]: String maior que o devido!!\n");
    exit(EXIT_FAILURE);
  }

  // char new_key[strlen(key) + strlen(input)];
  // strcpy(new_key, key);

  strcat(key, input);
  int cmp = strcmp("chave:jobson", key);

  if (cmp == 0) {
    printf("[SUCESSO] Desbloqueou o final secreto\n");
  } else if (cmp < 0) {
    printf("[INFO] O input é lexicograficamente inferior a chave\n");
  } else {
    printf("[INFO] O input é lexicograficamente superior a chave\n");
  }

  return 0;
}
