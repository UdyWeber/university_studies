/**
 * Classe auxiliar para colorir as impressões feitas no terminal
 *
 * Cada valor do Enum tem consigo a representação da cor em String Unicode assim quando printado o valor do Enum
 * o valor em Unicode substitui o valor.
 */
public enum Cores {
    AMARELO("\u001B[33m"),
    ROXO("\u001B[35m"),
    BRANCO("\u001B[37m"),
    VERMELHO("\u001B[31m"),
    VERDE("\u001B[32m");

    private final String representacaoEmString;

    Cores(String representacaoEmString) {
        this.representacaoEmString = representacaoEmString;
    }

    public String toString() {
        return this.representacaoEmString;
    }
}
