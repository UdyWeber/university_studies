public class Livro {
    protected String titulo, autor;
    protected double preco;
    protected int anoDeCriacao;

    public Livro(String titulo, String author, double preco, int anoDeCriacao) {
        this.titulo = titulo;
        this.autor = author;
        this.preco = preco;
        this.anoDeCriacao = anoDeCriacao;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getAnoDeCriacao() {
        return anoDeCriacao;
    }

    public void setAnoDeCriacao(int anoDeCriacao) {
        this.anoDeCriacao = anoDeCriacao;
    }

    @Override
    public String toString() {
        return String.format(
                """
                Autor: %s
                Titulo: %s
                Preço: R$%.2f
                Ano de Criação: %d
                """,
                this.autor,
                this.titulo,
                this.preco,
                this.anoDeCriacao
        );
    }
}
