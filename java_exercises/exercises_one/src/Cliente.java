public class Cliente {
    private String nome, sexo, email, senha;
    private int idade;
    private Livro livroCliente;

    public Cliente() {}

    public Cliente(
        String email,
        String senha,
        String nome
    ) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
    }

    public Cliente(
        String email,
        String nome,
        String sexo,
        String senha,
        int idade,
        Livro livroCliente
    ) {
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sexo = sexo;
        this.idade = idade;
        this.livroCliente = livroCliente;
    }

    public void imprimeInformacoes() {
        if (this.email != null && this.senha != null) {
            System.out.printf(
                """
                    Nome: %s
                    Email: %s
                    Senha: %s
                    Sexo: %s
                    idade: %d
                    lendo livro: %s
                    \n
                    """,
                this.nome,
                this.email,
                "*".repeat(this.senha.length()),
                this.sexo,
                this.idade,
                this.livroCliente != null ? this.livroCliente.getTitulo() : "Nenhum no momento!"
            );
        } else {
            System.out.println("AVISO: Informações do client não definidas no momento!\n");
        }
    }

    public int getIdade() {
        return idade;
    }

    public Livro getLivroCliente() {
        return livroCliente;
    }

    public String getEmail() {
        return email;
    }

    public String getNome() {
        return nome;
    }

    public String getSenha() {
        return senha;
    }

    public String getSexo() {
        return sexo;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setLivroCliente(Livro livroCliente) {
        this.livroCliente = livroCliente;
    }

    public String toString() {
        if (this.email != null) {
            return String.format("Cliente(%s)", this.email);
        }

        return "Cliente()";
    }
}
