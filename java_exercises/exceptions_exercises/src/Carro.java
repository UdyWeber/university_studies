public class Carro {
    private final int qtdMaxGasolina = 100;
    private int qtdGasolina, kmPorLitro;

    public Carro(int qtdGasolina, int kmPorLitro) {
        this.qtdGasolina = qtdGasolina;
        this.kmPorLitro = kmPorLitro;
    }

    public void encherTanque(int qtd) throws TanqueCheioException {
        if ((this.qtdGasolina + qtd) > qtdMaxGasolina ) {
            throw new TanqueCheioException(qtdMaxGasolina - qtdGasolina);
        }

        this.qtdGasolina += qtd;
    }

    public int distanciaPossivel() {
        return kmPorLitro * qtdGasolina;
    }

    public int combustivelGasto(int kilometros) {
        return kilometros / kmPorLitro;
    }

    public void andar(int kilometros) throws TanqueVazioException, TanqueInsuficienteException {
        if (qtdGasolina <= 0) {
            throw new TanqueVazioException();
        }

        if (kilometros > distanciaPossivel()) {
            throw new TanqueInsuficienteException();
        }

        int gasto = combustivelGasto(kilometros);
        this.qtdGasolina -= gasto;
        System.out.printf("Carro gastou %d litros, nivel atual %d\n", gasto, this.qtdGasolina);
     }

    public int getQtdMaxGasolina() {
        return qtdMaxGasolina;
    }

    public int getQtdGasolina() {
        return qtdGasolina;
    }

    public void setQtdGasolina(int qtdGasolina) {
        this.qtdGasolina = qtdGasolina;
    }

    public int getKmPorLitro() {
        return kmPorLitro;
    }

    public void setKmPorLitro(int kmPorLitro) {
        this.kmPorLitro = kmPorLitro;
    }
}
