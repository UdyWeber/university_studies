public class Mercado {
    private Prateleira prat1, prat2;

    public Mercado(Prateleira prat1, Prateleira prat2) {
        this.prat1 = prat1;
        this.prat2 = prat2;
    }

    public Prateleira getPrat1() {
        return prat1;
    }

    public Prateleira getPrat2() {
        return prat2;
    }

    public double mediaValorProdutos() {
        return (prat1.totalValue() + prat2.totalValue()) / (prat1.qtdProdutos() + prat2.qtdProdutos());
    }
}
