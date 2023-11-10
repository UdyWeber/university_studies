public class NaoPerecivel extends Produto {
    private Data dataFabricacao;

    public NaoPerecivel(String nome, String descricao, double valor, Data dataFabricacao) {
        super(nome, descricao, valor);
        this.dataFabricacao = dataFabricacao;
    }

    public Data getDataFabricacao() {
        return dataFabricacao;
    }

    public void setDataFabricacao(Data dataFabricacao) {
        this.dataFabricacao = dataFabricacao;
    }

    @Override
    public String toString() {
        return String.format(
            """
            =================================================================
                                 PRODUTO NÃO PERECIVEL
            =================================================================
            * NOME: %s
            * DESCRIÇÃO: %s
            * VALOR: %.2f
            * DATA FABRICAÇÃO: (%s)
            =================================================================
            """, super.nome, super.descricao, super.valor, this.dataFabricacao
        );
    }
}
