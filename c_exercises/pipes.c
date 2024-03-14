#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <sys/wait.h>
#include <unistd.h>

int main(void) {
  int file_descriptors[2];
  int bytes_processed;

  if (pipe(file_descriptors) != 0) {
    printf("Could not pipe\n");
    exit(EXIT_FAILURE);
  }

  switch (fork()) {
  case -1:
    printf("Something went wrong while forking\n");
    exit(EXIT_FAILURE);
    break;
  case 0:
    // Fechando o STDIN
    close(0);

    // Duplicando o file descriptor do pipe e jogando ele para a menor posição
    // disponivel No caso agora, o conteudo do file_pipes[0] é o STDIN
    dup(file_descriptors[0]);

    // Cria um buffer de 1024 posições
    char buffer[BUFSIZ + 1];
    // Setta todos as posições como null
    memset(buffer, '\0', BUFSIZ * sizeof(char));
    // Le o canal do STDIN
    bytes_processed = read(0, buffer, BUFSIZ);

    printf(
        "Filho(PID=%d, PPID=%d): Recebido do meu pai a string %s de %d bytes\n",
        getpid(), getppid(), buffer, bytes_processed);

    // Fechando o canal original
    close(file_descriptors[0]);

    printf("Filho(PID=%d, PPID=%d): Passando agora a string pra hexadecimal\n",
           getpid(), getppid());

    write(file_descriptors[1], buffer, strlen(buffer));
    close(file_descriptors[1]);

    // Trocar o processo, pega os dados do STDIN e faz um pipe pro novo processo
    execlp("/bin/od", "od", "-t", "x1", NULL);

    exit(EXIT_FAILURE);
    break;
  default:
    // Fechando o pipe de leitura
    close(file_descriptors[0]);

    // Escrevendo uma mensagem para o pipe de escrita
    const char message[] = "Jolistest";
    bytes_processed = write(file_descriptors[1], message, strlen(message));
    printf("PAI(PID=%d): Escreveu %d bytes para o canal de escrita\n", getpid(),
           bytes_processed);
    // Fechando os pipes
    close(file_descriptors[1]);
    wait(NULL);
    exit(EXIT_SUCCESS);
  }
}
