public class Chef {
    private String nome;
    private int idade;
    private Receita receita1, receita2;

    public Chef() {

    }

    public Chef(String nome, int idade, Receita receita1, Receita receita2) {
        this.nome = nome;
        this.idade = idade;
        this.receita1 = receita1;
        this.receita2 = receita2;
    }

    public String getNome() {
        return nome;
    }

    public int getIdade() {
        return idade;
    }

    public Receita getReceita1() {
        return receita1;
    }

    public Receita getReceita2() {
        return receita2;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setReceita1(Receita receita1) {
        this.receita1 = receita1;
    }

    public void setReceita2(Receita receita2) {
        this.receita2 = receita2;
    }

    public String toString() {
        int delimiterLength = 15;
        String defaultDelimiter = "=".repeat(delimiterLength);
        String customDelimiter = "=".repeat(delimiterLength * 2);

        return String.format(
            """
            
            %s CHEF %s
            NOME: %s
            IDADE: %d
            %s RECEITAS %s
            %s
            
            %s
            %s
            
            """,
            defaultDelimiter,
            defaultDelimiter,
            this.nome,
            this.idade,
            defaultDelimiter,
            defaultDelimiter,
            this.receita1,
            this.receita2,
            customDelimiter
        );
    }
}
