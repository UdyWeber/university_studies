public abstract class Animal {
    private String nome;
    private int idade;
    private double valor;

    public Animal(String nome, int idade, double valor) {
        this.nome = nome;
        this.idade = idade;
        this.valor = valor;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public abstract String emitirSom();
    public abstract Boolean isAdulto();
}
