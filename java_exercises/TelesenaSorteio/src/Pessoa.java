public class Pessoa {
    private String nome;
    private TeleSena[] teleSenas;

    private double valorPremiacao;

    public Pessoa(String nome) {
        this.nome = nome;
        this.valorPremiacao = 0;
    }

    public boolean isVencedor(int numeroSortedo) {
        for (int t = 0; t < this.teleSenas.length; t++ ) {
            TeleSena teleSena = this.teleSenas[t];
            teleSena.atualizaAcertos(numeroSortedo);

            if (teleSena.getAcertos1() == 25 || teleSena.getAcertos2() == 25) {
                return true;
            }
        }

        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TeleSena[] getTeleSenas() {
        return teleSenas;
    }

    public void setTeleSenas(TeleSena[] teleSenas) {
        this.teleSenas = teleSenas;
    }

    public double getValorPremiacao() {
        return valorPremiacao;
    }

    public void setValorPremiacao(double valorPremiacao) {
        this.valorPremiacao = valorPremiacao;
    }
}
