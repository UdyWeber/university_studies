public class Pessoa {
    private String nome;
    private TeleSena[] teleSenas;

    private double valorPremiacao;

    public Pessoa(String nome) {
        this.nome = nome;
        this.valorPremiacao = 0;
    }

    /** Faz a checagem de todas as Tele Senas do participante para ver se ele é um dos vencedores **/
    public boolean isVencedor(int numeroSortedo) {
        for (int t = 0; t < this.teleSenas.length; t++ ) {
            TeleSena teleSena = this.teleSenas[t];

            if (teleSena == null) {
                continue;
            }

            // Faz a apuração dos pontos antes de checar se é o ganhador
            teleSena.atualizaAcertos(numeroSortedo);

            if (teleSena.isPremiada()) {
                return true;
            }
        }

        return false;
    }

    public String getNome() {
        return nome;
    }

    public void setTeleSenas(TeleSena[] teleSenas) {
        this.teleSenas = teleSenas;
    }

    // TODO: Utilizar isso para carregar o valor final da premiação para cada vencedor
    public void setValorPremiacao(double valorPremiacao) {
        this.valorPremiacao = valorPremiacao;
    }
}
