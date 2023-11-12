public class Melancia extends Fruta {
    private double precoAdicional;
    private boolean isEpoca;

    public Melancia(String nome, double preco, double precoAdicional, boolean isEpoca) {
        super(nome, preco);
        this.precoAdicional = precoAdicional;
        this.isEpoca = isEpoca;
    }

    public double calculaPrecoFinal() {
        double preco = super.getPreco();

        if (!this.isEpoca) {
            return preco;
        }

        return preco + this.precoAdicional;
    }

    public double getPrecoAdicional() {
        return precoAdicional;
    }

    public void setPrecoAdicional(double precoAdicional) {
        this.precoAdicional = precoAdicional;
    }

    public boolean isEpoca() {
        return isEpoca;
    }

    public void setEpoca(boolean epoca) {
        isEpoca = epoca;
    }
}
