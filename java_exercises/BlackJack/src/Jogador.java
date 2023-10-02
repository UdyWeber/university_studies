public class Jogador {
    private String nome;
    private int pontos;
    private Dado dadoVemelho, dadoBranco;

    public Jogador(String name, Dado dadoVermelho, Dado dadoBranco) {
        this.nome = name;
        this.pontos = 0;
        this.dadoVemelho = dadoVermelho;
        this.dadoBranco = dadoBranco;
    }

    /**
     * Roda os dados do jogador e soma os respectivos valores à pontuação do jogador.
     */
    public void rodarDados() {
        System.out.println();

        int valorDadoBranco = dadoBranco.jogaDado();

        System.out.println(Cores.BRANCO + "Valor do dado branco: " + valorDadoBranco);
        this.pontos += valorDadoBranco;

        int valorDadoVermelho = dadoVemelho.jogaDado();

        System.out.println(Cores.VERMELHO + "Valor do dado vermelho: " + valorDadoVermelho);
        this.pontos += valorDadoVermelho;

        System.out.println();
    }

    public String getNome() {
        return nome;
    }

    public Dado getDadoVemelho() {
        return dadoVemelho;
    }

    public Dado getDadoBranco() {
        return dadoBranco;
    }

    public int getPontos() {
        return pontos;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public void setDadoVemelho(Dado dadoVemelho) {
        this.dadoVemelho = dadoVemelho;
    }

    public void setDadoBranco(Dado dadoBranco) {
        this.dadoBranco = dadoBranco;
    }
}
