public class Livro{
    private String titulo, autor;
    private int anoPublicacao, paginas;
    private double preco;

    public Livro() {}

    public Livro(
        String titulo,
        String autor,
        int anoPublicacao,
        int paginas,
        double preco
    ) {
        this.titulo = titulo;
        this.autor = autor;
        this.anoPublicacao = anoPublicacao;
        this.paginas = paginas;
        this.preco = preco;
    }

    public double calcularPrecoPorPagina() {
        return this.preco / this.paginas;
    }

    public String toString() {
        return String.format(
            """
            %s
                   %s
            %s
            Autor: %s
            Páginas: %d
            Preço: %.2f
            Preço por página: %.2f
            %s
            """,
            "=".repeat(30),
            this.titulo,
            "=".repeat(30),
            this.autor,
            this.paginas,
            this.preco,
            this.calcularPrecoPorPagina(),
            "=".repeat(30)
        );
    }

    public String getTitulo() {
        return this.titulo;
    }
    public String getAutor() {
        return this.autor;
    }
    public int getAnoPublicacao() {
        return this.anoPublicacao;
    }
    public int getPaginas() {
        return this.paginas;
    }
    public double getPreco() {
        return this.preco;
    }

    public void setTitulo(String newTitulo) {
        this.titulo = newTitulo;
    }
    public void setAutor(String newAutor) {
        this.autor = newAutor;
    }
    public void setAnoPublicacao(int newAnoPublicacao) {
        this.anoPublicacao = newAnoPublicacao;
    }
    public void setPaginas(int newPaginas) {
        this.paginas = newPaginas;
    }
    public void setPreco(double newPreco) {
        this.preco = newPreco;
    }
}
