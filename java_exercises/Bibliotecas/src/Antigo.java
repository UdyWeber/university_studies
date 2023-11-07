public class Antigo extends Livro {
    private int edicao;

    public Antigo(String titulo, String author, double preco, int anoDeCriacao, int edicao) {
        super(titulo, author, preco, anoDeCriacao);
        this.edicao = edicao;
    }

    public int getEdicao() {
        return edicao;
    }

    public void setEdicao(int edicao) {
        this.edicao = edicao;
    }

    @Override
    public String toString() {
        return String.format(
                """
                Autor: %s
                Titulo: %s
                Preço: R$%.2f
                Ano de Criação: %d
                Edição: %d
                """,
                super.autor,
                super.titulo,
                super.preco,
                super.anoDeCriacao,
                this.edicao
        );
    }
}
