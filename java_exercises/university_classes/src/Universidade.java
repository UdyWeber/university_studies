public class Universidade {
    protected String nome, endereco;
    protected int qtdAlunos, qtdProfessores;

    public Universidade(String nome, String endereco,  int qtdAlunos, int qtdProfessores) {
        this.nome = nome;
        this.endereco = endereco;
        this.qtdAlunos = qtdAlunos;
        this.qtdProfessores = qtdProfessores;
    }

    public void printInfo() {
        System.out.printf(
            "Universidade: %s tem %d professores e %d alunos.\nLocalizada em: %s\n",
            this.nome, this.qtdProfessores, this.qtdAlunos, this.endereco);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public int getQtdAlunos() {
        return qtdAlunos;
    }

    public void setQtdAlunos(int qtdAlunos) {
        this.qtdAlunos = qtdAlunos;
    }

    public int getQtdProfessores() {
        return qtdProfessores;
    }

    public void setQtdProfessores(int qtdProfessores) {
        this.qtdProfessores = qtdProfessores;
    }
}
