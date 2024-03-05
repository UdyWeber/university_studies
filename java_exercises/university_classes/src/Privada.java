public class Privada extends Universidade {
    protected double mensalidade;

    public Privada(String nome, String endereco, int qtdAlunos, int qtdProfessores, double mensalidade) {
        super(nome, endereco, qtdAlunos, qtdProfessores);
        this.mensalidade = mensalidade;
    }

    public Privada(Universidade u, double mensalidade) {
        super(u.nome, u.endereco, u.qtdAlunos, u.qtdProfessores);
        this.mensalidade = mensalidade;
    }

    public void adicionaMensalidade(double maisMensalidade) {
        this.mensalidade += maisMensalidade;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.printf("Mensalidade da facul: R$%.2f", this.mensalidade);
    }

    public double getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(double mensalidade) {
        this.mensalidade = mensalidade;
    }
}
