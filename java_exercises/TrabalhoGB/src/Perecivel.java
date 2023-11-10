public class Perecivel  extends  Produto {
    private Data dataValidade;

    public Perecivel(String nome, String descricao, double valor, Data validade) {
        super(nome, descricao, valor);
        this.dataValidade = validade;
    }

    public boolean isVencido(Data agora) {

        return agora.getAno() > this.dataValidade.getAno()
                || agora.getMes() > this.dataValidade.getMes()
                || agora.getDia() > this.dataValidade.getDia();
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    @Override
    public String toString() {
        return String.format(
            """
            =================================================================
                                  PRODUTO PERECIVEL
            =================================================================
            * NOME: %s
            * DESCRIÇÃO: %s
            * VALOR: %.2f
            * DATA VALIDADE: (%s)
            =================================================================
            """, super.nome, super.descricao, super.valor, this.dataValidade
        );
    }
}
