public class Programador extends Pessoa {
    private String linguaguem;

    public Programador(String nome, int idade, String linguaguem) {
        super(nome, idade);
        this.linguaguem = linguaguem;
    }

    public String getLinguaguem() {
        return linguaguem;
    }

    public void setLinguaguem(String linguaguem) {
        this.linguaguem = linguaguem;
    }

    @Override
    public void imprimeDados() {
        System.out.printf("Programador(Nome: %s, Idade: %d, Linguagem Favorita: %s)%n", super.getNome(), super.getIdade(), this.linguaguem);
    }

}
