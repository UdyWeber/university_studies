#include <signal.h>
#include <stdio.h>
#include <unistd.h>

static int count = 0;

void handler(int sig) {
  printf("Coé mané vai me parar não em, com esse sinalzin ai %d\n", sig);
  count++;
}

void call_brother() {
  printf("Meu irmão vai te dar um porradão na proxima");
  signal(SIGINT, SIG_DFL);
}

int main(void) {
  struct sigaction sig;

  sig.sa_handler = handler;
  // Setta mascara para tratar o sinais independentes
  sigemptyset(&sig.sa_mask);
  sig.sa_flags = 0;

  // Define signal SIGINT the action to take is defined above, and the action
  // before is NULL
  sigaction(SIGINT, &sig, NULL);

  while (1) {
    sleep(1);
    printf("Tenta me parar ai otario\n");
    if (count == 2) {
      call_brother();
    }
  }

  return 0;
}
