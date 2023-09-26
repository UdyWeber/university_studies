public class Produto {
    private String name;
    private double preco;
    private Data dataValidade;

    public Produto(String name, double preco, Data dataValidade) {
        this.name = name;
        this.preco = preco;
        this.dataValidade = dataValidade;
    }

    public String getName() {
        return name;
    }

    public double getPreco() {
        return preco;
    }

    public Data getDataValidade() {
        return dataValidade;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setDataValidade(Data dataValidade) {
        this.dataValidade = dataValidade;
    }

    public boolean verificaProdutoVencido(Data checkData) {
        // Versao nova
        int checkYear = checkData.getYear();
        int checkMonth = checkData.getMonth();
        int checkDay = checkData.getDay();

        int actualYear = this.dataValidade.getYear();
        int actualMonth = this.dataValidade.getMonth();
        int actualDay = this.dataValidade.getDay();

        if (checkYear > actualYear) {
            return true;
        } else if (checkYear == actualYear) {
            if (checkMonth > actualMonth) {
                return true;
            } else if (checkMonth == actualMonth) {
                return checkDay > actualDay;
            }
        }

        return false;
    }

    public String toString() {
        String delimiter = "=".repeat(35);

        return String.format(
            """
            %s
            * Nome do Produto: %s
            * Preço: %.2f
            * Data de Validade: %s
            %s
            """, delimiter, name, preco, dataValidade, delimiter
        );
    }
}
