public class Publica extends Universidade {
    protected int qtdConcursados;

    public Publica(String nome, String endereco, int qtdAlunos, int qtdProfessores, int qtdConcursados) {
        super(nome, endereco, qtdAlunos, qtdProfessores);
        this.qtdConcursados = qtdConcursados;
    }

    public Publica(Universidade u, int qtdConcursados) {
        super(u.nome, u.endereco, u.qtdAlunos, u.qtdProfessores);
        this.qtdConcursados = qtdConcursados;
    }

    public void adicionaConcursados() {
        this.qtdConcursados++;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Quantidade de alunos concursados: %d\n", this.qtdConcursados);
    }

    public int getQtdConcursados() {
        return qtdConcursados;
    }

    public void setQtdConcursados(int qtdConcursados) {
        this.qtdConcursados = qtdConcursados;
    }
}
