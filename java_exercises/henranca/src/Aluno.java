public class Aluno extends Pessoa {
    private double nota;

    public Aluno(String nome, int idade, double nota) {
        super(nome, idade);
        this.nota = nota;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public void imprimeDados() {
        System.out.printf("Aluno(Nome: %s, Idade: %d, Nota: %.2f)%n", super.getNome(), super.getIdade(), this.nota);
    }
}
