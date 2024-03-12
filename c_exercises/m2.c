#include <stdio.h>
#include <stdlib.h>
#include <sys/types.h>
#include <sys/wait.h>
#include <unistd.h>

#define MATRIX_SIZE 10
#define SITE_TO_SEARCH "https://www.bbc.com/portuguese"

int **create_and_populate_matrix() {
  int i, j;
  // Aloca na memoria dinamica um ponteiro de ponteiros de int
  int **matrix = (int **)malloc(MATRIX_SIZE * sizeof(int *));

  // Aloca memoria dinamica para cada ponteiro de ints
  for (i = 0; i < MATRIX_SIZE; i++) {
    matrix[i] = (int *)malloc(MATRIX_SIZE * sizeof(int));
  }

  // Popula a matriz
  for (i = 0; i < MATRIX_SIZE; i++) {
    for (j = 0; j < MATRIX_SIZE; j++) {
      matrix[i][j] = 1 * i * (j - 3);
    }
  }

  return matrix;
}

void free_matrix(int **matrix) {
  // Aqui libertamos a memoria alocada para cada ponteiro dentro do ponteiro de
  // ponteiros
  for (int i = 0; i < MATRIX_SIZE; i++) {
    free(matrix[i]);
  }
  // Aqui libertamos a memória do ponteiro da matriz
  free(matrix);
}

void transpose_matrix(int **matrix) {
  int i, j;
  // Cria uma matriz auxiliar para jogarmos os valores dentro
  int other[MATRIX_SIZE][MATRIX_SIZE];

  // Começamos a transferir os valores da linha da matriz original pras colunas
  // da matriz auxiliar
  for (i = 0; i < MATRIX_SIZE; i++) {
    for (j = 0; j < MATRIX_SIZE; j++) {
      other[j][i] = matrix[i][j];
    }
  }

  // Voltamos os dados para dentro da matriz original
  for (i = 0; i < MATRIX_SIZE; i++) {
    for (j = 0; j < MATRIX_SIZE; j++) {
      matrix[i][j] = other[i][j];
    }
  }
}

void print_matrix(int **matrix) {
  for (int i = 0; i < MATRIX_SIZE; i++) {
    for (int j = 0; j < MATRIX_SIZE; j++) {
      printf("%4d ", matrix[i][j]);
    }

    printf("\n");
  }
}

int main(void) {
  // Usei uma matriz com ponteiros para poder splitar o código em funções
  // diferentes
  int **matrix;
  pid_t pid;

  switch ((pid = fork())) {
  case -1:
    printf("Algo deu errado ao criar o processo filho\n\n");
    exit(-1);
    break;
  case 0:
    printf("Filho(PID=%d,PPID=%d): Fui criado pelo meu pai para contar quantas "
           "vezes a palavra guerra aparece, no site %s, vamos começar a "
           "contar...\n\n",
           getpid(), getppid(), SITE_TO_SEARCH);

    // Um pequeno hackzinho para ser possivel printar uma mensagem bonitinha
    // na tela para termos contexto que a busca foi realizada
    char message[300];
    sprintf(message,
            "echo \"Filho(PID=%d, PPID=%d): Encontrei a palavra guerra no site "
            "%s esse tanto de vezes: $(curl -s %s | egrep -o guerra | wc -l)\"",
            getpid(), getppid(), SITE_TO_SEARCH, SITE_TO_SEARCH);
    execlp("/bin/sh", "sh", "-c", message, NULL);

    break;
  default:
    printf("Pai(PID=%d): Esperando meu filho(PID=%d) finalizar o processo para "
           "começar o meu...\n\n",
           getpid(), pid);
    wait(NULL);

    // Cria nossa matriz
    matrix = create_and_populate_matrix();

    printf(
        "\nPai(PID=%d): Agora que meu filho terminou de executar vou transpor "
        "uma matriz!!\n\n",
        getpid());

    printf("Matriz Original\n");
    // Printa a matriz original
    print_matrix(matrix);

    // Transpoe a matriz
    transpose_matrix(matrix);

    printf("\nMatriz Transposta\n");
    // Printa a matriz transposta
    print_matrix(matrix);

    // Liberta a memoria da matriz
    free_matrix(matrix);
  }

  return 0;
}
