public class Prateleira {
    private Produto prod1, prod2, prod3;

    public Prateleira() {}
    public Prateleira(Produto prod1, Produto prod2, Produto prod3) {
        this.prod1 = prod1;
        this.prod2 = prod2;
        this.prod3 = prod3;
    }

    public Produto getProd1() {
        return prod1;
    }

    public Produto getProd2() {
        return prod2;
    }

    public Produto getProd3() {
        return prod3;
    }

    public void setProd1(Produto prod1) {
        this.prod1 = prod1;
    }

    public void setProd2(Produto prod2) {
        this.prod2 = prod2;
    }

    public void setProd3(Produto prod3) {
        this.prod3 = prod3;
    }

    public boolean isEmpty() {
        return prod1 == null && prod2 == null && prod3 == null;
    }

    public int qtdProdutos() {
        int qtd = 0;

        if (prod1 != null) qtd++;
        if (prod2 != null) qtd++;
        if (prod3 != null) qtd++;

        return qtd;
    }

    public double totalValue() {
        double priceProd1 = prod1 != null ? prod1.getPreco() : 0;
        double priceProd2 = prod2 != null ? prod2.getPreco() : 0;
        double priceProd3 = prod3 != null ? prod3.getPreco() : 0;

        return priceProd1 + priceProd2 + priceProd3;
    }

    public Produto produtoMaisCaro() {
        if (!this.isEmpty()) {
            double priceProd1 = prod1 != null ? prod1.getPreco() : 0;
            double priceProd2 = prod2 != null ? prod2.getPreco() : 0;
            double priceProd3 = prod3 != null ? prod3.getPreco() : 0;

            if (priceProd1 == priceProd2 && priceProd2 == priceProd3) {
                return null;
            }
            else if (priceProd1 > priceProd2 && priceProd1 > priceProd3) {
                return prod1;
            } else if (priceProd2 > priceProd3 && priceProd2 > priceProd1) {
                return  prod2;
            } else if (priceProd3 > priceProd2 && priceProd3 > priceProd1) {
                return prod3;
            }
        }

        return null;
    }

    public String toString() {
        String delimiter = "-".repeat(35);

        return String.format(
            """
            %s
            %s
            %s
            %s
            %s
            """,delimiter, prod1, prod2, prod3, delimiter
        );
    }
}
