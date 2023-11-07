import java.util.Arrays;

public class Biblioteca {
    private Livro[] livros;

    public Biblioteca(int quantidadeLivros) {
        this.livros = new Livro[quantidadeLivros];
    }

    public boolean insereLivro(Livro novoLivro) {
        for(int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                livros[i] = novoLivro;
                return true;
            }
        }

        return false;
    }

    public Livro procuraLivroPorTitulo(String titulo) {
        for(int i = 0; i < livros.length; i++) {
            Livro livro = livros[i];

            if (livro == null) {
                return null;
            }

            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }

        return null;
    }

    public double verificaDescontro(String titulo) {
        Livro l = procuraLivroPorTitulo(titulo);

        if (l instanceof Novo) {
            return ((Novo) l).getDesconto();
        }

        return -1;
    }

    public void imprimeEdicoes() {
        for(int i = 0; i < livros.length; i++) {
            Livro livro = livros[i];

            if (livro == null) {
                return;
            }

            if (livro instanceof Antigo) {
                System.out.printf("Livro: %s - %d° edição%n", livro.getTitulo(), ((Antigo) livro).getEdicao());
            }
        }
    }

    public void imprimeLivroPorAno() {
        Livro[] rearranged = new Livro[livros.length];

        for (int i = 0; i < livros.length; i++) {
            rearranged[i] = livros[i];
        }

        for (int i = 0; i < rearranged.length - 1; i++) {
            for (int j = 0; j < rearranged.length - i - 1; j++) {
                if (rearranged[j] == null || rearranged[j + 1] == null) {
                    continue;
                }

                if (rearranged[j].getAnoDeCriacao() < rearranged[j + 1].getAnoDeCriacao()) {
                    Livro temp = rearranged[j + 1];
                    rearranged[j + 1] = rearranged[j];
                    rearranged[j] = temp;
                }
            }
        }

        for (int i = 0; i < rearranged.length; i++) {
            Livro l = rearranged[i];

            if (l != null){
                System.out.printf("Livro %s - ano %d%n", l.getTitulo(), l.getAnoDeCriacao());
            }
        }
    }

    public double calculaMediaPreco() {
        double total = 0;

        for (int i = 0; i < livros.length; i++) {
            total += livros[i].getPreco();
        }

        return total / livros.length;
    }

    public Livro livroComMaiorTitulo() {
        if (livros[0] == null) {
            return null;
        }

        Livro maior = livros[0];

        for (int i = 1; i < livros.length; i++) {
            Livro current = livros[i];

            if (maior.getTitulo().length() < current.getTitulo().length()) {
                maior = current;
            }
        }

        return maior;
    }

    public Livro[] getLivros() {
        return livros;
    }

    public void setLivros(Livro[] livros) {
        this.livros = livros;
    }

    @Override
    public String toString() {
        return "Biblioteca{" +
                "livros=" + Arrays.toString(livros) +
                '}';
    }
}
