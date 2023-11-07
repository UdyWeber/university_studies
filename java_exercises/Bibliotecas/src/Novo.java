public class Novo extends Livro {
    private double desconto;

    public Novo(String titulo, String author, double preco, int anoDeCriacao, double desconto) {
        super(titulo, author, preco, anoDeCriacao);
        this.desconto = desconto;
    }

    public double getDesconto() {
        return desconto;
    }

    public void setDesconto(double desconto) {
        this.desconto = desconto;
    }

    @Override
    public String toString() {
        return String.format(
                """
                Autor: %s
                Titulo: %s
                Preço: R$%.2f
                Ano de Criação: %d
                Descontro: %.2f
                """,
                super.autor,
                super.titulo,
                super.preco,
                super.anoDeCriacao,
                this.desconto
        );
    }

}
